package com.codewithhims.blog_app_apis.services;

import com.codewithhims.blog_app_apis.entities.Post;
import com.codewithhims.blog_app_apis.payloads.PostDto;
import com.codewithhims.blog_app_apis.payloads.PostResponse;

import java.util.List;

public interface PostService {


    //create
    PostDto createPost(PostDto postDto ,Integer userId,Integer categoryId);

    //update
    PostDto updatePost(PostDto postDto ,Integer postId);

    //delete
    void deletePost(Integer postId);

    //getAllPost

    PostResponse getAllPost(Integer pageNumber, Integer pageSize,String sortBy,String sortDir);

    //getSinglePost

    PostDto getPostById(Integer PostId);

    //get All Posts by category

    List<PostDto>getPostsByCategory(Integer categoryId);

    //get All posts by user

    List<PostDto>getPostsByUser(Integer userId);


    //Search post
    List<PostDto>searchPosts(String keyword);


}
