package jjun.server.ch05model2;

import jjun.server.ch05model2.entity.Member;
import jjun.server.ch05model2.entity.Order;

import javax.persistence.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // 엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager();  // 엔티티 매니저 생성

        EntityTransaction tx = em.getTransaction();  // 트랜잭션 기능 획득

        try {

            tx.begin();   // 트랜잭션 시작
            // TODO 비즈니스 로직
            tx.commit();  // 트랜잭션 커밋

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();  // 트랜잭션 롤백
        } finally {
            em.close();  // 엔티티 매니저 종료
        }

        emf.close();  // 엔티티 매니저 팩토리 종료
    }

    /**
     * 연관관계 저장
     */
    private static void testSave(EntityManager em) {

        // 회원1 저장
        Member member1 = new Member();
        em.persist(member1);

        // 주문1 저장
        Order order1 = new Order();
        order1.setMember(member1);  // 연관관계 설정 order1 -> member1
        em.persist(order1);

    }

    /**
     * 연관관계 조회
     */
    private static void queryLogicJoin(EntityManager em) {

        String jpql = "select o from Order o join o.member m where " +
                "m.name=:memberName";

        List<Order> resultList = em.createQuery(jpql, Order.class)
                .setParameter("memberName", "멤버이름1")
                .getResultList();

        // 결과: [query] order.ordername=주문1
        // 결과: [query] order.ordername=주문2
    }

    /**
     * 연관관계 수정
     */
    private static void updateRelation(EntityManager em) {

        // 새로운 회원2
        Member member2 = new Member();
        em.persist(member2);

        // 주문1에 새로운 회원2 설정
        Order order = em.find(Order.class, "order1");
        order.setMember(member2);
    }

    /**
     * 연관관계 제거
     */
    private static void deleteRelation(EntityManager em) {
        Order order1 = em.find(Order.class, "order1");
        order1.setMember(null);  // 연관관계 제거
    }

    /**
     * 일대다 방향으로 객체 그래프 탐색
     */
    private static void biDirection(EntityManager em) {

        Member member = em.find(Member.class, "member1");
        List<Order> orders = member.getOrders();  // (Member -> Order) 방향으로 연관관계 데이터를 조회하는 '객체 그래프 탐색'

        for (Order order : orders) {
            System.out.println("order.id = " +
                    order.getId());
        }
    }
}