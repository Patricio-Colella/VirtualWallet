package StackTrace.VirtualWallet.Billetera;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import StackTrace.VirtualWallet.BilleteraSaldo;

import java.util.List;
import java.util.Map;
import java.util.UUID;

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

    @PostMapping(path = "/{dniUsuario}")
    public void postBilletera(@PathVariable(name="dniUsuario") String dniUsuario){
        billeteraService.postBilletera(dniUsuario);
    }

    @DeleteMapping(path = "/{idBilletera}")
    private void deleteBilletera(@PathVariable(required=false,name="idBilletera") String idBilletera){

        if(idBilletera.isEmpty()){
            throw new IllegalStateException("falta cvu de la billetera");
        }
        billeteraService.deleteBilletera(UUID.fromString(idBilletera));
    }

    @PutMapping(path = "/deposito/{cvuBilletera}")
    public void putBilletera(@PathVariable(name="cvuBilletera") String cvuBilletera, @RequestParam(required=false) Map<String,String> qparams){
        String contraseña = qparams.get("contraseña");
        String dni = qparams.get("dni");
        String saldo = qparams.get("saldo");
        String tipoDivisa = qparams.get("tipoDivisa");
        if(contraseña.isEmpty()||dni.isEmpty()||saldo.isEmpty()||tipoDivisa.isEmpty()){
            throw new IllegalStateException("faltan datos");
        }
        billeteraService.putBilletera(UUID.fromString(cvuBilletera),contraseña,dni,Float.parseFloat(saldo),tipoDivisa);
    }

    @GetMapping(path = "/billeteraUnica/{cvuBilletera}")
    public BilleteraSaldo getBilleteras(@PathVariable(name="cvuBilletera") String cvuBilletera){
        return  billeteraService.getBilleteraByCvu(UUID.fromString(cvuBilletera));
    }
}
