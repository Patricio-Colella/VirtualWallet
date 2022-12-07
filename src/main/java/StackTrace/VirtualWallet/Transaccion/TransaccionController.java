package StackTrace.VirtualWallet.Transaccion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/transaccion")
public class TransaccionController {
    
    private final TransaccionService transaccionService;


    @Autowired
    private TransaccionController(TransaccionService transaccionService){
        this.transaccionService = transaccionService;
    }

    @GetMapping
    private List<Transaccion> getTransacciones(){
        return transaccionService.getTransacciones();
    }
}
