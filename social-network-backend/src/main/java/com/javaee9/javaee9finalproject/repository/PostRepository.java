package com.javaee9.javaee9finalproject.repository;

import com.javaee9.javaee9finalproject.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByCreationTimestampGreaterThan(ZonedDateTime boundary);

    // @Query uses entity names, not table names
    @Query("""
        SELECT p
        FROM Post p
        WHERE (p.creationTimestamp >= :boundary)
""")
    List<Post> queryAllRecentPosts(@Param("boundary") ZonedDateTime boundary);

    // Alias for findAllByCreationTimestampGreaterThan
    default List<Post> readAllRecentPosts(ZonedDateTime boundary) {
        return findAllByCreationTimestampGreaterThan(boundary);
    }

}
