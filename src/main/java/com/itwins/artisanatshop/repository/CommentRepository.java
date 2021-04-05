package com.itwins.artisanatshop.repository;import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.itwins.artisanatshop.models.Comment;

import java.util.List;

;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {

    Comment findById(int id);
    List<Comment> findCommentByIdProd(int idProd);


}
