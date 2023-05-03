package jjun.server.ch07model4.entity.concept;

import javax.persistence.*;

@Entity
@IdClass(ParentId.class)  // ParentId 클래스를 식별자 클래스로 지정 -> Parent 테이블의 복합 키가 된다.
public class Parent {

    @Id
    @Column(name = "PARNET_ID1")
    private String id1;   // ParentId.id1과 연결

    @Id
    @Column(name = "PARNET_ID2")
    private String id2;   // ParentId.id2과 연결

    private String name;
}

/*  @EmbeddedId를 이용한 복합 키 매핑 (@IdClass 방식보다 객체 지향적인 성격을 띤다.)
@Entity
public class Parent {

    @EmbeddedId
    private ParentId id;

    private String name;
}

 */
