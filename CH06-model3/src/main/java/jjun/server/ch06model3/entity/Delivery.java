package jjun.server.ch06model3.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "DELIVERY_ID")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    private String city;
    private String street;
    private String zipode;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;   // ENUM : READY(준비), COMP(배송)
}
