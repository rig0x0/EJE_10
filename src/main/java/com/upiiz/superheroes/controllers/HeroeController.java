package com.upiiz.superheroes.controllers;

import com.upiiz.superheroes.entities.HeroeEntity;
import com.upiiz.superheroes.services.HeroeService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/heroes")
public class HeroeController {
    @Autowired
    private HeroeService heroeService;

    //GET de todos
    @GetMapping
    public ResponseEntity<List<HeroeEntity>> getAll(){
        return ResponseEntity.ok(heroeService.getAllHeroes());
    }

    //GET
    @GetMapping("/{id}")
    public ResponseEntity<HeroeEntity> getById(@PathVariable Long id){
        return ResponseEntity.ok(heroeService.getHeroeById(id));
    }

    //POST
    @PostMapping
    public ResponseEntity<HeroeEntity> createHeroe(@RequestBody HeroeEntity heroe){
        return ResponseEntity.ok(heroeService.createHeroe(heroe));
    }

    //PUT
    @PutMapping("/{id}")
    public ResponseEntity<HeroeEntity> updateHeroe(@RequestBody HeroeEntity heroe, @PathVariable Long id){
        heroe.setId(id);
        return ResponseEntity.ok(heroeService.updateHeroe(heroe));
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<HeroeEntity> deleteHeroe(@PathVariable Long id){
        heroeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
