package StackTrace.VirtualWallet.Transaccion;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import StackTrace.VirtualWallet.Transferencia;
import StackTrace.VirtualWallet.Billetera.Billetera;
import StackTrace.VirtualWallet.Billetera.BilleteraRepository;
import StackTrace.VirtualWallet.Divisa.Divisa;
import StackTrace.VirtualWallet.Divisa.DivisaRepository;
import StackTrace.VirtualWallet.Usuario.Usuario;
import StackTrace.VirtualWallet.Usuario.UsuarioRepository;

@Service
public class TransaccionService {
    
    private final TransaccionRepository transaccionRepository;
    private final UsuarioRepository usuarioRepository;
    private final BilleteraRepository billeteraRepository;
    private final DivisaRepository divisaRepository;

    @Autowired
    private TransaccionService(TransaccionRepository transaccionRepository,UsuarioRepository usuarioRepository,BilleteraRepository billeteraRepository,DivisaRepository divisaRepository){
        this.transaccionRepository = transaccionRepository;
        this.usuarioRepository = usuarioRepository;
        this.billeteraRepository = billeteraRepository;
        this.divisaRepository = divisaRepository;
    }

    public List<Transaccion> getTransacciones(){
        return transaccionRepository.findAll();
    }

    public void postTransaccion(Transferencia transferencia){
        String dni = transferencia.getDni();
        String contraseña = transferencia.getContraseña();
        UUID emisor = transferencia.getCvu_emisor();
        UUID receptor = transferencia.getCvu_receptor();
        Float cantidad = transferencia.getSaldo();
        String moneda_enviada = transferencia.getTipo_moneda_emisor();
        String moneda_recibida = transferencia.getTipo_moneda_receptor();
        
        Optional<Usuario> dniUsuario = usuarioRepository.findById(dni);
        Optional<Usuario> contraseñaUsuario = usuarioRepository.findUsuarioByContraseña(contraseña);
        Optional<Billetera> billeteraEmisora = billeteraRepository.findById(emisor);
        Optional<Billetera> billeteraReceptora = billeteraRepository.findById(receptor);

        if(dniUsuario.get()==contraseñaUsuario.get()&&billeteraEmisora.isPresent()&&billeteraReceptora.isPresent()){
            List<Divisa> divisas = divisaRepository.findAllById(billeteraEmisora.get().getDivisas());
            List<Divisa> divisaRecibida = divisaRepository.findByNombre(moneda_recibida);
            if(divisas.size()!=0||divisaRecibida.get(0)!=null){
                for(var i=0;i<divisas.size();i++){ 
                    if(divisas.get(i).getNombre().equals(moneda_enviada)){
                        if(divisas.get(i).getCantidad()-cantidad>0){
                            divisas.get(i).setCantidad(divisas.get(i).getCantidad()-cantidad);
                            divisaRepository.save(divisas.get(i));
                            billeteraEmisora.get().setSaldo(billeteraEmisora.get().getSaldo()-divisas.get(i).getCantidad()*divisas.get(i).getValor_pesos());
                            billeteraRepository.save(billeteraEmisora.get());
                            Transaccion envio = new Transaccion("transfirio",cantidad,moneda_enviada);
                            envio.setBilleteraEmisora(emisor);
                            envio.setBilleteraReceptora(receptor);
                            transaccionRepository.save(envio);
                            Transaccion recepcion = new Transaccion("recibio",cantidad,moneda_recibida);
                            envio.setBilleteraEmisora(emisor);
                            envio.setBilleteraReceptora(receptor);
                            transaccionRepository.save(recepcion);
                            Divisa divisaEnviada = new Divisa(moneda_recibida,divisaRecibida.get(0).getValor_pesos(),cantidad);
                            divisaRepository.save(divisaEnviada);
                            billeteraEmisora.get().setEmiciones(envio.getId());
                            billeteraReceptora.get().setRecepciones(recepcion.getId());
                            billeteraReceptora.get().setDivisas(divisaEnviada.getId());
                            billeteraReceptora.get().setSaldo(billeteraReceptora.get().getSaldo()+divisaEnviada.getCantidad()*divisaEnviada.getValor_pesos());
                            billeteraRepository.save(billeteraEmisora.get());
                            billeteraRepository.save(billeteraReceptora.get());
                            break;
                        }
                    }
                }
            }else{
                throw new IllegalStateException("no puede realizar esta transaccion");
            }
        }else{
            throw new IllegalStateException("datos incorrectos");
        }
    }
}
