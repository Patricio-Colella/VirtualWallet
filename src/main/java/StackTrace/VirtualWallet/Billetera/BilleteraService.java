package StackTrace.VirtualWallet.Billetera;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BilleteraService {

    private final BilleteraRepository billeteraRepository;

    @Autowired
    public BilleteraService(BilleteraRepository billeteraRepository){
        this.billeteraRepository = billeteraRepository;
    }

    public List<Billetera> getBilleteras(){
        return billeteraRepository.findAll();
    }
}
