package StackTrace.VirtualWallet.Billetera;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Billetera {
    @Id 
    private UUID cvu=UUID.randomUUID();
    private Float saldo=0F;
    private String usuario;
    private List<Integer> recepciones = List.of();
    private List<Integer> emiciones = List.of();
    private List<Integer> divisas = List.of();

    public Billetera() {
    }

    public Billetera(String usuario) {
        this.usuario = usuario;
    }

    public Billetera(UUID cvu,Float saldo,String usuario) {
        this.cvu = cvu;
        this.saldo = saldo;
        this.usuario = usuario;
    }

    public UUID getCvu() {
        return cvu;
    }

    public Float getSaldo() {
        return saldo;
    }

    public String getUsuario() {
        return usuario;
    }

    public List<Integer> getDivisas() {
        return divisas;
    }
    
    public List<Integer> getRecepciones() {
        return recepciones;
    }

    public List<Integer> getEmiciones() {
        return emiciones;
    }

    public void setCvu(UUID cvu) {
        this.cvu = cvu;
    }

    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setRecepciones(Integer transaccion) {
        this.recepciones.add(transaccion);
    }
    
    public void setEmiciones(Integer transaccion) {
        this.emiciones.add(transaccion);
    }

    public void setDivisas(Integer divisa) {
        this.divisas.add(divisa);
    }

    public void deleteDivisa(Integer divisa) {
        this.divisas.remove(divisa);
    }

    @Override
    public String toString() {
        return "Billetera{" +
        "Pkey_cvu=" + cvu +
        ", saldo=" + saldo +
        ", usuario=" + usuario +
        '}';
    }

    
}
