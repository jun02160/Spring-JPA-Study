package jjun.server.ch10book;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class MemberDao {

    private void test(EntityManager em) {

        // 쿼리 생성
        String jpql = "select m from Member as m where m.username='kim'";  // 엔티티 객체의 필드명으로 작성
        List<Member> resultList = em.createQuery(jpql, Member.class).getResultList();


        /**
         * Criteria 를 사용한 쿼리 작성
         */
        // Criteria 사용 준비
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Member> query = cb.createQuery(Member.class);

        // 루트 클래스(조회를 시작할 클래스)
        Root<Member> m = query.from(Member.class);

        // 쿼리 생성
        CriteriaQuery<Member> cq = query.select(m).where(cb.equal(m.get("username"), "kim"));
        List<Member> resultList = em.createQuery(cq).getResultList();
    }
}
