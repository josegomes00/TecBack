package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.Episodios;
import br.com.fujideia.iesp.tecback.model.Serie;
import br.com.fujideia.iesp.tecback.service.EpisodiosService;
import br.com.fujideia.iesp.tecback.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/episodios")
public class EpisodiosController {

    @Autowired
    private EpisodiosService service;

    @PostMapping
    public ResponseEntity<Episodios> salvar(@RequestBody Episodios episodios){
        episodios = service.salvar(episodios);
        return ResponseEntity.ok(episodios);
    }

    @PutMapping
    public ResponseEntity<Episodios>alterar(@RequestBody Episodios episodios){
        episodios = service.alterar(episodios);
        return ResponseEntity.ok(episodios);
    }

    @GetMapping
    public ResponseEntity<List<Episodios>>buscarTodas(){
        return ResponseEntity.ok(service.buscarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Episodios>consultar(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.consultarPorId(id));
    }

    @DeleteMapping
    public ResponseEntity<Episodios>excluir(@PathVariable("id") Integer id){
        if(service.excluir(id)){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    //não sei criar o controller para relacionar episodios a série
}
