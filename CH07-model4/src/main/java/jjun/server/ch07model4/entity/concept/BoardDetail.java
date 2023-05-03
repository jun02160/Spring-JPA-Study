package jjun.server.ch07model4.entity.concept;

import javax.persistence.*;

/**
 * 일대일 식별 관계 - 자식
 */
@Entity
public class BoardDetail {
    
    @Id
    private Long boardId;
    
    @MapsId  // BoardDetail.boardId 매핑 (부모의 기본 키를 가져온 값)
    @OneToOne
    @JoinColumn(name = "BOARD_ID")
    private Board board;
    
    private String content;
}
