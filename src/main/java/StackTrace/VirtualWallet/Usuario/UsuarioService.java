package StackTrace.VirtualWallet.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> getUsuarios(String id,Map <String,String> params){
        System.out.println(id);
        System.out.println(params);
        
        return usuarioRepository.findAll();
    }

    public void postUsuario(Usuario usuario){
        System.out.println(usuario);
        // System.out.println(p);
        // return usuarioRepository.save()
    }
}
