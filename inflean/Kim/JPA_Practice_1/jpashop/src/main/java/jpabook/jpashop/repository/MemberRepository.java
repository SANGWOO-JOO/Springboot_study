package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

//    @PersistenceContext
    private final EntityManager em;

    //저장
    public void save(Member member){
        em.persist(member);
    }
    //단건 조회
    public Member findOne(Long id) {
        Member member = em.find(Member.class, id);
        return member;
    }

    //리스트 뿌리기
    public List<Member> findAll() {
        //from 뒤에 대상 entity
        List<Member> result = em.createQuery("select m from Member m", Member.class)
                .getResultList();
    return result;
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name =:name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}

