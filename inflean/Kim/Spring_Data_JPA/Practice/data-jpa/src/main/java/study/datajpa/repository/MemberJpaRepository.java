package study.datajpa.repository;



import org.springframework.stereotype.Repository;
import study.datajpa.entity.Member;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;


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

    public void delete(Member member){
        em.remove(member);

    }

    //전체 조회
    public List<Member> findAll(){
        //Member.class 반환타입
        return em.createQuery("select m from Member m",Member.class)
                .getResultList();
    }

    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    //갯수
    public long count(){
        return em.createQuery("select  count(m) from Member m",Long.class)
                .getSingleResult();
    }

    // 단건 조회
    public Member find(Long id){
        return em.find(Member.class, id);
    }
}
