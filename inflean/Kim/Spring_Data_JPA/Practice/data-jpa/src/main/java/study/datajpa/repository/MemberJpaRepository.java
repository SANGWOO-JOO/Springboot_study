package study.datajpa.repository;



import org.springframework.stereotype.Repository;
import study.datajpa.entity.Member;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public class MemberJpaRepository {
    // jpa 엔티티 매니저
    // 영속성 컨텍스트 ㅡ 엔티티 매니저에 있는 것을 가져다 줌
    @PersistenceContext
    private EntityManager em;

    public Member save(Member member){
        em.persist(member);
        return member;
    }

    // 조회
    public Member find(Long id){
        return em.find(Member.class, id);
    }
}
