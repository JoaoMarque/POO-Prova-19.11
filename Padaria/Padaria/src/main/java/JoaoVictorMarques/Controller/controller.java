package com.ha.padaria.Controller;

import com.ha.padaria.Model.PadariaModel;
import com.ha.padaria.Service.PadariaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/padaria")
public class PadariaController {

    private final PadariaService padariaService;

    public PadariaController(PadariaService padariaService) {
        this.padariaService = padariaService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<PadariaModel> findAll() {
        return padariaService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PadariaModel buscarPorId(@PathVariable Long id) {
        return padariaService.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public PadariaModel criarPadaria(@RequestBody PadariaModel padariaModel) {
        return padariaService.criarPadaria(padariaModel);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public PadariaModel atualizarPadaria(@PathVariable Long id, @RequestBody PadariaModel padariaModel) {
        return padariaService.atualizarPadaria(id, padariaModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPadaria(@PathVariable Long id) {
        padariaService.deletarPadaria(id);
    }
}
