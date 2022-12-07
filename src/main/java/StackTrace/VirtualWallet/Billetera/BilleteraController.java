package StackTrace.VirtualWallet.Billetera;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="api/billetera")
public class BilleteraController {

    private final BilleteraService billeteraService;

    @Autowired
    public BilleteraController(BilleteraService billeteraService) {
        this.billeteraService = billeteraService;
    }

    @GetMapping
    public List<Billetera> getBilleteras(){
        return  billeteraService.getBilleteras();
    }

}
