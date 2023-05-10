package jjun.server.ch10book;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class Team {

    @OneToMany
    List<Member> members = new ArrayList<Member>();
}
