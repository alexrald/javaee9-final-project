package com.javaee9.javaee9finalproject.service;

import com.javaee9.javaee9finalproject.converter.PostConverter;
import com.javaee9.javaee9finalproject.dto.PostDto;
import com.javaee9.javaee9finalproject.entity.Post;
import com.javaee9.javaee9finalproject.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PostService {

    private final PostRepository postRepository;
    private final PostConverter postConverter;

    public PostService(PostRepository postRepository, PostConverter postConverter) {
        this.postRepository = postRepository;
        this.postConverter = postConverter;
    }

    public List<Post> readAllPosts() {
        log.info("Reading all posts");
        return postRepository.findAll();
    }


    // TODO
    // migrate to dto
    // what about exceptions?
    // use @ExceptionHandler for dealing with internal issues

    public List<PostDto> readAllRecentPosts() {
        return readAllRecentPosts(24);
    }

    public List<PostDto> readAllRecentPosts(int hoursBack) {
        ZonedDateTime boundary = ZonedDateTime.now(Clock.systemUTC()).minusHours(hoursBack);

        return readAllRecentPosts(boundary);
    }

    public List<PostDto> readAllRecentPosts(ZonedDateTime boundary) {
        var postList = postRepository.queryAllRecentPosts(boundary);
        log.info("Reading all recent posts since [{}], number of posts: [{}]", boundary, postList.size());
        log.debug("result: {}", postList);

        return postList
                .stream()
//                .map(post -> postConverter.entityToDto(post))
                .map(postConverter::entityToDto)
                .toList();
    }
}
