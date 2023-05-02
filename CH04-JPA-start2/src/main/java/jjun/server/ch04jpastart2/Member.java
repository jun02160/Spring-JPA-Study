package jjun.server.ch04jpastart2;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter
@Entity
@Table(name = "MEMBER", uniqueConstraints = {@UniqueConstraint(  // 유니크 제약조건 추가 'ALTER TABLE MEMBER ADD CONSTRAINT NAME_AGE_UNIQUE UNIQUE (NAME, AGE)'
        name = "NAME_AGE_UNIQUE",
        columnNames = {"NAME", "AGE"})})
public class Member {

    @Id   // 기본 키 매핑
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME", nullable = false, length = 10)  // not null 제약조건, 문자의 크기 지정 추가 -> DDL 생성 기능 (제약조건)
    private String username;

    private Integer age;

    // 자바의 enum을 매핑하여 사용하기 위한 어노테이션 ➡️ VARCHAR 타입으로 테이블에 저장
    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE_TYPE")  // 📓자바는 언어 관례상 카멜 표기법을 주로 사용하고, 데이터베이스는 관례상 언더스코어를 주로 사용한다.
    private RoleType roleType;

    // Java의 날짜 타입 : @Temporal을 사용해서 매핑 ➡️ TIMESTAMP 타입으로 테이블에 저장
    @Temporal(TemporalType.TIMESTAMP)  // 날짜와 시간 타입으로 매핑
    private Date createdDate;   // 회원 가입일

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;   // 수정일

    @Lob   // VARCHAR 타입 대신 CLOB,BLOB 타입으로 매핑 가능 (길이 제한X) ➡️ CLOB 타입으로 테이블에 저장
    private String description;   // 회원 설명

    @Transient
    private String temp;

}
