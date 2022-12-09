package StackTrace.VirtualWallet.Transaccion;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransaccionConfig {
    
    @Bean
    CommandLineRunner commandLineRunnerTransaccion(TransaccionRepository repository){
        return args->{
        };
    }
}
