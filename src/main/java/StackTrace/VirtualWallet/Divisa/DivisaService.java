package StackTrace.VirtualWallet.Divisa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DivisaService {
    
    private final DivisaRepository divisaRepository;

    @Autowired
    public DivisaService(DivisaRepository divisaRepository){
        this.divisaRepository = divisaRepository;
    }

    public List<Divisa> getDivisas(){
        return divisaRepository.findAll();   
    }
}
