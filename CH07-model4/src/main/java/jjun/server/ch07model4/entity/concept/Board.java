package jjun.server.ch07model4.entity.concept;

import javax.persistence.*;

/**
 * 일대일 식별 관계 - 부모
 */
@Entity
@Table(name = "BOARD")
@SecondaryTable(name = "BOARD_DETAIL",
    pkJoinColumns = @PrimaryKeyJoinColumn(name = "BOARD_DETAIL_ID"))
public class Board {

    @Id @GeneratedValue
    @Column(name = "BOARD_ID")
    private Long id;

    private String title;

    @Column(table = "BOARD_DETAIL")
    private String content;

    /*
    @OneToOne(mappedBy = "board")
    private BoardDetail boardDetail;

     */
}
