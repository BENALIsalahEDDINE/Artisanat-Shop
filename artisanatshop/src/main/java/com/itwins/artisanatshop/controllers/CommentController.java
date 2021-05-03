package com.itwins.artisanatshop.controllers;

import com.itwins.artisanatshop.models.Comment;
import com.itwins.artisanatshop.models.User;
import com.itwins.artisanatshop.services.CommentService;
import com.itwins.artisanatshop.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
public class CommentController {
    @Autowired
    private UserService userService;
    @Autowired
    private CommentService commentService;
    @CrossOrigin()
    @PostMapping("comment/add/{userId}")
    public Comment addComment(@RequestBody Map<String, Object> commentMap,@PathVariable int userId) {
        Comment comment = new Comment(commentMap);
        Date newDate = new Date();
        comment.setDate(newDate);
        User user = userService.findById(userId).get();
        comment.setUser(user);
        return commentService.saveComment(comment);
    }
    @CrossOrigin()
    @GetMapping("comments/{idProd}")
    public List<Comment> showAll(@PathVariable("idProd") int idProd) {
        List<Comment> comments = commentService.findCommentByIdProd(idProd);
        return comments;
    }



    @GetMapping("comment/all")
    public List<Comment> findAllComments() {
        List<Comment> comments = commentService.findAllComments();
        comments.forEach((comment->{
            Optional<User> user = userService.findById(comment.getUser().getId());
            User usr = user.get();
            comment.setUser(usr); }));
         return comments;


    }

    @CrossOrigin
    @DeleteMapping("comment/{id}")
    public String deleteComment(@PathVariable int id) {

        if (commentService.deleteComment(id)) {
            return "{" + "The Comment has been deleted sucessfully" + "}";
        }

        return " An error has occured. ";
    }

    @GetMapping("comment/{id}")
    public Comment getComment(@PathVariable int id) {
        Comment comment = commentService.findComment(id);
        if (comment == null) {
            return null;		}
        return comment;

    }


    @PutMapping("comment/{id}")
    public Comment editComment(@PathVariable int id,@RequestBody Map<String, Object> commentMap) {

        Comment comment = commentService.findComment(id);
        comment.setComm((String) commentMap.get("comm"));
        comment.setRating((int) commentMap.get("rating"));
        commentService.saveComment(comment);
        return comment;

    }




}
