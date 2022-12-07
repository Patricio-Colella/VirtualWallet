package StackTrace.VirtualWallet.Usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Usuario {
    // @SequenceGenerator(
    //     name = "student_sequence",
    //     sequenceName = "student_sequence",
    //     allocationSize = 1
    // )
    // @GeneratedValue(
    //     strategy = GenerationType.SEQUENCE,
    //     generator = "student_sequence"
    // )
    @Id 
    private String dni;
    private String genero;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String contraseña;

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

    public String getContraseña() {
        return contraseña;
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

    @Override
    public String toString() {
        return "Usuario{" +
                "Pkey_dni=" + dni +","+'\n'+
                "   genero=" + genero +","+ '\n' +
                "   nombre=" + nombre +","+ '\n' +
                "   apellido=" + apellido +","+ '\n' +
                "   email=" + email +","+ '\n' +
                "   telefono=" + telefono +","+'\n'+
                "   contraseña=" + contraseña +","+'\n'+
                '}';
    }
}
