package jjun.server.ch08model5.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@Getter @Setter
@MappedSuperclass
public class BaseEntity {

    private Date createdDate;       // 등록일자
    private Date lastModifiedDate;  // 최종 수정일자
}
