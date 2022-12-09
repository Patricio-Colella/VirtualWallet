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

    public void postDivisa(Divisa divisa){
        divisaRepository.save(divisa);
    }

    public void putDivisa(String tipo,Float newValor){
        List<Divisa> divisa = divisaRepository.findByNombre(tipo);

        for(var i=0;i<divisa.size();i++){
            divisa.get(i).setValor_pesos(newValor);
            divisaRepository.save(divisa.get(i));
        }
    }

    public void deleteDivisa(String tipo){
        List<Divisa> divisa = divisaRepository.findByNombre(tipo);

        if(divisa.size()!=0){
            for(var i=0;i<divisa.size();i++){
                divisaRepository.delete(divisa.get(i));
            }
        }else{
            throw new IllegalStateException("no existe esa divisa");
        }
    }
}
