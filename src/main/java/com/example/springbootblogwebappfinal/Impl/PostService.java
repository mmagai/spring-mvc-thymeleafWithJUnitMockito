package com.example.springbootblogwebappfinal.Impl;

import com.example.springbootblogwebappfinal.entity.Post;


import java.util.List;

public interface PostService {

    public List<Post> findAll();

    List<Post> findAllUsingJDBC();

   // void createPost(Post post);

    Post findById(Long postId);

    void savePost(Post post);

    void deleteById(Long postId);

    Post findByUrl(String postUrl);
    //List<Post> findAll();

    //void createPost(PostDto postDto);

   //// PostDto findById(Long postId);


     List<Post>searchPosts(String query);
   // void deletePostById(Long postId);

   // List<PostDto> searchPosts(String query);

    //PostDto findByUrl(String url);
}
