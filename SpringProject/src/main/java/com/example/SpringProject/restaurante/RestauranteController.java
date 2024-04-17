package com.example.SpringProject.restaurante;

import com.example.SpringProject.cliente.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "restaurante")
public class RestauranteController {

    private final RestauranteService restauranteService;

    @Autowired
    public RestauranteController(RestauranteService restauranteService) {
        this.restauranteService = restauranteService;
    }

    @GetMapping
    public List<Restaurante> getCliente(){
        return restauranteService.getCliente();
    }

    @PostMapping
    public void registerNewCliente(@RequestBody Restaurante restaurante){
        System.out.println("restaurantee");
        System.out.println(restaurante);
        restauranteService.addNewCliente(restaurante);
    }

    @DeleteMapping(path = "{restauranteId}")
    public void deleteCliente(@PathVariable ("restauranteId") Long id){
        restauranteService.deleteCliente(id);
    }

    @PutMapping (path = "{restauranteId}")
    public void updateCliente (
            @PathVariable("restauranteId") Long restauranteId,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String bairro,
            @RequestParam(required = false) String localizacao,
            @RequestParam(required = false) String atendimentoPresencial,
            @RequestParam(required = false) Integer capacidade,
            @RequestParam(required = false) String telefone) {
        restauranteService.updateCliente(restauranteId, bairro, localizacao, atendimentoPresencial, capacidade, telefone, email);
    }
}
