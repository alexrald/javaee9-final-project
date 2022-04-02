package com.javaee9.javaee9finalproject.controller;

import com.javaee9.javaee9finalproject.dto.PostDto;
import com.javaee9.javaee9finalproject.entity.Post;
import com.javaee9.javaee9finalproject.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/posts")
// never - ever use entities inside controllers. Use DTOs.
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // /posts?boundary= vs /posts/recent
    @GetMapping("/recent")
    public List<PostDto> readRecentPosts() {

        log.info("reading recent posts");
        return postService.readAllRecentPosts();
    }

    @GetMapping("recent/{id}")
    public PostDto findRecentPostById(@PathVariable("id") Long postId) {
        // TODO: Finish Implementation
        // read Post by id from database
        // convert Post into PostDto
        // return to user

        return new PostDto(
                1L,
                "My Post",
                "Post Content",
                "me",
                "2000",
                "2001"
                );
    }

    // TODO: validation of DTO
    @PostMapping()
    // Without @RequestBody Spring expects parameters to be in the URL
    // With @RequestBody they should be in the request body
    public PostDto createNewPost(@Valid @RequestBody PostDto toStore) {
        log.info("trying to create new post: [{}]", toStore);

        return postService.createNewPost(toStore);
    }

}
