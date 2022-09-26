package Rest.API.demo.repository;

import Rest.API.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User findByName(String name);

    User findByEmail(String email);

    Optional<User> findByUid(String email); //회원 가입 시 가입한 이메일 조회
}