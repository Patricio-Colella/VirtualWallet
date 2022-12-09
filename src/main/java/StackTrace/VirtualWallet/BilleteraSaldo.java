package StackTrace.VirtualWallet;

import java.util.UUID;

public class BilleteraSaldo {
    private UUID cvu;
    private Float saldo;
    
    public BilleteraSaldo(UUID cvu, Float saldo ){
        this.cvu = cvu;
        this.saldo = saldo;
    }

    public UUID getCvu() {
        return cvu;
    }

    public void setCvu(UUID cvu) {
        this.cvu = cvu;
    }

    public Float getSaldo() {
        return saldo;
    }

    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }

    
}
