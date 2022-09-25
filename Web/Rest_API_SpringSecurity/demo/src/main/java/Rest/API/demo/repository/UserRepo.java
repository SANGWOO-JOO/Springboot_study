package Rest.API.demo.repository;

import Rest.API.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User findByName(String name);

    User findByEmail(String email);
}