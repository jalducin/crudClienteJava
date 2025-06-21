package org.alducin.clientes;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping
    public Cliente crear(@RequestBody ClienteDTO dto) {
        return service.crear(new Cliente(dto.id(), dto.nombre(), dto.email(), dto.edad(), dto.tipoCliente()));
    }

    @GetMapping
    public List<Cliente> listar() {
        return service.listar();
    }

    @PutMapping("/{id}")
    public Cliente actualizar(@PathVariable String id, @RequestBody ClienteDTO dto) {
        return service.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        service.eliminar(id);
    }

    @GetMapping("/{id}/beneficio")
    public String beneficio(@PathVariable String id) {
        return service.beneficio(id);
    }
}
