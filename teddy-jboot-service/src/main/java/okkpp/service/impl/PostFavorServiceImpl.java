package okkpp.service.impl;

import io.jboot.aop.annotation.Bean;
import okkpp.service.PostFavorService;
import okkpp.common.result.PageInfo;
import okkpp.common.result.PagedResult;
import okkpp.common.sql.QueryHelper;
import okkpp.model.PostFavor;
import io.jboot.service.JbootServiceBase;

import java.util.List;

import javax.inject.Singleton;

import org.springframework.stereotype.Service;

import com.jfinal.plugin.activerecord.Page;

@Service
@Bean
@Singleton
public class PostFavorServiceImpl extends JbootServiceBase<PostFavor> implements PostFavorService {

	@Override
	public PagedResult<List<PostFavor>> list(PageInfo pageinfo) {
		QueryHelper helper = new QueryHelper(PostFavor.table);
		helper.build();
		Page<PostFavor> paginate = DAO.paginate(pageinfo.getPageNo(), pageinfo.getPageSize(), helper.getSelect(), helper.getSqlExceptSelect(), helper.getParams());
		return new PagedResult<List<PostFavor>>(paginate.getList(), paginate);
	}
}