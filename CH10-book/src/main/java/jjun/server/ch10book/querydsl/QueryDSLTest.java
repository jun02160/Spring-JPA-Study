package jjun.server.ch10book.querydsl;

import com.querydsl.jpa.impl.JPAQuery;
import jjun.server.ch10book.Member;
import jjun.server.ch10book.QMember;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class QueryDSLTest {

    EntityManagerFactory emf;

    public void queryDSL() {
        EntityManager em = emf.createEntityManager();

        JPAQuery query = new JPAQuery(em);
        QMember qMember = new QMember("m");  // 생성되는 JPQL의 별칭: m
        List<Member> members = query.from(qMember)
                .where(qMember.username.eq("회원1"))
                .orderBy(qMember.username.desc())
                .list(qMember);
    }
}
