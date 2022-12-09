package StackTrace.VirtualWallet.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import StackTrace.VirtualWallet.UsuarioBilletera;
import StackTrace.VirtualWallet.Billetera.Billetera;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path="api/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> getUsuarios(){
        return  usuarioService.getUsuarios();
    }

    @GetMapping(path = "/misBilleteras/{idUsuario}")
    private List<Billetera> getUsuarioBilleteras(@PathVariable(required=false,name="idUsuario") String idUsuario, @RequestParam(required=false) Map<String,String> qparams){

        if(idUsuario.isEmpty()){
            throw new IllegalStateException("falta dni del usuario");
        }
        String contraseña = qparams.get("contraseña");
        if(contraseña.isEmpty()){

            throw new IllegalStateException("falta contraseña");
        }

        return usuarioService.getUsuarioBilleteras(idUsuario,contraseña);
    }

    @PostMapping
    public void postUsuario(@RequestBody Usuario usuario){
        if(usuario.getClass()!=Usuario.class){
            throw new IllegalStateException("datos incorrectos");
        }
        usuarioService.postUsuario(usuario);
    }

    @GetMapping(path = "/{idUsuario}")
    private UsuarioBilletera getUserById(@PathVariable(required=false,name="idUsuario") String idUsuario,@RequestParam(required=false) Map<String,String> qparams){
        String contraseña = qparams.get("contraseña");
        if(contraseña.isEmpty()){
            throw new IllegalStateException("falta contraseña");
        }
        return usuarioService.getUsuarioById(idUsuario, contraseña);
    }

    @PutMapping(path = "/{idUsuario}")
    public void putUsuario(@RequestBody Usuario usuario,@PathVariable(required=false,name="idUsuario") String idUsuario){
        if(usuario.getClass()!=Usuario.class){
            throw new IllegalStateException("datos incorrectos");
        }
        usuarioService.putUsuario(usuario,idUsuario);
    }

    @DeleteMapping(path = "/{idUsuario}")
    private void deleteUser(@PathVariable(required=false,name="idUsuario") String idUsuario){

        if(idUsuario.isEmpty()){
            throw new IllegalStateException("falta dni del usuario");
        }
        usuarioService.deleteUser(idUsuario);
    }

}
