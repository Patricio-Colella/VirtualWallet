package StackTrace.VirtualWallet.Transaccion;

import java.time.LocalDate;
import java.time.LocalTime;

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
    private String moneda_origen;
    private String moneda_destino;

    public Transaccion() {
    }
    
    public Transaccion(String operacion, String moneda_origen, String moneda_destino) {
        this.operacion = operacion;
        this.moneda_origen = moneda_origen;
        this.moneda_destino = moneda_destino;
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
    public String getMoneda_origen() {
        return moneda_origen;
    }
    public void setMoneda_origen(String moneda_origen) {
        this.moneda_origen = moneda_origen;
    }
    public String getMoneda_destino() {
        return moneda_destino;
    }
    public void setMoneda_destino(String moneda_destino) {
        this.moneda_destino = moneda_destino;
    }

    
}
