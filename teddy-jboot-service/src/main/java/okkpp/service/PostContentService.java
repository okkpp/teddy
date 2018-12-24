package okkpp.service;

import okkpp.common.result.Result;
import okkpp.dto.PostContentDTO;
import okkpp.model.PostContent;

public interface PostContentService extends BaseService<PostContent> {

	Result<PostContentDTO> getContentById(Long postId);
}