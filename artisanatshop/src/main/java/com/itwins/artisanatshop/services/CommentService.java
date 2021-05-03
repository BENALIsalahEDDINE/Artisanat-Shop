package com.itwins.artisanatshop.services;

import com.itwins.artisanatshop.models.Comment;
import com.itwins.artisanatshop.repository.CommentRepository;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional

public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment saveComment(Comment comment)
    {   commentRepository.save(comment);
        return comment;  }

    public List<Comment> findAllComments() {
        return (List<Comment>) commentRepository.findAll();   }

    public Comment findById(int id) {
        return (Comment) commentRepository.findById(id);   }


    public boolean deleteComment(int id) {
        try {
            commentRepository.deleteById(id);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public Comment findComment(int id) {
        return commentRepository.findById(id);
    }

    public void updateComment(Comment comment) {
        deleteComment(comment.getId());
        commentRepository.save(comment);  }


    public List<Comment> findCommentByIdProd(int idProd) {
        return commentRepository.findCommentByIdProd(idProd);
    }


}

