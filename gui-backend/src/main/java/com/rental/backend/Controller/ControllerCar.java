package com.rental.backend.Controller;

import com.rental.backend.Modal.Car;
import com.rental.backend.Modal.Schedule;
import com.rental.backend.Repository.RepositoryCar;
import com.rental.backend.Repository.RepositorySchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/vehicle-car")
public class ControllerCar {
    @Autowired
    private RepositoryCar repositoryCar;

    @Autowired
    private RepositorySchedule repositorySchedule;

    public ControllerCar(RepositoryCar repositoryCar) {
        this.repositoryCar = repositoryCar;
    }

    @GetMapping("/car")
    public Iterable<Car> getCar() {
        return (repositoryCar.findAll());
    }

    @PostMapping
    public Car insert(@RequestBody Car car) {return this.repositoryCar.save(car);}

    @PostMapping("/schedule")
    public Schedule insertCar(@Valid @RequestBody Schedule schedule) {
        System.out.println(schedule);
        return this.repositorySchedule.save(schedule);
    }
}
