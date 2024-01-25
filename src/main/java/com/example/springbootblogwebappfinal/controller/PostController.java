package com.example.springbootblogwebappfinal.controller;

import com.example.springbootblogwebappfinal.Impl.PostService;
import com.example.springbootblogwebappfinal.entity.Post;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/admin/getAllPost")
    public String getAllBlogPost(Model model){

      List<Post> post = postService.findAll();
      model.addAttribute("post",post);
      return "/admin/posts";

    }

    @GetMapping("/admin/post/newPost")
    public String newPostViewForm(Model model){

        Post post = new Post();
        model.addAttribute("post",post);
        return "/admin/createPosts";

    }

    @PostMapping("/admin/post/createPost")
    public String createPost(@ModelAttribute Post post){

        post.setUrl(getUrl(post.getTitle()));
        postService.savePost(post);
        return "redirect:/admin/getAllPost";

    }

    private String getUrl(String title) {

        String url = title.trim().toLowerCase();
        String result = url.replaceAll("[^A-Za-z0-9]","-");
        result = url.replaceAll("\\s+","-");

        return url;



    }

    // handler method to edit the data
    @GetMapping("/admin/posts/{postId}/edit")
    public String editPost(@PathVariable("postId") Long postId,
                           Model model){

       Post editPost = postService.findById(postId);
       model.addAttribute("editPost",editPost);
       return "/admin/editPosts";

    }
    @PostMapping("/admin/savePost/{postId}")
    public String saveEditedPost(@ModelAttribute Post post,
                                 @PathVariable("postId") Long postId,
                                 Model model){

        post.setId(postId);
        postService.savePost(post);
        return "redirect:/admin/getAllPost";


    }

    @GetMapping("/admin/posts/{postId}/delete")
    public String deletePost(@PathVariable("postId") Long postId){

        postService.deleteById(postId);
        return "redirect:/admin/getAllPost";

    }

    @GetMapping("/admin/posts/{postUrl}/view")
    public String viewPost(@PathVariable("postUrl") String postUrl,
                           Model model){

        Post post = postService.findByUrl(postUrl);
        model.addAttribute("viewPost",post);
        return "/admin/viewPost";

    }

    @GetMapping("/admin/posts/search")
    public String searchPost(@RequestParam("query") String query,
                           Model model){

        List<Post>post = postService.searchPosts(query);
        model.addAttribute("post",post);
        return "/admin/posts";

    }
   /* @GetMapping("/admin/post/newPost")
    public String createPost(Model model){

        PostDto postDto = new PostDto();
        model.addAttribute("post",postDto);
        return "/admin/createPosts";

    }

    @GetMapping("/admin/posts/{postUrl}/view")
    public String getView(@PathVariable("postUrl") String url,
                          Model model){

      PostDto postDto = postService.findByUrl(url);
      model.addAttribute("post",postDto);
      return "/admin/viewPost";

    }

    @PostMapping("/admin/postCreate")
    public String savePost(@Valid @ModelAttribute("post") PostDto postDto,
                           BindingResult result,
                           Model model){

        if(result.hasErrors()){

            model.addAttribute("post",postDto);
            return "/admin/createPosts";
        }
        postDto.setUrl(getUrl(postDto.getTitle()));
        postService.createPost(postDto);
        return "redirect:/admin/getAllPost";
    }

    private String getUrl(String title) {

        String lowerCaseTitle = title.trim().toLowerCase();
        String url = lowerCaseTitle.replaceAll("[^A-Za-z0-9]","-");
        url = url.replaceAll("\\s+","-");

        return url;
    }

    // handler method to edit the data
    @GetMapping("/admin/posts/{postId}/edit")
    public String editPost(@PathVariable("postId") Long postId,
                                                  Model model){

        PostDto editPost = postService.findById(postId);
        model.addAttribute("editPost",editPost);
        return "/admin/editPosts";

    }


    // handler method to save edit  data
    @PostMapping ("/admin/editPost/{postId}")
    public String saveEditPost(@PathVariable("postId") Long postId,
                           @ModelAttribute("editPost") PostDto postDto,
                           Model model){

        postDto.setId(postId);
        postService.createPost(postDto);
        return "redirect:/admin/getAllPost";

    }

    // handler method to delete   data
    @GetMapping ("/admin/posts/{postId}/delete")
    public String deletePost(@PathVariable("postId") Long postId,

                               Model model){


        postService.deletePostById(postId);
        return "redirect:/admin/getAllPost";

    }

    // Write down the handler method to search the result.

    @GetMapping("/admin/posts/search")
    public String searchPost(@RequestParam(value= "query") String  query,

                             Model model){


        List<PostDto> searchList = postService.searchPosts(query);
        model.addAttribute("post", searchList);
        return "/admin/posts";

    }*/
}
