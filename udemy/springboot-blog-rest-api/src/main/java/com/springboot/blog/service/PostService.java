package com.springboot.blog.service;

import com.springboot.blog.payload.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PostService {
    //필드 : 반환 유형
    PostDto createPost(PostDto postDto);

    List<PostDto> getAllPosts();

}
