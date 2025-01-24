package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        //애플리케이션 시작시 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        /**
         * 각 트랜잭션마다 생성
         * 트랜잭션이 끝나면 닫아야 합니다(close()).
         */
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("B");
//            em.persist(member);
//            Member member = em.find(Member.class, 1L);

              //조회
//            System.out.println("member.getId() = " + member.getId());
//            System.out.println("member.getName() = " + member.getName());


            List<Member> query = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(5)
                    .setMaxResults(8)
                    .getResultList();
            for (Member m : query) {
                System.out.println("member name = " + m.getName());
            }

//            수정
//            member.setName("changeName");
//            삭제
//            em.remove(member);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
