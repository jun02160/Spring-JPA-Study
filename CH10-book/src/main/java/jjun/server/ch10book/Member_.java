package jjun.server.ch10book;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Member 엔티티의 메타 모델 클래스
 */
@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Member.class)
public abstract class Member_ {

    public static volatile SingularAttribute<Member, Long> id;
    public static volatile SingularAttribute<Member, String> username;
    public static volatile SingularAttribute<Member, Integer> age;
    public static volatile SingularAttribute<Member, Team> team;
}
