package jjun.server.apiadvanded.repository;

import jjun.server.apiadvanded.controller.dto.OrderItemQueryDto;
import jjun.server.apiadvanded.controller.dto.OrderQueryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderQueryRepository {

    private final EntityManager em;

    /**
     * 컬렉션은 별도로 조회
     * Query:  루트 1번, 컬렉션 N번
     * 단건 조회에서 많이 사용하는 방식
     * @return
     */
    public List<OrderQueryDto> findOrderQueryDtos() {

        List<OrderQueryDto> result = findOrders();  // 루트조회: ToOne을 한번에 조회

        // 루프를 돌며 OrderItem에 대한 컬렉션 추가 (=> 추가 쿼리)
        result.forEach(o -> {
            List<OrderItemQueryDto> orderItems = findOrderItems(o.getOrderId());
            o.setOrderItems(orderItems);
        });
        return result;
    }

    /**
     * 1:N관계(컬렉션)를 제외한 나머지를 한번에 조회
     * @return
     */
    private List<OrderQueryDto> findOrders() {
        return em.createQuery("select new jjun.server.apiadvanded.controller.dto.OrderQueryDto(o.id, m.name, o.orderDate, o.status, d.address) " +
                "from Order o " +
                "join o.member m " +
                "join o.delivery d", OrderQueryDto.class)
                .getResultList();
    }
}
