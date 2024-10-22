package com.codewithhims.blog_app_apis.controllers;


import com.codewithhims.blog_app_apis.payloads.ApiResponse;
import com.codewithhims.blog_app_apis.payloads.PostDto;
import com.codewithhims.blog_app_apis.payloads.PostResponse;
import com.codewithhims.blog_app_apis.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;


    //create
    @PostMapping("/users/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto>createPost(
            @RequestBody PostDto postDto,
            @PathVariable Integer userId,
            @PathVariable Integer categoryId
    )
    {
        PostDto createPost= this.postService.createPost(postDto ,userId,categoryId);
        return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED);

    }

    //get by user
    @GetMapping("/users/{userId}/posts")
    public ResponseEntity<List<PostDto>>getPostsByUser(
            @PathVariable Integer userId
    )
    {
        List<PostDto>posts=this.postService.getPostsByUser(userId);
        return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
    }

    //get by category
    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>>getPostsByCategory(
            @PathVariable Integer categoryId
    )
    {
        List<PostDto>posts=this.postService.getPostsByCategory(categoryId);
        return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
    }

    // get all post
    @GetMapping("/posts")
    public ResponseEntity<PostResponse> getAllPost(
            @RequestParam(value="pageNumber" ,defaultValue = "0",required=false)Integer pageNumber,
            @RequestParam(value="pageSize",defaultValue="10",required=false) Integer pageSize,
            @RequestParam(value="sortBy",defaultValue="postId",required=false) String sortBy,
            @RequestParam(value="sortDir",defaultValue="asc",required=false) String sortDir

            )
    {
         PostResponse postResponse=this.postService.getAllPost(pageNumber,pageSize,sortBy,sortDir);
         return new ResponseEntity<PostResponse>(postResponse,HttpStatus.OK);

    }

    //get post detail by id
    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDto>getPostById(@PathVariable Integer postId)
    {
        PostDto posts =this.postService.getPostById(postId);
        return new ResponseEntity<PostDto>(posts,HttpStatus.OK);

    }

    //delete post
    @DeleteMapping("/posts/{postId}")
    public ApiResponse deletePost(@PathVariable Integer postId)
    {
        this.postService.deletePost(postId);
       return new ApiResponse("Post is Successfully deleted " , true);
    }

    //update post
    @PutMapping("/posts/{postId}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,@PathVariable Integer postId)
   {
      PostDto updatePost= this.postService.updatePost(postDto,postId);
       return new ResponseEntity<PostDto>(updatePost,HttpStatus.OK);
   }

   //searching
    @GetMapping("/posts/search/{keywords}")
    public ResponseEntity<List<PostDto>>searchPostByTitle(
           @PathVariable("keywords") String keywords
    )
    {
      List<PostDto> result = this.postService.searchPosts(keywords);
      return new ResponseEntity<List<PostDto>>(result,HttpStatus.OK);
    }


}
