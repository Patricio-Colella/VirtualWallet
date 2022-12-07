package StackTrace.VirtualWallet.Billetera;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BilleteraConfig {
    
    @Bean
    CommandLineRunner commandLineRunnerBilletera(BilleteraRepository repository){
        return args->{
            Billetera pato_billetera_fst = new Billetera(
                
            );

            repository.saveAll(
                List.of(pato_billetera_fst)
            );
        };
    }
}
