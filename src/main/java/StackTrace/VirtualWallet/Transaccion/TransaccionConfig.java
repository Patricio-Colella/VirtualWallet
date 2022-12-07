package StackTrace.VirtualWallet.Transaccion;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransaccionConfig {
    
    @Bean
    CommandLineRunner commandLineRunnerTransaccion(TransaccionRepository repository){
        return args->{
            Transaccion tr_n1 = new Transaccion(
                "tipo op 1",
                "eth",
                "btc"
            );

            repository.saveAll(
                List.of(tr_n1)
            );
        };
    }
}
