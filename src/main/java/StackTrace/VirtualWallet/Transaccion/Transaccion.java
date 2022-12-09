package StackTrace.VirtualWallet.Transaccion;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Transaccion {
    
    @Id
    @SequenceGenerator(
        name = "transaccion_sequence",
        sequenceName = "transaccion_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy =  GenerationType.SEQUENCE,
        generator = "transaccion_sequence"
    )
    private Integer id;

    private LocalDate fecha_ingreso = LocalDate.now();
    private LocalTime hora_ingreso = LocalTime.now();
    private String operacion;
    private Float cantidad;
    private String divisa;
    private UUID billeteraEmisora;
    private UUID billeteraReceptora;

    public Transaccion() {
    }
    
    public Transaccion(String operacion, Float cantidad, String divisa) {
        this.operacion = operacion;
        this.cantidad = cantidad;
        this.divisa = divisa;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public LocalDate getFecha_ingreso() {
        return fecha_ingreso;
    }
    public void setFecha_ingreso(LocalDate fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }
    public LocalTime getHora_ingreso() {
        return hora_ingreso;
    }
    public void setHora_ingreso(LocalTime hora_ingreso) {
        this.hora_ingreso = hora_ingreso;
    }
    public String getOperacion() {
        return operacion;
    }
    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }
    public String getDivisa() {
        return divisa;
    }
    public void setDivisa(String divisa) {
        this.divisa = divisa;
    }
    public Float getCantidad() {
        return cantidad;
    }
    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }

    public UUID getBilleteraEmisora() {
        return billeteraEmisora;
    }

    public void setBilleteraEmisora(UUID billetera) {
        this.billeteraEmisora = billetera;
    }
    
    public UUID getBilleteraReceptora() {
        return billeteraReceptora;
    }

    public void setBilleteraReceptora(UUID billetera) {
        this.billeteraReceptora = billetera;
    }
    
}
