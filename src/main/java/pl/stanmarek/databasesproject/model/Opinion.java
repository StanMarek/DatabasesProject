package pl.stanmarek.databasesproject.model;

import javax.persistence.*;

@Entity
@Table(name = "opinions")
public class Opinion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private Long flightId;

    public Opinion(){}

    public Opinion(Long id, String text, Long flightId) {
        this.id = id;
        this.text = text;
        this.flightId = flightId;
    }

    public Opinion(String text, Long flightId) {
        this.text = text;
        this.flightId = flightId;
    }

    @Override
    public String toString() {
        return "Opinion{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", flightId=" + flightId +
                '}';
    }
}
