package StackTrace.VirtualWallet.Transaccion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransaccionService {
    
    private final TransaccionRepository transaccionRepository;

    @Autowired
    private TransaccionService(TransaccionRepository transaccionRepository){
        this.transaccionRepository = transaccionRepository;
    }

    public List<Transaccion> getTransacciones(){
        return transaccionRepository.findAll();
    }
}
