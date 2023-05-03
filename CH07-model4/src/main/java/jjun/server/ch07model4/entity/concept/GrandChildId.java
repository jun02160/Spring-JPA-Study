package jjun.server.ch07model4.entity.concept;

import java.io.Serializable;

public class GrandChildId implements Serializable {

    private ChildId child;  // GrandChild.child 매핑
    private String id;      // GrandChild.id 매핑

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
