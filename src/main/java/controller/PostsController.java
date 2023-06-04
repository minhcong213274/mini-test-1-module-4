package controller;
import model.Posts;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.IPostsService;
import service.PostsService;

import java.util.List;


@Controller
@RequestMapping("/posts")
public class PostsController {

    private final IPostsService postsService = new PostsService();

    @GetMapping("")
    public String index(Model model) {

        List<Posts> postsList = postsService.findAll();
        model.addAttribute("posts", postsList);
        return "/index";
    }
    @PostMapping("/update")
    public String update(Posts posts) {
        postsService.update(posts.getId(), posts);
        return "redirect:/posts";
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("posts", new Posts());
        return "/create";
    }
    @PostMapping("/save")
    public String save(Posts posts) {
        posts.setId((int) (Math.random() * 10000));
        postsService.save(posts);
        return "redirect:/posts";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("posts", postsService.findById(id));
        return "/edit";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("posts", postsService.findById(id));
        return "/delete";
    }
    @PostMapping("/delete")
    public String delete(Posts posts, RedirectAttributes redirect) {
        postsService.remove(posts.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/posts";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("posts", postsService.findById(id));
        return "/view";
    }
}