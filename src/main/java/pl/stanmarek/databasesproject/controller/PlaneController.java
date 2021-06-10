package pl.stanmarek.databasesproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.stanmarek.databasesproject.model.Plane;
import pl.stanmarek.databasesproject.service.PlaneService;

import java.util.Optional;

@Controller
@RequestMapping(value = "/planes")
public class PlaneController {

    @Autowired
    private PlaneService planes;

    @GetMapping("/")
    public @ResponseBody Iterable<Plane> getAll(){
        return planes.getAll();
    }

    @GetMapping
    public String displayAll(Model model){
        model.addAttribute("planes", planes.getAll());
        return "flights/planes";
    }

    @GetMapping("/id")
    public @ResponseBody Optional<Plane> getById(@PathVariable Long id){
        return planes.findById(id);
    }

    @GetMapping("/airline={airline}")
    public @ResponseBody Iterable<Plane> getByAirline(@PathVariable String airline){
        return planes.findByAirline(airline);
    }

    @GetMapping("/seats={numberOfSeats}")
    public @ResponseBody Iterable<Plane> getBySeats(@PathVariable int numberOfSeats){
        return planes.findBySeats(numberOfSeats);
    }

    @GetMapping("/airline={airline}/seats={seats}")
    public @ResponseBody Iterable<Plane> getBySeatsInAirline(@PathVariable String airline,
                                                             @PathVariable int seats){
        return planes.findByAirlineAndSeats(airline, seats);
    }

    @PostMapping
    public @ResponseBody boolean addPlane(@RequestBody Plane plane) {
        return planes.addPlane(plane);
    }

    @DeleteMapping("/id={id}")
    public @ResponseBody void deleteById(@PathVariable Long id) {
        planes.deleteById(id);
    }
}
