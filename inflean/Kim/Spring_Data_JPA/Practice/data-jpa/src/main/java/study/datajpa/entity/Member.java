package study.datajpa.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
//JPA에서 생성자 꼭 만들어주기
//protected로 만들어 주기
//    protected Member(){
//    }
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of= {"id","username","age"})
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String username;
    private int age;

    //지연로딩 : 가짜 객체화 하는 것.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    public Member(String username) {
        this.username = username;
    }

    public Member(String username, int age, Team team) {
        this.username=username;
        this.age=age;
        if(team !=null){
            changeTeam(team);
        }
    }

    //연관관계 세팅 ..
    public void changeTeam(Team team){
        this.team = team;
        team.getMembers().add(this);
    }
}
