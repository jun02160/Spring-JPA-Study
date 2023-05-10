package jjun.server.ch10book;

import org.hibernate.sql.Select;

import javax.persistence.criteria.AbstractQuery;
import javax.persistence.criteria.Selection;
import java.util.List;

public interface CriteriaQuery<T> extends AbstractQuery<T> {

    // 한 건 지정
    CriteriaQuery<T> select(Selection<? extends T> selection);;

    // 여러 건 지정
    CriteriaQuery<T> multiselect(Selection<?> ... selections);

    // 여러 건 지정
    CriteriaQuery<T> multiselect(List<Selection<?>> selectionList);
}
