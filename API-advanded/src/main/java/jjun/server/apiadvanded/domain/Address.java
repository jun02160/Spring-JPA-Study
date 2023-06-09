package jjun.server.apiadvanded.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable  // 어디엔가 내장될 수 있다
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    protected Address() {
    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
