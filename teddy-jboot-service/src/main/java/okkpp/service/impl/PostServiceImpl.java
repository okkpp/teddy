package okkpp.service.impl;

import io.jboot.aop.annotation.Bean;
import okkpp.service.PostService;
import okkpp.vo.PostVO;
import okkpp.common.result.PageInfo;
import okkpp.common.result.PagedResult;
import okkpp.common.sql.QueryHelper;
import okkpp.dto.PostDTO;
import okkpp.model.Post;
import okkpp.model.PostContent;
import io.jboot.service.JbootServiceBase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Singleton;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.tx.Tx;

@Service
@Bean
@Singleton
public class PostServiceImpl extends JbootServiceBase<Post> implements PostService {

	@Override
	public PostDTO postTrends(PostVO post) {
		Post model = new Post();
		BeanUtils.copyProperties(post, model);
		model.setCreated(new Date());
		model.setEnable(1);
		if(model.save()) {
			PostDTO result = new PostDTO();
			BeanUtils.copyProperties(model, result);
			return result;
		}
		return null;
	}

	@Override
	@Before(Tx.class)
	public PostDTO postArticle(PostVO post, String content) {
		Post model = new Post();
		BeanUtils.copyProperties(post, model);
		model.setCreated(new Date());
		model.setEnable(1);
		if(model.save()) {
			PostContent postContent = new PostContent();
			postContent.setPostId(model.getId());
			postContent.setContent(content);
			postContent.setCreated(new Date());
			postContent.setEnable(1);
			if(postContent.save()) {
				PostDTO result = new PostDTO();
				BeanUtils.copyProperties(model, result);
				return result;
			}
		}
		return null;
	}

	@Override
	public PagedResult<List<PostDTO>> getPost(PageInfo pageinfo, PostVO condition) {
		QueryHelper sql = new QueryHelper("select * ", " from t_post ");
		sql.addWhere("author_id", condition.getAuthorId())
			.addWhere("channel_id", condition.getChannelId())
			.addWhereLike("title", condition.getTitle())
			.addWhereLike("summary", condition.getSummary())
			.addWhereLike("tags", condition.getTags())
			.build();
		Page<Post> paginate = DAO.paginate(pageinfo.getPageNo(), pageinfo.getPageSize(),
				sql.getSelect(),
				sql.getSqlExceptSelect(),
				sql.getParams());
		List<PostDTO> data = new ArrayList<>();
		for(Post source : paginate.getList()) {
			PostDTO target = new PostDTO();
			BeanUtils.copyProperties(source, target);
			data.add(target);
		}
		return new PagedResult<>(data, paginate.getPageNumber(), paginate.getPageSize(), paginate.getTotalPage());
	}

}