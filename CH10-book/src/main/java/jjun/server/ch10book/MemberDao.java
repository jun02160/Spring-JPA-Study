package jjun.server.ch10book;

import org.hibernate.Session;
import org.hibernate.jdbc.Work;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Connection;
import java.sql.SQLException;
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

        /**
         * QueryDSL 을 사용한 쿼리 작성
         */
        // 준비
        JPAQuery query = new JPAQuery(em);
        QMember member = QMember.member;

        // 쿼리, 결과 조회
        List<Member> members = query.from(member)
                .where(member.username.eq("kim"))
                .list(member);

        /**
         * Native SQL
         */
        String sql = "SELECT ID, AGE, NAME FROM MEMBER WHERE NAME='kim'";
        List<Member> resultList = em.createQuery(sql, Member.class).getResultList();

        /**
         * JDBC 직접 사용, 마이바티스 같은 SQL Mapper 프레임워크 사용
         */
        Session session = em.unwrap(Session.class);
        session.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                // work ...
            }
        });
    }
}
