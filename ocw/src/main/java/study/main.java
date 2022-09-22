package study;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class main {

    public static void main(String[] args) {
        //
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("playground");
        // EntityManager
        EntityManager em = emf.createEntityManager();
        // EntityTransaction
        EntityTransaction tx =em.getTransaction();

        try{
            tx.begin();

            //두개 아이템 만들기
            //Item1 생성
            Item item1 =new Item();
            item1.setName("치킨");
            //Item2 생성
            Item item2 =new Item();
            item2.setName("치즈볼");

            PurchaseOrder order = new PurchaseOrder();
            order.setUserName("kim");
            //Items AllayList
            order.getItems().add(item1);
            order.getItems().add(item2);

            em.persist(order);
            em.persist(item1);
            em.persist(item2);



            tx.commit();
        }catch (Exception e){

            tx.rollback();
        }finally {
            em.close();

        }
    }
}
