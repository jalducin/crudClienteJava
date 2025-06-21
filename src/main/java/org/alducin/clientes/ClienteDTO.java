package org.alducin.clientes;

public record ClienteDTO(String id, String nombre, String email, int edad, TipoCliente tipoCliente) {}
