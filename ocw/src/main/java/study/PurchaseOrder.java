package study;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity

public class PurchaseOrder {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PURCHASE_ORDER_ID")
    private Long id;
    private String userName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Item> getItems() {
        return Items;
    }

    public void setItems(List<Item> items) {
        Items = items;
    }

    @OneToMany(mappedBy = "order")
    private List<Item>Items = new ArrayList<Item>();
}
