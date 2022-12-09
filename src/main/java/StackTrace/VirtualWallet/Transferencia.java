package StackTrace.VirtualWallet;

import java.util.UUID;

public class Transferencia {
    private String dni;
    private String contraseña;
    private UUID cvu_emisor;
    private UUID cvu_receptor;
    private Float saldo;
    private String tipo_moneda_emisor;
    private String tipo_moneda_receptor;
    
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    public UUID getCvu_emisor() {
        return cvu_emisor;
    }
    public void setCvu_emisor(UUID cvu_emisor) {
        this.cvu_emisor = cvu_emisor;
    }
    public UUID getCvu_receptor() {
        return cvu_receptor;
    }
    public void setCvu_receptor(UUID cvu_receptor) {
        this.cvu_receptor = cvu_receptor;
    }
    public Float getSaldo() {
        return saldo;
    }
    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }
    public String getTipo_moneda_emisor() {
        return tipo_moneda_emisor;
    }
    public void setTipo_moneda_emisor(String tipo_moneda_emisor) {
        this.tipo_moneda_emisor = tipo_moneda_emisor;
    }
    public String getTipo_moneda_receptor() {
        return tipo_moneda_receptor;
    }
    public void setTipo_moneda_receptor(String tipo_moneda_receptor) {
        this.tipo_moneda_receptor = tipo_moneda_receptor;
    }

    
}
