package StackTrace.VirtualWallet.Divisa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="api/divisa")
public class DivisaController {
    
    private final DivisaService divisaService;

    @Autowired
    public DivisaController(DivisaService divisaService){
        this.divisaService = divisaService;
    }

    @GetMapping
    public List<Divisa> getDivisas(){
        return divisaService.getDivisas();
    }
}
