package StackTrace.VirtualWallet.Divisa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Map;

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

    @PostMapping
    public void postDivisa(@RequestBody Divisa divisa){
        divisaService.postDivisa(divisa);
    }

    @PutMapping(params = "/{tipo}")
    public void putDivisa(@PathVariable(name="tipo") String tipo, @RequestParam(required=false) Map<String,String> qparams){
        String newValor = qparams.get("valor");
        if(newValor.isEmpty()){
            throw new IllegalStateException("falta valor nuevo");
        }
        divisaService.putDivisa(tipo,Float.parseFloat(newValor));
    }

    @DeleteMapping(params = "/{tipo}")
    public void putDivisa(@PathVariable(name="tipo") String tipo){
        divisaService.deleteDivisa(tipo);
    }
}
