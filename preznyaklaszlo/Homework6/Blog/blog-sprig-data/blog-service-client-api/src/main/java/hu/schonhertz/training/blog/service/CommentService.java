package hu.schonhertz.training.blog.service;

import hu.schonhertz.training.blog.vo.CommentVo;

public interface CommentService {

	public void addComment(CommentVo commentVo, Long blogId);
}
