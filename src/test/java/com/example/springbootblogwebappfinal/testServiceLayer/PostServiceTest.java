package com.example.springbootblogwebappfinal.testServiceLayer;


import com.example.springbootblogwebappfinal.Impl.PostServiceImpl;
import com.example.springbootblogwebappfinal.entity.Post;
import com.example.springbootblogwebappfinal.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PostServiceTest {

    @Mock
    private PostRepository postRepository;


    @InjectMocks
    private PostServiceImpl postServiceImpl;


    @Test
    public void testForBlockList(){

        Post post1 = new Post("test_1","test_url","test_content","test_shortDescription", LocalDateTime.now(),LocalDateTime.now());
        Post post2 = new Post("test_2","test_url2","test_content2","test_shortDescription2", LocalDateTime.now(),LocalDateTime.now());

       List<Post> postList = new ArrayList<>();
       postList.add(post1);
       postList.add(post2);

       when(postRepository.findAll()).thenReturn(postList);

       List<Post> actualPostList = postServiceImpl.findAll();

       assertEquals(2,actualPostList.size());

 }

    @Test
    public void testForUrl(){

        Post post1 = new Post("test_1","test_url","test_content","test_shortDescription", LocalDateTime.now(),LocalDateTime.now());


        when(postRepository.findByUrl("test_url")).thenReturn(Optional.of(post1));

         Post actualPost = postServiceImpl.findByUrl("test_url");

        assertEquals(post1, actualPost);

    }

    @Test
    public void VerfiyfindAllMethod(){

        Post post1 = new Post("test_1","test_url","test_content","test_shortDescription", LocalDateTime.now(),LocalDateTime.now());
        Post post2 = new Post("test_2","test_url2","test_content2","test_shortDescription2", LocalDateTime.now(),LocalDateTime.now());

        List<Post> postList = new ArrayList<>();
        postList.add(post1);
        postList.add(post2);

        when(postRepository.findAll()).thenReturn(postList);

        postServiceImpl.findAll();

        Mockito.verify(postRepository).findAll();

    }

}
