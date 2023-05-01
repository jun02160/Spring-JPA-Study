package jjun.server.ch04jpastart2;

import javax.persistence.*;
import java.util.List;

/**
 * 실행 클래스
 */
public class JpaMain {
    public static void main(String[] args) {

        // 엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager();  // 엔티티 매니저 생성

        EntityTransaction tx = em.getTransaction();  // 트랜잭션 기능 획득

        try {

            tx.begin();   // 트랜잭션 시작
            logic(em);    // 비즈니스 로직
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
     * 회원 엔티티를 생성하고, 엔티티 매니저를 통해 DB에 등록/수정/삭제/조회하는 비즈니스 로직
     */
    private static void logic(EntityManager em) {

        String id = "id2";

        Member member = new Member();
        member.setId(id);
        member.setUsername("박예준");
        member.setAge(20);

        // 등록 'INSERT INTO MEMBER(ID, NAME, AGE) VALUES ('id1', '박예준', 20)
        em.persist(member);  // 엔티티 매니저 = 객체를 저장하는 '가상의 데이터베이스' ➡️ JPA는 엔티티가 저장되면 이 매핑 정보를 분석해 SQL을 만들고 DB에 전달한다.

        // 수정 'UPDATE MEMBER SET AGE=22, NAME='박예준' WHERE ID='id1'
        member.setAge(22);  // update() 메소드가 아닌, 엔티티 값의 변경을 추적하는 JPA의 기능으로 setter에 의한 값 변경만으로 DB에 수정 내용을 반영할 수 있다.

        // 1건 조회 'SELECT * FROM MEMBER WHERE ID='id1'
        Member findMember = em.find(Member.class, id);  // 조회할 엔티티 타입과 식별자 값으로 조회한 SQL 결과 값을 이용해 엔티티를 생성하서 반환한다.
        System.out.println("findMember = " + findMember.getUsername() + ", age = " + findMember.getAge());

        // 멤버 목록 조회 ☑️ jpql 사용
        TypedQuery<Member> query = em.createQuery("select m from Member m", Member.class);   // 쿼리 객체 상성
        List<Member> memberList = query.getResultList();  // 쿼리 객체의 결과 메소드 호출
        System.out.println("members.size = " + memberList.size());

        // 삭제 'DELETE FROM MEMBER WHERE ID='id1'
        em.remove(member);   // 삭제하려는 엔티티를 넘겨주면 JPA는 알아서 DELETE SQL을 생성하고 실행한다.
    }
}
