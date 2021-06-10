package pl.stanmarek.databasesproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.stanmarek.databasesproject.model.Flight;
import pl.stanmarek.databasesproject.service.FlightService;

import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService flights;

    @GetMapping("/")
    public Iterable<Flight> getAll() {
        return flights.getAll();
    }

    @GetMapping
    public String displayAll(Model model){
        model.addAttribute("flights", flights.getAll());
        return "flights/flights";
    }

    @GetMapping("/id={id}")
    public Optional<Flight> getById(@PathVariable Long id) {
        return flights.getById(id);
    }

    @GetMapping("/plane={plane}")
    public Iterable<Flight> getByPlane(@PathVariable Long plane) {
        return flights.getByPlane(plane);
    }

    @GetMapping("/start={id}")
    public Iterable<Flight> getByDepartureAirport(@PathVariable Long id) {
        return flights.getByDepartureAirport(id);
    }

    @GetMapping("/destination={id}")
    public Iterable<Flight> getByArrivalAirport(@PathVariable Long id) {
        return flights.getByArrivalAirport(id);
    }

    @GetMapping("/date={date}")
    public Iterable<Flight> getByDate(@PathVariable LocalDate date) {
        return flights.getByDate(date);
    }

    @GetMapping("/destination/country={country}")
    public Iterable<Flight> getByDestinationCountry(@PathVariable String country){
        return flights.getByDestination(country);
    }

    @GetMapping("/starting/country={country}")
    public Iterable<Flight> getByStartingCountry(@PathVariable String country){
        return flights.getByStartingCountry(country);
    }

    @GetMapping("/destination/city={city}")
    public Iterable<Flight> getByDestinationCity(@PathVariable String city){
        return flights.getByDestinationCity(city);
    }

    @GetMapping("/starting/city={city}")
    public Iterable<Flight> getStartingCity(@PathVariable String city){
        return flights.getByStartingCity(city);
    }

    @GetMapping("/from={startId}&to={toId}")
    public Iterable<Flight> getByStartAndDestination(@PathVariable Long startId,
                                                     @PathVariable Long toId){
        return flights.getByStartAndDestination(startId, toId);
    }

    @GetMapping("/country/from={from}&to={to}")
    public Iterable<Flight> getByStartAndDestinationCountry(@PathVariable String from,
                                                            @PathVariable String to){
        return flights.getByStartAndDestinationCountry(from, to);
    }

    @GetMapping("/city/from={from}&to={to}")
    public Iterable<Flight> getByStartAndDestinationCity(@PathVariable String from,
                                                         @PathVariable String to){
        return flights.getByStartAndDestinationCity(from, to);
    }

    @GetMapping("/city_to_country/from={city}&to={to}")
    public Iterable<Flight> getByCityToCountry(@PathVariable String from,
                                               @PathVariable String to){
        return flights.getByCityToCountry(from, to);
    }

    @GetMapping("/country_to_city/from={from}&to={to}")
    public Iterable<Flight> getByCountryToCity(@PathVariable String from,
                                               @PathVariable String to){
        return flights.getByCountryToCity(from, to);
    }
}
