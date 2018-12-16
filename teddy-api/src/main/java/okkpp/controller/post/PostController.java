package okkpp.controller.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import okkpp.common.base.BaseController;
import okkpp.common.result.PageInfo;
import okkpp.common.result.PagedResult;
import okkpp.common.result.Result;
import okkpp.dto.PostContentDTO;
import okkpp.dto.PostDTO;
import okkpp.model.User;
import okkpp.vo.PostVO;
import okkpp.service.PostContentService;
import okkpp.service.PostService;

@Api(description = "推送管理")
@RequestMapping("post")
@RestController
public class PostController extends BaseController {

	@Autowired
	private PostService postService;
	@Autowired
	private PostContentService postContentService;
	
	@ApiOperation("推送简短消息-不带文章内容")
	@PostMapping("postTrends")
	public Result<PostDTO> postTrends(PostVO post) {
		User user = getSubject();
		post.setAuthorId(user.getId());
		return resultData(postService.postTrends(post));
	}
	
	@ApiOperation("推送文章内容")
	@PostMapping("postArticle")
	public Result<PostDTO> postArticle(PostVO post, String content) {
		User user = getSubject();
		post.setAuthorId(user.getId());
		return resultData(postService.postArticle(post, content));
	}
	
	@ApiOperation("获取推送")
	@PostMapping("getPost")
	public PagedResult<List<PostDTO>> getPost(PageInfo pageinfo, PostVO condition) {
		return postService.getPost(pageinfo, condition);
	}
	
	@ApiOperation("获取文章内容")
	@PostMapping("getContent")
	public Result<PostContentDTO> getContent(Long postId) {
		return postContentService.getContentById(postId);
	}
}
