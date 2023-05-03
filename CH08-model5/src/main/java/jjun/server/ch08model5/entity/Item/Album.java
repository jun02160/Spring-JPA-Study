package jjun.server.ch07model4.entity.Item;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter @Setter @ToString
@Entity
@DiscriminatorValue("A")
public class Album extends Item {

    private String artist;
    private String etc;

}
