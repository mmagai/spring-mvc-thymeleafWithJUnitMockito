package com.example.springbootblogwebappfinal.testControllerLayer;

import com.example.springbootblogwebappfinal.Impl.PostService;
import com.example.springbootblogwebappfinal.controller.PostController;
import com.example.springbootblogwebappfinal.entity.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@WebMvcTest(PostController.class)
public class PostControllerTest {

    @MockBean
    private PostService postService;

    @Autowired
    private MockMvc mockMvc;


    @Test
    void test_getAllBlogPost() throws Exception {

        Post post1 = new Post("test_1","test_url","test_content","test_shortDescription", LocalDateTime.now(),LocalDateTime.now());
        Post post2 = new Post("test_2","test_url2","test_content2","test_shortDescription2", LocalDateTime.now(),LocalDateTime.now());

        List<Post> postList = new ArrayList<>();
        postList.add(post1);
        postList.add(post2);

        when(postService.findAll()).thenReturn(postList);

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/admin/getAllPost"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("/admin/posts"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("post"))
                .andExpect(MockMvcResultMatchers.model().attribute("post",postList));

    }

}
