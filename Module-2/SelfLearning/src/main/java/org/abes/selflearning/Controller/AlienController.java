package org.abes.selflearning.Controller;


import org.abes.selflearning.Model.Alien;
import org.abes.selflearning.Services.AlienService;
import org.abes.selflearning.repository.AlienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AlienController {
    @Autowired
    private AlienRepository alienRepository;
    @Autowired
    private AlienService alienService;

    public AlienController(AlienRepository alienRepository) {
        this.alienRepository = alienRepository;
    }


    @PostMapping("/alien")
    public String alien()
    {
        List<Alien> aliens = new ArrayList<>();
        Alien alien1 = new Alien();
        alien1.setId(101);
        alien1.setName("Ram");
        alien1.setScore(80);
        aliens.add(alien1);

        Alien alien2 = new Alien();
        alien2.setId(102);
        alien2.setName("shyam");
        alien2.setScore(90);
        aliens.add(alien2);

        Alien alien3 = new Alien();
        alien3.setId(103);
        alien3.setName("pankaj");
        alien3.setScore(100);
        aliens.add(alien3);

        alienRepository.saveAll(aliens);

        return "Successfully Created Alien";
    }

    @PostMapping("/addnew")
    public String addNewAlien()
    {
        System.out.println("Adding New Alien");
        return alienService.addNewAlien();
    }
    @GetMapping("/findid/{id}")
    public Alien findAlienById(@PathVariable int id)
    {
        return alienService.findAlienById(id);
    }





}
