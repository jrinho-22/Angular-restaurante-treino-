package com.example.SpringProject.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "cliente")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> getCliente(){
        return clienteService.getCliente();
    }

    @PostMapping
    public void registerNewCliente(@ModelAttribute Cliente cliente){
        clienteService.addNewCliente(cliente);
    }

    @DeleteMapping(path = "{clienteId}")
    public void deleteCliente(@PathVariable ("clienteId") Long id){
        clienteService.deleteCliente(id);
    }

    @PutMapping (path = "{clienteId}")
    public void updateCliente(
            @PathVariable("clienteId") Long clienteId,
            @ModelAttribute Cliente cliente){
        clienteService.updateCliente(clienteId, cliente);
    }

//    @PutMapping (path = "{clienteId}")
//    public void updateCliente (
//            @PathVariable("clienteId") Long clienteId,
//            @RequestParam(required = false) String name,
//            @RequestParam(required = false) String email) {
//        clienteService.updateCliente(clienteId, name, email);
//    }
}
