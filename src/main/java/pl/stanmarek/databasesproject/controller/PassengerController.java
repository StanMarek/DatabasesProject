package pl.stanmarek.databasesproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.stanmarek.databasesproject.model.Passenger;
import pl.stanmarek.databasesproject.service.PassengerService;

import java.util.Optional;

@Controller
@RequestMapping("/passengers")
public class PassengerController {

    @Autowired
    private PassengerService passengers;

    @GetMapping
    public String getAll(Model model){
        model.addAttribute("passengers", passengers.findAll());
        return "passengers/passengers";
    }

    @GetMapping("all")
    public @ResponseBody Iterable<Passenger> getAllPassengers() {
        return passengers.findAll();
    }
    
    @GetMapping("/id")
    public @ResponseBody
    Optional<Passenger> getByIdParam(@RequestParam Long id) {
        return passengers.findById(id);
    }

    @GetMapping("/id={id}")
    public @ResponseBody
    Optional<Passenger> getByIdPath(@PathVariable Long id) {
        return passengers.findById(id);
    }

    @GetMapping("/surname={surname}")
    public @ResponseBody
    Iterable<Passenger> getBySurname(@PathVariable String surname) {
        return passengers.findBySurname(surname);
    }

    @GetMapping("/fullname")
    public @ResponseBody
    Iterable<Passenger> getByFullNameParam(@RequestParam String name,
                                           @RequestParam String surname) {
        return passengers.findByFullname(name, surname);
    }

    @GetMapping("/name={name}&surname={surname}")
    public @ResponseBody
    Iterable<Passenger> getByFullNamePath(@PathVariable String name,
                                          @PathVariable String surname) {
        return passengers.findByFullname(name, surname);
    }

    @GetMapping("/email")
    public @ResponseBody
    Optional<Passenger> getByEmailParam(@RequestParam String email) {
        return passengers.findByEmail(email);
    }

    @GetMapping("/new")
    public String newPassenger(Model model){
        Passenger newPassenger = new Passenger();
        model.addAttribute("passenger", newPassenger);
        return "passengers/newPassenger";
    }

    @PostMapping("/new")
    public String newPassengerSubmit(@ModelAttribute Passenger passenger,
                                     Model model){
        model.addAttribute("passenger", passenger);
        passengers.add(passenger);
        return "passengers/newPassengerResult";
    }

    @PostMapping("/post")
    public @ResponseBody
    boolean addPassengerBody(@RequestBody Passenger passenger) {
        return passengers.add(passenger);
    }

    @PostMapping("/")
    public @ResponseBody
    boolean addPassengerParam(@RequestParam String name,
                              @RequestParam String surname,
                              @RequestParam String email) {
        return passengers.add(name, surname, email);
    }

    @PutMapping("/update/id={id}")
    public @ResponseBody
    boolean updatePassenger(@PathVariable Long id,
                            @RequestBody Passenger passenger) {
        return passengers.update(id, passenger);
    }

    @DeleteMapping("/id")
    public @ResponseBody
    void deletePassengerParam(@RequestParam Long id) {
        passengers.deleteById(id);
    }

    @DeleteMapping("/id={id}")
    public @ResponseBody
    void deletePassengerPath(@PathVariable Long id) {
        passengers.deleteById(id);
    }

    @DeleteMapping("/email")
    public @ResponseBody
    boolean deleteByEmailParam(@RequestParam String email) {
        return passengers.deleteByEmail(email);
    }

    @DeleteMapping("/email={email}")
    public @ResponseBody
    boolean deleteByEmailPath(@PathVariable String email) {
        return passengers.deleteByEmail(email);
    }
}
