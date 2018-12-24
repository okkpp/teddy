package okkpp.service;

import okkpp.common.result.PageInfo;
import okkpp.common.result.PagedResult;
import okkpp.dto.PostDTO;
import okkpp.model.Post;
import okkpp.vo.PostVO;

import java.util.List;

public interface PostService extends BaseService<Post> {

	PostDTO postTrends(PostVO post);

	PostDTO postArticle(PostVO post, String content);

	PagedResult<List<PostDTO>> getPost(PageInfo pageinfo, PostVO condition);
}