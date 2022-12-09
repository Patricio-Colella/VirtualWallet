package StackTrace.VirtualWallet;

import java.util.UUID;

public class BilleteraSaldo {
    
    private UUID billetera;
    private Float saldo;

    public BilleteraSaldo(UUID billetera, Float saldo) {
        this.billetera = billetera;
        this.saldo = saldo;
    }
    
    public UUID getBilletera() {
        return billetera;
    }
    public void setBilletera(UUID billetera) {
        this.billetera = billetera;
    }
    public Float getSaldo() {
        return saldo;
    }
    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }

    

}
