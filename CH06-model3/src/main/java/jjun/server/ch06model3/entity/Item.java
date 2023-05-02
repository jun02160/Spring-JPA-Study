package jjun.server.ch06model3.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter @Setter
@Entity
public class Item {

    @Id @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;   // 이름
    private int price;   // 가격
    private int stockQuantity;  // 재고수량

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name=" + name + '\'' +
                ", price=" + price +
                "}";
    }
}
