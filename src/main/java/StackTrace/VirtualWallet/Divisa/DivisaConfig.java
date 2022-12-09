package StackTrace.VirtualWallet.Divisa;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DivisaConfig {
    
    @Bean
    CommandLineRunner commandLineRunnerDivisa(DivisaRepository repository){
        return args->{
            Divisa btc = new Divisa(
                "btc",
                20.00F

            );
            
            Divisa eth = new Divisa(
                "eth",
                5.0F
            );

            repository.saveAll(
                List.of(btc,eth)
            );
        };
    }
}
