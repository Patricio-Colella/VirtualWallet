package StackTrace.VirtualWallet.Usuario;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {
    
    @Bean
    CommandLineRunner commandLineRunnerUsuario(UsuarioRepository repository){
        return args->{
            // new Usuario();
            Usuario pato = new Usuario(
                "42644439",
                "hombre",
                "pato",
                "colella",
                "pato@gmail.com",
                "2664277765",
                "42644439"
            );

            repository.saveAll(
                List.of(pato)
            );
        };
    }
}
