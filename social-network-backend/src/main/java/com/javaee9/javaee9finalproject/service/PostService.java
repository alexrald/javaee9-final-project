package com.javaee9.javaee9finalproject.service;

import com.javaee9.javaee9finalproject.entity.Post;
import com.javaee9.javaee9finalproject.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.ZonedDateTime;
import java.util.List;

@Service
@Slf4j
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> readAllPosts() {
        log.info("Reading all posts");
        return postRepository.findAll();
    }


    // TODO
    // migrate to dto
    // what about exceptions?
    // use @ExceptionHandler for dealing with internal issues

    public List<Post> readAllRecentPosts() {
        return readAllRecentPosts(24);
    }

    public List<Post> readAllRecentPosts(int hoursBack) {
        ZonedDateTime boundary = ZonedDateTime.now(Clock.systemUTC()).minusHours(hoursBack);

        return readAllRecentPosts(boundary);
    }

    public List<Post> readAllRecentPosts(ZonedDateTime boundary) {
        var result = postRepository.queryAllRecentPosts(boundary);
        log.info("Reading all recent posts since [{}], number of posts: [{}]", boundary, result.size());
        log.debug("result: {}", result);

        return result;
    }
}
