package sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sample.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
