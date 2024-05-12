package StudetnskaPlatforma.Moodle.Repository;


import StudetnskaPlatforma.Moodle.Entity.Users;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface userRepository extends JpaRepository<Users,String> {

    @Query(value = "select * from users where username = ?1", nativeQuery = true)
    Optional<Users> findUserByUsername(String username);
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO users (username, password, email, role) VALUES (?1, ?2, ?3, 'USER')", nativeQuery = true)
    void saveUser(String username, String password, String email);
}
