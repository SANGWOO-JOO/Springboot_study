package jpabook.jpashop.domain;

import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;

@Entity
@Getter @Setter
public class Category {

    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String name;

    @ManyToMany
    //양방향 설계
    @JoinTable(name = "category_item", //조인테이블명
            joinColumns = @JoinColumn(name = "category_id"),  //외래키
            inverseJoinColumns = @JoinColumn(name = "item_id")) //반대 엔티티의 외래키
    private List<Item> items = new ArrayList<>();

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

//    //==연관관계 메서드==//
//    public void addChildCategory(Category child) {
//        this.child.add(child);
//        child.setParent(this);
//    }

}
