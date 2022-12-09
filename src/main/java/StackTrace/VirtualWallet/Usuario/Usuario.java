package StackTrace.VirtualWallet.Usuario;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table
public class Usuario {

    @Id 
    private String dni;
    private String genero;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String contraseña;
    private List<UUID> billeteras = List.of();

    public Usuario() {
    }

    public Usuario(String dni, String genero, String nombre, String apellido, String email, String telefono, String contraseña) {
        this.dni = dni;
        this.genero = genero;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.contraseña = contraseña;
    }

    public Usuario(String dni, String genero, String nombre, String apellido, String email, String telefono, String contraseña,List<UUID> billeteras) {
        this.dni = dni;
        this.genero = genero;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.contraseña = contraseña;
        this.billeteras = billeteras;
    }

    public String getDni() {
        return dni;
    }

    public String getGenero() {
        return genero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public List<UUID> getBilleteras(){
        return billeteras;
    }
    
    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setBilleteras(UUID billetera) {
        this.billeteras.add(billetera);
    }

    @Override
    public String toString() {
        return "Pkey_dni=" + dni +","+'\n'+
                "   genero=" + genero +","+ '\n' +
                "   nombre=" + nombre +","+ '\n' +
                "   apellido=" + apellido +","+ '\n' +
                "   email=" + email +","+ '\n' +
                "   telefono=" + telefono +","+'\n';
    }
}
