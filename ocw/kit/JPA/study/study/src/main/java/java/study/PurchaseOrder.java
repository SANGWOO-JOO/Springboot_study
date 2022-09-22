package java.study;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PurchaseOrder {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PURCHASE_ORDER_ID")
    private Long id;
    private String userName;

    @OneToMany(mappedBy = "order")
    private List<Item>Items = new ArrayList<Item>();
}
