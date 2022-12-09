package StackTrace.VirtualWallet.Billetera;

import java.util.List;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BilleteraConfig {
    
    @Bean
    CommandLineRunner commandLineRunnerBilletera(BilleteraRepository repository){
        return args->{
            Billetera pato_billetera_fst = new Billetera(
                UUID.fromString("52e510a5-c1bf-4181-ab34-021970ae3473"),
                0F,
                "42644439"
            );


            Billetera pato_billetera_scd = new Billetera(
                UUID.fromString("52e510a5-c1bf-4181-ab34-021970ae3472"),
                0F,
                "42644439"
            );

            Billetera melisa_billetera = new Billetera(
                UUID.fromString("52e510a5-c1bf-4181-ab34-021970ae3471"),
                0F,
                "28843615"
            );

            repository.saveAll(
                List.of(pato_billetera_fst,pato_billetera_scd,melisa_billetera)
            );
        };
    }
}
