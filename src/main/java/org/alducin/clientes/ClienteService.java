package org.alducin.clientes;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository repo;
    private final LogService logService;

    public ClienteService(ClienteRepository repo, LogService logService) {
        this.repo = repo;
        this.logService = logService;
    }

    public Cliente crear(Cliente c) {
        logService.logInfo("Creando cliente: " + c.getNombre());
        return repo.save(c);
    }

    public List<Cliente> listar() {
        logService.logInfo("Listando clientes");
        return repo.findAll();
    }

    public Cliente actualizar(String id, ClienteDTO nuevo) {
        return repo.findById(id).map(c -> {
            c.setEmail(nuevo.email());
            c.setTipoCliente(nuevo.tipoCliente());
            logService.logInfo("Actualizando cliente ID: " + id);
            return repo.save(c);
        }).orElseGet(() -> {
            logService.logError("Cliente no encontrado para actualizar con ID: " + id);
            return null;
        });
    }

    public void eliminar(String id) {
        repo.deleteById(id);
        logService.logInfo("Cliente eliminado con ID: " + id);
    }

    public String beneficio(String id) {
        return repo.findById(id).map(c -> {
            String mensaje = switch (c.getTipoCliente()) {
                case VIP -> "Cliente VIP: descuento aplicado";
                case REGULAR -> "Cliente REGULAR: sin descuento";
            };
            logService.logInfo("Beneficio consultado para ID: " + id + " → " + mensaje);
            return mensaje;
        }).orElseGet(() -> {
            logService.logError("Cliente no encontrado para beneficio con ID: " + id);
            return "No existe cliente";
        });
    }
}
