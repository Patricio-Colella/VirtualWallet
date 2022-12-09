package StackTrace.VirtualWallet.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import StackTrace.VirtualWallet.Billetera.BilleteraRepository;
import StackTrace.VirtualWallet.BilleteraSaldo;
import StackTrace.VirtualWallet.UsuarioBilletera;
import StackTrace.VirtualWallet.Billetera.Billetera;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final BilleteraRepository billeteraRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, BilleteraRepository billeteraRepository){
        this.usuarioRepository = usuarioRepository;
        this.billeteraRepository = billeteraRepository;
    }

    public List<Usuario> getUsuarios(){
        return usuarioRepository.findAll();
    }

    public void postUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    public UsuarioBilletera getUsuarioById(String idUsuario,String contraseña){

        Optional<Usuario> usuarioDni = usuarioRepository.findById(idUsuario) ;
        Optional<Usuario> usuarioContraseña = usuarioRepository.findUsuarioByContraseña(contraseña) ;

        if(usuarioDni.isPresent()&&usuarioContraseña.isPresent()&&usuarioContraseña.get().getDni()==usuarioDni.get().getDni()){
            Usuario findedUsuario = usuarioContraseña.get();
            List<Billetera> billeteras = billeteraRepository.findAllById(findedUsuario.getBilleteras());

            return new UsuarioBilletera(findedUsuario, billeteras);
        }else{
            throw new IllegalStateException("contraseña o dni incorrectos");
        }
    }

    public void putUsuario(Usuario usuario,String dni){

        Optional<Usuario> optionalUsuario = usuarioRepository.findById(dni);

        if(optionalUsuario.isPresent()){
            Usuario _usuario = optionalUsuario.get();
            _usuario.setGenero(usuario.getGenero());
            _usuario.setNombre(usuario.getNombre());
            _usuario.setApellido(usuario.getApellido()); 
            _usuario.setEmail(usuario.getEmail()); 
            _usuario.setTelefono(usuario.getTelefono()); 
            usuarioRepository.save(_usuario);
        }
    }

    public void deleteUser(String dni){
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(dni);

        if(optionalUsuario.isPresent()){
            usuarioRepository.delete(optionalUsuario.get());
            List<Billetera> billeteras = billeteraRepository.findAllById(optionalUsuario.get().getBilleteras());
            billeteraRepository.deleteAll(billeteras);
        }else{
            throw new IllegalStateException("no hay usuario con esa id");
        }
    }

    public List<Billetera> getUsuarioBilleteras(String dni,String contraseña){
        Optional<Usuario> usuarioDni = usuarioRepository.findById(dni) ;
        Optional<Usuario> usuarioContraseña = usuarioRepository.findUsuarioByContraseña(contraseña) ;

        if(usuarioDni.isPresent()&&usuarioContraseña.isPresent()&&usuarioContraseña.get().getDni()==usuarioDni.get().getDni()){
            Usuario findedUsuario = usuarioContraseña.get();
            System.out.println("------bien 2----");

            List<Billetera> billeteras = billeteraRepository.findAllById(findedUsuario.getBilleteras());
            
            return billeteras;
        }else{
            throw new IllegalStateException("contraseña o dni incorrectos");
        }
    }
}


