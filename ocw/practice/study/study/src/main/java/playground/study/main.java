package playground.study;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class main {

    public static void main(String[] args) {
        //
        EntityManagerFactory emf =Persistence.createEntityManagerFactory("playground");
        // EntityManager
        EntityManager em = emf.createEntityManager();
        // EntityTransaction
        EntityTransaction tx =em.getTransaction();

        try{
            tx.begin();

            Manuscript manuscript = new Manuscript();
            Book book =new Book();

            book.setISBM("ABC");
            book.setManuscript(manuscript);
            manuscript.setBook(book);

            em.persist(manuscript);
            em.persist(book);



            tx.commit();
        }catch (Exception e){

            tx.rollback();
        }finally {
            em.close();

        }
    }
}