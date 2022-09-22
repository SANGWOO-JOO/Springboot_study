package playground.study;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.chrono.IsoChronology;

@Entity
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOK_ID")
    private Long id;

    private String ISBM;
    //연관관계
    @OneToOne
    @JoinColumn(name ="MANUSCRIPT_ID")
    private Manuscript manuscript;
}
