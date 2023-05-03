package jjun.server.ch08model5.concept;

import jjun.server.ch08model5.entity.Member;

import javax.persistence.EntityManager;

public class MemberProxy extends Member {

    Member target = null;  // 실제 엔티티 참조

    public String getName() {

        if (target == null) {
            // 2. 초기화 요청
            // 3. DB 조회
            // 4. 실제 엔티티 생성 및 참조 보관
//            this.target = ...;
        }

        // 5. target.getName();
        return target.getName();
    }

    public void init(EntityManager em) {
        // MemberProxy 반환
        Member member = em.getReference(Member.class, "id1");
        member.getName();  // 1. getName() : 프록시 객체의 메소드 호출
    }


}
