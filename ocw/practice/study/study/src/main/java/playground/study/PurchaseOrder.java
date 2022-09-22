package playground.study;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class PurchaseOrder {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PURCHASE_ORDER_ID")
    private Long id;
    private String userName;

    @OneToMany()
    @JoinColumn(name = "ITEM_ID")
    private List<Item>Items = new ArrayList<Item>();
}
