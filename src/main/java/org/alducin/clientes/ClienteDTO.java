package org.alducin.clientes;

public record ClienteDTO(
    String id,
    String nombre,
    String email,
    int edad,
    TipoCliente tipoCliente
) {
    public Cliente toEntity() {
        // Para crear, normalmente no tienes id; si usas UUID automática, pásalo null
        return new Cliente(id, nombre, email, edad, tipoCliente);
    }
}
