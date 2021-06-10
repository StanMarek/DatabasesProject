package pl.stanmarek.databasesproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.stanmarek.databasesproject.model.Address;
import pl.stanmarek.databasesproject.service.AddressService;

import java.util.Optional;

@Controller
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    private AddressService addresses;

    @GetMapping("/")
    public Iterable<Address> getAll(){
        return addresses.findAll();
    }

    @GetMapping
    public String displayAll(Model model){
        model.addAttribute("addresses", addresses.findAll());
        return "airports/addresses";
    }

    @GetMapping("/id={id}")
    public Optional<Address> getById(@PathVariable Long id){
        return addresses.findById(id);
    }

    @GetMapping("/country={country}")
    public Iterable<Address> getByCountry(@PathVariable String country){
        return addresses.findByCountry(country);
    }

    @GetMapping("/city={city}")
    public Iterable<Address> getByCity(@PathVariable String city){
        return addresses.findByCity(city);
    }

    @GetMapping("/airport_id={airport}")
    public Optional<Address> getByAirportId(@PathVariable Long id){
        return addresses.findByAirportId(id);
    }

}
