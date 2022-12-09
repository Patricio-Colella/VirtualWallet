package StackTrace.VirtualWallet.Billetera;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import StackTrace.VirtualWallet.BilleteraSaldo;
import StackTrace.VirtualWallet.Divisa.Divisa;
import StackTrace.VirtualWallet.Divisa.DivisaRepository;
import StackTrace.VirtualWallet.Transaccion.Transaccion;
import StackTrace.VirtualWallet.Transaccion.TransaccionRepository;
import StackTrace.VirtualWallet.Usuario.Usuario;
import StackTrace.VirtualWallet.Usuario.UsuarioRepository;

@Service
public class BilleteraService {

    private final BilleteraRepository billeteraRepository;
    private final UsuarioRepository usuarioRepository;
    private final DivisaRepository divisaRepository;
    private final TransaccionRepository transaccionRepository;

    @Autowired
    public BilleteraService(BilleteraRepository billeteraRepository, UsuarioRepository usuarioRepository, DivisaRepository divisaRepository,TransaccionRepository transaccionRepository){
        this.billeteraRepository = billeteraRepository;
        this.usuarioRepository = usuarioRepository;
        this.divisaRepository = divisaRepository;
        this.transaccionRepository = transaccionRepository;
    }

    public List<Billetera> getBilleteras(){
        return billeteraRepository.findAll();
    }

    public void postBilletera(String dniUsuario){

        Optional<Usuario> usuario = usuarioRepository.findById(dniUsuario);
        if(usuario.isPresent()){
            Billetera _billetera = new Billetera(dniUsuario);
            usuario.get().setBilleteras(_billetera.getCvu());
            billeteraRepository.save(_billetera);
        }else{
            throw new IllegalStateException("usuario con ese dni no existe");
        }
    }

    public void deleteBilletera(UUID cvu){
        Optional<Billetera> optionalBilletera = billeteraRepository.findById(cvu);

        if(optionalBilletera.isPresent()){
            billeteraRepository.delete(optionalBilletera.get());
        }else{
            throw new IllegalStateException("no hay billetera con esa cvu");
        }
    }

    public void putBilletera(UUID cvu,String contraseña,String dni,Float saldo,String tipodivisa){

        Optional<Usuario> usuarioDni = usuarioRepository.findById(dni) ;
        Optional<Usuario> usuarioContraseña = usuarioRepository.findUsuarioByContraseña(contraseña) ;

        if(usuarioDni.isPresent()&&usuarioContraseña.isPresent()&&usuarioContraseña.get().getDni()==usuarioDni.get().getDni()){
            
            Optional<Billetera> billetera = billeteraRepository.findById(cvu);

            if(billetera.isPresent()){
                Billetera _billetera = billetera.get();
                List<Divisa> divisas=divisaRepository.findAllById(_billetera.getDivisas());
                float divisaSaldoExistente;

                if(divisas.size()==0){
                    List<Divisa> divisa = divisaRepository.findByNombre(tipodivisa);
                    if(divisa.get(0)!=null){
                        Divisa newDivisa = new Divisa(tipodivisa,divisa.get(0).getValor_pesos(),saldo);
                        divisaRepository.save(newDivisa);
                        _billetera.setDivisas(newDivisa.getId());
                    }else{
                        throw new IllegalStateException("no se permite esa divisa");
                    }
                }else{
                    for(var i = 0;i<divisas.size();i++){
                        if(divisas.get(i).getNombre()==tipodivisa){
                            divisaSaldoExistente = divisas.get(i).getCantidad()+saldo;
                            divisas.get(i).setCantidad(divisaSaldoExistente);
                            divisaRepository.save(divisas.get(i));
                            break;
                        }
                        if(i==divisas.size()-1){
                            List<Divisa> divisa = divisaRepository.findByNombre(tipodivisa);
                            if(divisa.get(0)!=null){
                                Divisa newDivisa = new Divisa(tipodivisa,divisa.get(0).getValor_pesos(),saldo);
                                divisaRepository.save(newDivisa);
                                _billetera.setDivisas(newDivisa.getId());
                            }else{
                                throw new IllegalStateException("no se permite esa divisa");
                            }
                        }
                    }
                }
                Float newsaldoexistente = 0F;
                List<Divisa> newDivisas=divisaRepository.findAllById(_billetera.getDivisas());
                for(var i = 0;i<newDivisas.size();i++){
                    newsaldoexistente = newsaldoexistente+newDivisas.get(i).getCantidad()*newDivisas.get(i).getValor_pesos();
                }
                _billetera.setSaldo(newsaldoexistente);
                Transaccion deposito = new Transaccion("deposito",saldo,tipodivisa);
                deposito.setBilleteraEmisora(cvu);
                deposito.setBilleteraReceptora(cvu);
                transaccionRepository.save(deposito);
                _billetera.setRecepciones(deposito.getId());
                billeteraRepository.save(_billetera);
            }else{
                throw new IllegalStateException("cvu incorrecto");
            }
        }else{
            throw new IllegalStateException("contraseña o dni incorrectos");
        }
    }

    public BilleteraSaldo getBilleteraByCvu (UUID cvu){
        Optional<Billetera> billetera = billeteraRepository.findById(cvu);
        if(billetera.isPresent()){
            return new BilleteraSaldo(billetera.get().getCvu(),billetera.get().getSaldo());
        }else{
            throw new IllegalStateException("no existe billetera con esa cvu");
        }
    }

}
