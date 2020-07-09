package com.rental.backend.Controller;

import com.rental.backend.Modal.Motorbike;
import com.rental.backend.Modal.Schedule;
import com.rental.backend.Repository.RepositoryMotorbike;
import com.rental.backend.Repository.RepositorySchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/vehicle-bike")
public class ControllerMotorbike {
    @Autowired
    private RepositoryMotorbike repositoryMotorbike;

    @Autowired
    private RepositorySchedule repositorySchedule;

    public ControllerMotorbike(RepositoryMotorbike repositoryMotorbike) {
        this.repositoryMotorbike = repositoryMotorbike;
    }

    @GetMapping("/motorbike")
    public Iterable<Motorbike> getCar() {
        return (repositoryMotorbike.findAll());
    }

    @PostMapping
    public Motorbike insert(@RequestBody Motorbike motorbike) {
        return this.repositoryMotorbike.save(motorbike);}

    @PostMapping("/schedule")
    public Schedule insertCar(@Valid @RequestBody Schedule schedule) {
        System.out.println(schedule);
        return this.repositorySchedule.save(schedule);
    }
}
