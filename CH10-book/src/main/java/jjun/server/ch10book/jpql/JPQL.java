package jjun.server.ch10book.jpql;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

import jjun.server.ch10book.jpql.UserDTO;

public class JPQL {

    public void test(EntityManager em) {

        // NEW 명령어 사용 전
        List<Object[]> resultList = em.createQuery("SELECT m.username, m.age FROM Member m")
                .getResultList();

        // 객체 변환 과정
        List<UserDTO> userDTOs = new ArrayList<UserDTO>();
        for (Object[] row : resultList) {
            UserDTO userDTO = new UserDTO((String) row[0], (Integer) row[1]);
            userDTOs.add(userDTO);
        }

        // NEW 명령어 사용 후
        TypedQuery<UserDTO> query = em.createQuery("SELECT new jjun.server.jpql.UserDTO(m.username, m.age)" +
                "FROM Member m", UserDTO.class);

        List<UserDTO> resultList = query.getResultList();
    }
}
