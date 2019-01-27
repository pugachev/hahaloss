package com.ikefukuro.hahaloss;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("hahaloss")
public class HahalossController {
    @Autowired
    HahalossPostsService hahalossPotsService;
    @Autowired
    HahalossCommentsService hahalossComentsService;

    @ModelAttribute
    PartialForm setPartialForm() {
        return new PartialForm();
    }

    @ModelAttribute
    PostForm setPostsForm() {
        return new PostForm();
    }
    @GetMapping
    String index(Model model) {
        List<Posts> posts = hahalossPotsService.findAll();
        model.addAttribute("posts", posts);
        return "index";
    }

    @PostMapping(path = "commentsDisp")
    String commentsDisp(Model model,@Validated PartialForm form) {
        Posts posts = hahalossPotsService.findPostsById(Integer.parseInt(form.getId()));
        model.addAttribute("posts", posts);

        List<Comments> comments = hahalossComentsService.findCommentsById(Integer.parseInt(form.getId()));
        model.addAttribute("comments", comments);
        return "comments";
    }

    @RequestMapping(value = "/redirectCommentsDisp", method = RequestMethod.GET)
    public String redirectCommentsDisp(Model model,@ModelAttribute("pId") String pId) {
        Posts posts = hahalossPotsService.findPostsById(Integer.parseInt(pId));
        model.addAttribute("posts", posts);

        List<Comments> comments = hahalossComentsService.findCommentsById(Integer.parseInt(pId));
        model.addAttribute("comments", comments);
        return "comments";
    }

    @GetMapping(path = "createPostDisp")
    String createPostDisp(Model model) {
        return "createPost";
    }


    @PostMapping(path = "addPost")
    String addPost(@Validated PostForm form, BindingResult result) {

        Posts post = new Posts();
        post.setTitle(form.getTitle());
        post.setBody(form.getBody());
        Date date = new Date();
    	DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
        post.setCreated_at(df.format(date));
        post.setUpdated_at(df.format(date));
        hahalossPotsService.create(post);

        return "redirect:/hahaloss";
    }

    @PostMapping(path = "addComment")
    String addComment(RedirectAttributes redirectAttributes,@Validated CommentForm form,@Validated PartialForm hiddenform, BindingResult result) {

    	System.out.println("hiddenform.getId()="+hiddenform.getId());
        Comments comment = new Comments();
        comment.setBody(form.getBody());
        Date date = new Date();
    	DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
    	comment.setPost_id(Integer.parseInt(hiddenform.getId()));
    	comment.setCreated_at(df.format(date));
    	comment.setUpdated_at(df.format(date));
    	hahalossComentsService.create(comment);

    	redirectAttributes.addAttribute("pId", hiddenform.getId());
        return "redirect:redirectCommentsDisp";

    }

}