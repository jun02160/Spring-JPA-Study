package jjun.server.ch10book.querydsl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import jjun.server.ch10book.Item;
import jjun.server.ch10book.Member;
import jjun.server.ch10book.QMember;
import org.springframework.util.StringUtils;

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

        // 동적 쿼리
        SearchParam param = new SearchParam();
        param.setName("박예준");
        param.setPrice(10000);

        QItem item = QItem.item;

        BooleanBuilder builder = new BooleanBuilder();
        if (StringUtils.hasText(param.getName())){
            builder.and(item.name.contains(param.getName()));
        }
        if (param.getPrice() != null) {
            builder.and(item.price.gt(param.getPrice()));
        }
        List<Item> result = query.from(item)
                .where(builder)
                .list(item);
    }
}
