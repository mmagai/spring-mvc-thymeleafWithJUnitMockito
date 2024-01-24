package com.example.springbootblogwebappfinal.Impl;

import com.example.springbootblogwebappfinal.entity.Post;
import com.example.springbootblogwebappfinal.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;




    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> findAll() {
         List<Post> postList = postRepository.findAll();
         return postList;
        //return postList.stream().map((post)-> PostMapper.mapPostEntityToPostDto(post)).collect(Collectors.toList());
    }


    @Override
    public List<Post> findAllUsingJDBC() {


            String sql = "select * from posts";
            RowMapper<Post> rowMapper = new RowMapper<Post>() {
                @Override
                public Post mapRow(ResultSet rs, int rowNum) throws SQLException {

                    Post post = new Post(rs.getString(5),rs.getString(7),

                            rs.getString(2),
                     rs.getString(4),
                       null,
                     null);
                    return post;
                }
            };

            List<Post> result = jdbcTemplate.query(sql, rowMapper);
            return result;


        //return postList.stream().map((post)-> PostMapper.mapPostEntityToPostDto(post)).collect(Collectors.toList());
    }

    @Override
    public void createPost(Post post) {
         postRepository.save(post);
    }

   /* @Override
    public List<Post> findAll() {
       List<Post> postList = postRepository.findAll();
        return postList;
       // return postList.stream().map((post)-> PostMapper.mapPostEntityToPostDto(post)).collect(Collectors.toList());
    }
    @Override
    public void createPost(PostDto postDto) {
        Post post = PostMapper.mapPostDtoEntityToPost(postDto);
        postRepository.save(post);
    }

    @Override
    public PostDto findById(Long postId) {

        Post post = postRepository.findById(postId).get();
        return  PostMapper.mapPostEntityToPostDto(post);

    }

    @Override
    public void deletePostById(Long postId) {
        postRepository.deleteById(postId);
    }

    @Override
    public List<PostDto> searchPosts(String query) {
        List<Post> postList = postRepository.searchPosts(query);
        return postList.stream().map((post)->
                PostMapper.mapPostEntityToPostDto(post)).collect(Collectors.toList());
    }

    @Override
    public PostDto findByUrl(String url) {
        Post post = postRepository.findByUrl(url).get();
        return PostMapper.mapPostEntityToPostDto(post);
    }

*/



}
