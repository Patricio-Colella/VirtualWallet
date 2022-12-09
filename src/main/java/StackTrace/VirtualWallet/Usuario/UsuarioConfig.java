package StackTrace.VirtualWallet.Usuario;

import java.util.List;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {
    
    @Bean
    CommandLineRunner commandLineRunnerUsuario(UsuarioRepository repository){
        return args->{
            Usuario pato = new Usuario(
                "42644439",
                "hombre",
                "patricio",
                "colella",
                "pato@gmail.com",
                "2664277765",
                "42644439",
                List.of(UUID.fromString("52e510a5-c1bf-4181-ab34-021970ae3473"),UUID.fromString("52e510a5-c1bf-4181-ab34-021970ae3472"))
            );

            Usuario melisa = new Usuario(
                "28843615",
                "mujer",
                "melisa",
                "colella",
                "melisa@gmail.com",
                "2664329957",
                "$xyzpass",
                List.of(UUID.fromString("52e510a5-c1bf-4181-ab34-021970ae3471"))
            );

            Usuario test = new Usuario(
                "dni test",
                "hombre",
                "nombre falso",
                "apellido falso",
                "emailfalso@gmail.com",
                "22334455",
                "testpass123"
            );

            repository.saveAll(
                List.of(pato,melisa,test)
            );
        };
    }
}
