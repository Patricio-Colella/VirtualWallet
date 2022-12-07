package StackTrace.VirtualWallet.Billetera;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Billetera {
    @Id 
    @Column(name="cvu")
    private UUID cvu=UUID.randomUUID();
    private Float saldo=0F;

    public Billetera() {
    }

    public UUID getCvu() {
        return cvu;
    }

    public Float getSaldo() {
        return saldo;
    }

    public void setCvu(UUID cvu) {
        this.cvu = cvu;
    }

    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Billetera{" +
        "Pkey_cvu=" + cvu +
        ", saldo=" + saldo +
        '}';
    }

    
}
