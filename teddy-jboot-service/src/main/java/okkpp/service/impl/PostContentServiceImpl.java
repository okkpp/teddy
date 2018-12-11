package okkpp.service.impl;

import io.jboot.aop.annotation.Bean;
import okkpp.service.PostContentService;
import okkpp.common.result.Result;
import okkpp.dto.PostContentDTO;
import okkpp.model.PostContent;
import io.jboot.service.JbootServiceBase;

import javax.inject.Singleton;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
@Bean
@Singleton
public class PostContentServiceImpl extends JbootServiceBase<PostContent> implements PostContentService {

	@Override
	public Result<PostContentDTO> getContentById(Long postId){
		PostContent result = DAO.findFirst("select * from t_post_content where post_id = ?", postId);
		Assert.notNull(result, "未找到内容。");
		PostContentDTO data = new PostContentDTO();
		BeanUtils.copyProperties(result, data);
		return new Result<PostContentDTO>(data);
	}
	
}