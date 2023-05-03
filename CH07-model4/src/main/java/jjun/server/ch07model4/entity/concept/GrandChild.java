package jjun.server.ch07model4.entity.concept;

import javax.persistence.*;

@Entity
@IdClass(GrandChildId.class)
public class GrandChild {

    @Id
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "PARENT_ID"),
            @JoinColumn(name = "CHILD_ID")
    })
    private Child child;

    @Id @Column(name = "GRANDCHILD_ID")
    private String id;

    private String name;

    /*
    @EmbeddedId
    private GrandChildId id;

    @MapsId("childId")  // GrandChildId.childId 매핑
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "PARENT_ID"),
            @JoinColumn(name = "CHILD_ID")
    })
    private Child child;

     */
}
