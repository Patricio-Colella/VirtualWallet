package StackTrace.VirtualWallet.Divisa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table
public class Divisa {
    @Id
    @SequenceGenerator(
        name = "divisa_sequence",
        sequenceName = "divisa_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "divisa_sequence"
    )
    private Integer id;
    private String nombre;
    private Float valor_pesos;
    private Float cantidad;

    public Divisa() {
    }

    public Divisa(String nombre, Float valor_pesos) {
        this.nombre = nombre;
        this.valor_pesos = valor_pesos;
    }

    public Divisa(String nombre, Float valor_pesos, Float cantidad) {
        this.nombre = nombre;
        this.valor_pesos = valor_pesos;
        this.cantidad = cantidad;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Float getValor_pesos() {
        return valor_pesos;
    }

    public Float getCantidad() {
        return cantidad;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setValor_pesos(Float valor_pesos) {
        this.valor_pesos = valor_pesos;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Divisa{" +
                "Pkey_id=" + id +
                ", valor en pesos='" + valor_pesos + '\'' +
                ", nombre='" + nombre +
                '}';
    }

        
    
}
