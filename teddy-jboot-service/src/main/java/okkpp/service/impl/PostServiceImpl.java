package okkpp.service.impl;

import io.jboot.aop.annotation.Bean;
import okkpp.service.PostService;
import okkpp.vo.PostVO;
import okkpp.model.Post;
import io.jboot.service.JbootServiceBase;

import java.util.Date;

import javax.inject.Singleton;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@Bean
@Singleton
public class PostServiceImpl extends JbootServiceBase<Post> implements PostService {

	@Override
	public boolean postTrends(PostVO post) {
		Post model = new Post();
		BeanUtils.copyProperties(post, model);
		model.setCreated(new Date());
		model.setEnable(1);
		boolean result = model.save();
		if(result) {
			System.out.println(model.toJson());
		}
		return result;
	}

	@Override
	public boolean postArticle(PostVO post, String content) {
		// TODO Auto-generated method stub
		return false;
	}

}