package jjun.server.ch10book.criteria;

import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaQuery;

public interface CriteriaBuilder {

    CriteriaQuery<Object> createQuery();  // 조회값 반환 타입: Object

    // 조회값 반환 타입: 엔티티, 임베디드 타입, 기타
    <T> CriteriaQuery<T> createQuery(Class<T> resultClass);
    CriteriaQuery<Tuple> createTupleQuery();  // 조회값 반환 타입: Tuple
}
