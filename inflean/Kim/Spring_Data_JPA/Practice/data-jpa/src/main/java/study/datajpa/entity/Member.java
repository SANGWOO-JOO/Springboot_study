package study.datajpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    private Long id;
    private String username;

    //JPA에서 생성자 꼭 만들어주기
    //protected로 만들어 주기
    protected Member(){
    }

    public Member(String username) {
        this.username = username;
    }
}
