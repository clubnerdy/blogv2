package shop.mtcoding.blog.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserRepository {
    private final EntityManager em;

//    public void save2(User user) {
//        em.persist(user);
//    }

    public void save(String username, String password, String email) {
        // 회원가입 정보 저장 쿼리
        em.createNativeQuery("insert into user_tb (username, password, email) values (?, ?, ?)")
                .setParameter(1, username)
                .setParameter(2, password)
                .setParameter(3, email)
                .executeUpdate();
    }

    public User findByUsername(String username) {
        // 특정한 유저 아이디 찾기 쿼리
        return (User) em.createNativeQuery("select * from user_tb where username = ?", User.class)
                .setParameter(1, username)
                .getSingleResult();
    }

//    public User findByEmail(String email) {
//        // 특정한 유저 이메일 찾기 쿼리
//        return (User) em.createNativeQuery("select * from user_tb where email = ?", User.class)
//                .setParameter(1, email)
//                .getSingleResult();
//    }
}
