package StudetnskaPlatforma.Moodle.Repository;

import StudetnskaPlatforma.Moodle.Entity.Posts;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface postsRepository extends JpaRepository<Posts,String> {
    @Query(value="SELECT * FROM posts ORDER BY id DESC LIMIT 4", nativeQuery = true)
    List<Posts> findLastFourPosts();

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO posts (title, tekst, url) VALUES (?1, ?2, ?3)", nativeQuery = true)
    void savePost(String title, String tekst, String url);
}