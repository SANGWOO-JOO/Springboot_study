package jpabook.jpashop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @JsonIgnore
    //맵핑 연관관계 거울
    //order 필드의 member에 의해서 맵뜨된거 => 읽기 전용
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();



}
