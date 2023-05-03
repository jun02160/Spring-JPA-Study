package jjun.server.ch07model4.entity.Item;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Getter @Setter @ToString
@Entity
@DiscriminatorValue("B")
@PrimaryKeyJoinColumn(name = "BOOK_ID")  // (default) 자식 테이블은 부모 테이블의 ID 컬럼명을 그대로 사용 -> [ID 재정의] 이를 자식 테이블의 기본 키 컬럼명을 변경하고 싶을 때 사용
public class Book extends Item {

    private String author;
    private String isbn;

}
