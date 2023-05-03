package jjun.server.ch07model4.entity.concept;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * 식별자 클래스 for 복합 키 사용
 * - 식별자 클래스는 public으로 지정
 */
public class ParentId implements Serializable {

    private String id1;  // Parent.id1 매핑
    private String id2;  // Parent.id2 매핑

    // 식별자 클래스에는 디폴트 생성자가 존재해야 한다.
    public ParentId() {

    }

    public ParentId(String id1, String id2) {
        this.id1 = id1;
        this.id2 = id2;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

/*  @Embeddable를 이용한 식별자 클래스 생성 (@IdClass 방식보다 객체 지향적인 성격을 띤다.)
@Embeddable
public class ParentId implements Serializable {

    @Column(name = "PARENT_ID1")
    private String id1;

    @Column(name = "PARENT_ID2")
    private String id2;

    // equals와 hashCode 구현
}
 */