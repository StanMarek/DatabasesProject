package pl.stanmarek.databasesproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
@RequestMapping
public class DatabasesProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatabasesProjectApplication.class, args);
    }

    @GetMapping("/start")
    public String homePage(){
        return "index";
    }

}
