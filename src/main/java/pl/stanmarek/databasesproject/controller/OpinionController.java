package pl.stanmarek.databasesproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.stanmarek.databasesproject.model.Opinion;
import pl.stanmarek.databasesproject.service.OpinionService;

import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("/opinions")
public class OpinionController {

    @Autowired
    private OpinionService opinions;

    @GetMapping
    public String displayAll(Model model) {
        model.addAttribute("opinions", opinions.getAll());
        return "reservations/opinions";
    }

    @GetMapping("/")
    public Iterable<Opinion> getAll(){
        return opinions.getAll();
    }

    @GetMapping("/id={id}")
    public Optional<Opinion> getById(@PathVariable Long id){
        return opinions.getById(id);
    }

    @GetMapping("/passenger/email={email}")
    public Iterable<Opinion> getByPassengerEmail(@PathVariable String email){
        return opinions.getBypassengerEmail(email);
    }

    @GetMapping("/passenger/id={id}")
    public Iterable<Opinion> getByPassengerId(@PathVariable Long id){
        return opinions.getByPassengerId(id);
    }

    @GetMapping("/flight/id={id}")
    public Optional<Opinion> getByFlightId(@PathVariable Long id){
        return opinions.getByFlightId(id);
    }

    @GetMapping("/flight/from/country={country}")
    public Iterable<Opinion> getByStartCountry(@PathVariable String country){
        return opinions.getByStartCountry(country);
    }

    @GetMapping("/flight/from/city={city}")
    public Iterable<Opinion> getByStartCity(@PathVariable String city){
        return opinions.getByStartCity(city);
    }

    @GetMapping("/flight/to/country={country}")
    public Iterable<Opinion> getByDestinationCountry(@PathVariable String country){
        return opinions.getByDestinationCountry(country);
    }

    @GetMapping("/flight/to/city={city}")
    public Iterable<Opinion> getByDestinationCity(@PathVariable String city){
        return opinions.getByDestinationCity(city);
    }

    @GetMapping("/flight/country/from={from}&to{to}")
    public Iterable<Opinion> getByFlightCountry(@PathVariable String from,
                                                @PathVariable String to){
        return opinions.findByFlightCountry(from, to);
    }

    @GetMapping("/flight/city/from={from}&to{to}")
    public Iterable<Opinion> getByFlightCity(@PathVariable String from,
                                                @PathVariable String to){
        return opinions.findByFlightCity(from, to);
    }

    @GetMapping("/airline={airline}")
    public Iterable<Opinion> getByAirline(@PathVariable String airline){
        return opinions.getByAirline(airline);
    }

    @GetMapping("/plane={id}")
    public Iterable<Opinion> getByPlane(@PathVariable Long id){
        return opinions.getByPlane(id);
    }

    @GetMapping("/plane")
    public Iterable<Opinion> getByPlaneRequest(@RequestParam Long id){
        return opinions.getByPlane(id);
    }

    @GetMapping("/plane/seats={seats}")
    public Iterable<Opinion> getByPlaneSeats(@PathVariable int seats){
        return opinions.getByPlaneSeats(seats);
    }

    @GetMapping("/date={date}")
    public Iterable<Opinion> getByDate(@PathVariable LocalDate date){
        return opinions.getByDate(date);
    }
}
