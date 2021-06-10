package pl.stanmarek.databasesproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.stanmarek.databasesproject.model.Flight;
import pl.stanmarek.databasesproject.repo.FlightRepo;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    private FlightRepo flightRepo;

    public Iterable<Flight> getAll() {
        return flightRepo.findAll();
    }

    public Optional<Flight> getById(Long id) {
        return flightRepo.findById(id);
    }

    public Iterable<Flight> getByPlane(Long plane) {
        return flightRepo.findByPlane(plane);
    }

    public Iterable<Flight> getByDepartureAirport(Long id) {
        return flightRepo.findByDepartureAirport(id);
    }

    public Iterable<Flight> getByArrivalAirport(Long id) {
        return flightRepo.findByArrivalAirport(id);
    }

    public Iterable<Flight> getByDate(LocalDate date) {
        return flightRepo.getByDate(date);
    }

    public Iterable<Flight> getByDestination(String country) {
        return flightRepo.getByDestination(country);
    }

    public Iterable<Flight> getByStartingCountry(String country) {
        return flightRepo.findByStartingCountry(country);
    }

    public Iterable<Flight> getByDestinationCity(String city) {
        return flightRepo.findByDestinationCity(city);
    }

    public Iterable<Flight> getByStartingCity(String city) {
        return flightRepo.findByStartingCity(city);
    }

    public Iterable<Flight> getByStartAndDestination(Long startId, Long toId) {
        return flightRepo.findByStartAndDestination(startId, toId);
    }

    public Iterable<Flight> getByStartAndDestinationCountry(String from, String to) {
        return flightRepo.findByStartAndDestinationCountry(from, to);
    }

    public Iterable<Flight> getByStartAndDestinationCity(String from, String to) {
        return flightRepo.findByStartAndDestinationCity(from ,to);
    }

    public Iterable<Flight> getByCityToCountry(String from, String to) {
        return flightRepo.getByCityToCountry(from, to);
    }

    public Iterable<Flight> getByCountryToCity(String from, String to) {
        return flightRepo.findByCountryToCity(from, to);
    }

    public void add(Flight flight) {
        Flight f = new Flight();
        f.setDatetime(flight.getDatetime());
        f.setDestinationAirport(flight.getDestinationAirport());
        f.setStartingAirport(flight.getStartingAirport());
        f.setPlane(flight.getPlane());
        flightRepo.save(f);
    }
}
