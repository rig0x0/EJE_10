package com.upiiz.superheroes.services;

import com.upiiz.superheroes.entities.HeroeEntity;
import com.upiiz.superheroes.repositories.HeroeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroeService {

    @Autowired
    private HeroeRepository heroeRepository;

    //GET de todos
    public List<HeroeEntity> getAllHeroes(){
        return heroeRepository.findAll();
    }

    //GET de uno
    public HeroeEntity getHeroeById(Long id){
        return heroeRepository.findById(id).orElse(null);
    }

    //POST
    public HeroeEntity createHeroe(HeroeEntity heroe){
        return heroeRepository.save(heroe);
    }

    //PUT
    public HeroeEntity updateHeroe(HeroeEntity heroe){
        if(heroeRepository.existsById(heroe.getId())){
            return heroeRepository.save(heroe);
        }
        return null;
    }

    //DELETE
    public void deleteById(Long id){
        if(heroeRepository.existsById(id)){
            heroeRepository.deleteById(id);
        }
    }
}
