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
                "BTC",
                100.00F
            );
            
            Divisa eth = new Divisa(
                "ETH",
                30.0F
            );

            Divisa dolares = new Divisa(
                "USD",
                160.0F
            );

            repository.saveAll(
                List.of(btc,eth,dolares)
            );
        };
    }
}
