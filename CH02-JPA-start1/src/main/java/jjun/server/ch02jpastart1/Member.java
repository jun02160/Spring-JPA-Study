package jjun.server.ch02jpastart1;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="MEMBER")
public class Member {

    private String id;

    private String username;

    private Integer age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
