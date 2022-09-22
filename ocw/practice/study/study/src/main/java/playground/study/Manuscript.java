package playground.study;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Manuscript {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MANUSCRIPT_ID")
    private Long id;

    private byte[] file;

    @OneToOne
    private Book book;

}
