package pl.stanmarek.databasesproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.stanmarek.databasesproject.model.Reservation;
import pl.stanmarek.databasesproject.repo.ReservationRepo;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepo reservationRepo;

    public Iterable<Reservation> findAll() {
        return reservationRepo.findAll();
    }
}
