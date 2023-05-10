package jjun.server.ch10book.criteria;

import jjun.server.ch10book.Member;
import jjun.server.ch10book.Team;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

public class Criteria {

    public void createCriteriaQuery(EntityManager em) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        // 조회값 반환 타입: Object
        CriteriaQuery<Object> cq = cb.createQuery();

        List<Object> resultList = em.createQuery(cq).getResultList();

        // 조회값 반환 타입: Object[]
        CriteriaQuery<Object[]> cq2 = cb.createQuery(Object[].class);
        List<Object[]> resultList2 = em.createQuery(cq2).getResultList();

        // 조회값 반환 타입: Tuple
        CriteriaQuery<Tuple> cq3 = cb.createTupleQuery();
        TypedQuery<Tuple> query = em.createQuery(cq3);

    }

    public void creiteriaSubQuery(EntityManager em) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Member> mainQuery = cb.createQuery(Member.class);

        // 서브 쿼리 생성
        Subquery<Double> subQuery = mainQuery.subquery(Double.class);
        Root<Member> m2 = subQuery.from(Member.class);
        subQuery.select(cb.avg(m2.<Integer>get("age")));

        // 메인 쿼리 생성
        Root<Member> m = mainQuery.from(Member.class);  // 서브 쿼리에서 사용되는 메인 쿼리의 m
        mainQuery.select(m)
                .where(cb.ge(m.<Integer>get("age"), subQuery))
                .where(cb.equal(m2.get("username"), m.get("username")));

        Root<Member> subM = subQuery.correlate(m);  // 메인 쿼리의 별칭을 가져옴
    }

    public void creiteriaDynamicQuery(EntityManager em) {
        // 검색 조건
        Integer age = 10;
        String username = null;
        String teamName = "팀A";

        // Criteria 동적 쿼리 생성
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Member> cq = cb.createQuery(Member.class);

        Root<Member> m = cq.from(Member.class);
        Join<Member, Team> t = m.join("team");

        List<Predicate> criteria = new ArrayList<>();

        if (age != null) criteria.add(cb.equal(m.<Integer>get("age"),
                cb.parameter(Integer.class, "age")));
        if (username != null) criteria.add(cb.equal(m.get("username"),
                cb.parameter(String.class, "username")));
        if (teamName != null) criteria.add(cb.equal(t.get("name"),
                cb.parameter(String.class, "teamName")));

        cq.where(cb.and(criteria.toArray(new Predicate[0])));

        TypedQuery<Member> query = em.createQuery(cq);
        if (age != null) query.setParameter("age", age);
        if (username != null) query.setParameter("username", username);
        if (teamName != null) query.setParameter("teamName", teamName);

        List<Member> resultList = query.getResultList();


    }

}
