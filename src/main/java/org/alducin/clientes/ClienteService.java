package org.alducin.clientes;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.logging.Logger;

@Service
public class ClienteService {
    private final ClienteRepository repo;
    private static final Logger log = Logger.getLogger(ClienteService.class.getName());

    public ClienteService(ClienteRepository repo) {
        this.repo = repo;
    }

    public Cliente crear(Cliente c) {
        log.info("Creando cliente: " + c.getNombre());
        return repo.save(c);
    }

    public List<Cliente> listar() {
        return repo.findAll();
    }

    public Cliente actualizar(String id, ClienteDTO nuevo) {
        return repo.findById(id).map(c -> {
            c.setEmail(nuevo.email());
            c.setTipoCliente(nuevo.tipoCliente());
            return repo.save(c);
        }).orElse(null);
    }

    public void eliminar(String id) {
        repo.deleteById(id);
    }

    public String beneficio(String id) {
        return repo.findById(id).map(c -> {
            return switch (c.getTipoCliente()) {
                case VIP -> "Cliente VIP: descuento aplicado";
                case REGULAR -> "Cliente REGULAR: sin descuento";
            };
        }).orElse("No existe cliente");
    }
}
