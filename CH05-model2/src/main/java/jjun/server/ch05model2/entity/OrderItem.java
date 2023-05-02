package jjun.server.ch05model2.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table(name = "ORDER_ITEM")
public class OrderItem {

    @Id @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    private Long id;

    //== 연관관계 매핑 ==//
    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;   // 주문 상품

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;     // 주문

    private int orderPrice;  // 주문 가격
    private int count;       // 주문 수량

    //== 연관관계 설정 ==//
    public void setItem(Item item) {
        this.item = item;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", buyPrice=" + orderPrice +
                ", count=" + count +
                '}';
    }
}

