package okkpp.post.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import okkpp.common.base.BaseController;
import okkpp.common.result.PageInfo;
import okkpp.common.result.Result;
import okkpp.dto.PostContentDTO;
import okkpp.dto.PostDTO;

@Api(description = "推送管理")
@RequestMapping("post")
@RestController
public class PostController extends BaseController {

	@ApiOperation("推送简短消息-不带文章内容")
	@PostMapping("postTrends")
	public Result<String> postTrends(PostDTO post) {
		
		return successMsg("推送成功！");
	}
	
	@ApiOperation("推送文章内容")
	@PostMapping("postArticle")
	public Result<String> postArticle(PostDTO post, String content) {
		
		return successMsg("推送成功！");
	}
	
	@ApiOperation("获取推送")
	@PostMapping("getPost")
	public Result<List<PostDTO>> getPost(PageInfo pageinfo) {
		Result<List<PostDTO>> result = new Result<>();
		
		return result;
	}
	
	@ApiOperation("获取文章内容")
	@PostMapping("getContent")
	public Result<PostContentDTO> getContent(Long postId) {
		Result<PostContentDTO> result = new Result<>();
		
		return result;
	}
}
