package jjun.server.ch09model6.entity;

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

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;   // ENUM : READY(준비), COMP(배송)

    public Delivery() {

    }

    public Delivery(Address address) {
        this.address = address;
        this.status = DeliveryStatus.READY;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", address=" + address +
                ", status=" + status +
                '}';
    }
}
