package jjun.server.ch10book;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name = "MEMBER")  // name 속성의 기본값은 클래스명
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "name")
    private String username;  // 상태 필드

    @Column(name = "age")
    private Integer age;  // 상태 필드

    @ManyToOne
    private Team team;  // 연관 필드(단일 값 연관 필드)

    @OneToMany
    private List<Order> orders;  // 연관 필드(컬렉션 값 연관 필드)

}
