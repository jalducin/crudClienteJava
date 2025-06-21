package org.alducin.clientes;

import jakarta.persistence.*;

@Entity
public class Cliente {
    @Id
    private String id;
    private String nombre;
    private String email;
    private int edad;

    @Enumerated(EnumType.STRING)
    private TipoCliente tipoCliente;

    public Cliente() {}

    public Cliente(String id, String nombre, String email, int edad, TipoCliente tipoCliente) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.edad = edad;
        this.tipoCliente = tipoCliente;
    }

    // Getters y setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
    public TipoCliente getTipoCliente() { return tipoCliente; }
    public void setTipoCliente(TipoCliente tipoCliente) { this.tipoCliente = tipoCliente; }
}
