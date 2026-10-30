package org.abes.selflearning.Services;

import org.abes.selflearning.Model.Alien;
import org.abes.selflearning.repository.AlienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlienService {
    @Autowired
    private AlienRepository alienRepository;
    public String addNewAlien(){
        Alien alien = new Alien(105,"Shubham",50);
        alienRepository.save(alien);
        return "Successfully Created Alien";
    }
    public Alien findAlienById(int id){
        return alienRepository.findById(id).orElse(null);
    }

}
