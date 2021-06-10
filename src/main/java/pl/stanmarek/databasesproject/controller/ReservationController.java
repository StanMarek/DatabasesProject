package pl.stanmarek.databasesproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.stanmarek.databasesproject.service.ReservationService;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservations;

    @GetMapping
    public String displayAll(Model model){
        model.addAttribute("reservations", reservations.findAll());
        return "reservations/reservations";
    }
}
