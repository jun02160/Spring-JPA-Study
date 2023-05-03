package jjun.server.ch07model4.entity.concept;

import javax.persistence.*;

@Entity
@IdClass(ChildId.class)
public class Child {

    @Id
    @Column(name = "CHILD_ID")
    private String childId;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "PARENT_ID1", referencedColumnName = "PARENT_ID1"),
            @JoinColumn(name = "PARENT_ID2", referencedColumnName = "PARENT_ID2")
    })
    private Parent parent;

    /*
    @EmbeddedId
    private ChildId id;

    @MapsId("parentId")   // ChildId.parentId 매핑
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    public Parent parent;

     */
}
