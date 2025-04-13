package com.movieapp.dahp_ccptpm_be.mapper;

import com.movieapp.dahp_ccptpm_be.dto.CommentDTO;
import com.movieapp.dahp_ccptpm_be.model.entity.Comment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    CommentDTO toCommentDto(Comment comment);
    Comment toComment(CommentDTO commentDTO);
}
