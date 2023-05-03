package jjun.server.ch07model4.entity.concept;

import java.io.Serializable;

public class ChildId implements Serializable {

    private String parent;   // Child.parent 매핑
    private String childId;  // Child.childId 매핑

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
