package com.example.springbootblogwebappfinal.Impl;

import com.example.springbootblogwebappfinal.entity.Post;


import java.util.List;

public interface PostService {

    public List<Post> findAll();

    List<Post> findAllUsingJDBC();

    void createPost(Post post);
    //List<Post> findAll();

    //void createPost(PostDto postDto);

   //// PostDto findById(Long postId);



   // void deletePostById(Long postId);

   // List<PostDto> searchPosts(String query);

    //PostDto findByUrl(String url);
}
