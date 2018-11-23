package okkpp.post.controller;

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
import okkpp.vo.PostVO;
import okkpp.service.PostService;

@Api(description = "推送管理")
@RequestMapping("post")
@RestController
public class PostController extends BaseController {

	@Autowired
	private PostService postService;
	
	@ApiOperation("推送简短消息-不带文章内容")
	@PostMapping("postTrends")
	public Result<PostDTO> postTrends(PostVO post) {
		return resultData(postService.postTrends(post));
	}
	
	@ApiOperation("推送文章内容")
	@PostMapping("postArticle")
	public Result<PostDTO> postArticle(PostVO post, String content) {
		return resultData(postService.postArticle(post, content));
	}
	
	@ApiOperation("获取推送")
	@PostMapping("getPost")
	public PagedResult<List<PostDTO>> getPost(PageInfo pageinfo, PostVO condition) {
		PagedResult<List<PostDTO>> result = new PagedResult<List<PostDTO>>(null);
		
		return result;
	}
	
	@ApiOperation("获取文章内容")
	@PostMapping("getContent")
	public Result<PostContentDTO> getContent(Long postId) {
		Result<PostContentDTO> result = new Result<>(null);
		
		return result;
	}
}
