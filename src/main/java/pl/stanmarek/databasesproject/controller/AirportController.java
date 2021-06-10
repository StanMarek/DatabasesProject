package pl.stanmarek.databasesproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.stanmarek.databasesproject.model.Airport;
import pl.stanmarek.databasesproject.service.AirportService;

import java.util.Optional;

@Controller
@RequestMapping("/airports")
public class AirportController {

    @Autowired
    private AirportService airports;
    
    @GetMapping("/")
    public Iterable<Airport> getAll(){
        return airports.getAll();
    }

    @GetMapping
    public String displayAll(Model model) {
        model.addAttribute("airports", airports.getAll());
        return "airports/airports";
    }

    @GetMapping("/id={id}")
    public Optional<Airport> getById(@PathVariable Long id){
        return airports.getById(id);
    }

    @GetMapping("/name={name}")
    public Optional<Airport> getByName(@PathVariable String name){
        return airports.getByName(name);
    }

    @GetMapping("/address={id}")
    public Optional<Airport> getByAddressId(@PathVariable Long id){
        return airports.getByAddressId(id);
    }

    @GetMapping("/country={country}")
    public Iterable<Airport> getByCountry(@PathVariable String country){
        return airports.getByCountry(country);
    }

    @GetMapping("/city={city}")
    public Iterable<Airport> getByCity(@PathVariable String city){
        return airports.getByCity(city);
    }

}
