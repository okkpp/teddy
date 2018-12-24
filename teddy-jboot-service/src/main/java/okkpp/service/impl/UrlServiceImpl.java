package okkpp.service.impl;

import io.jboot.aop.annotation.Bean;
import okkpp.service.UrlService;
import okkpp.common.result.PageInfo;
import okkpp.common.result.PagedResult;
import okkpp.common.sql.QueryHelper;
import okkpp.model.Url;
import io.jboot.service.JbootServiceBase;

import java.util.List;

import javax.inject.Singleton;

import org.springframework.stereotype.Service;

import com.jfinal.plugin.activerecord.Page;

@Service
@Bean
@Singleton
public class UrlServiceImpl extends JbootServiceBase<Url> implements UrlService {

	@Override
	public PagedResult<List<Url>> list(PageInfo pageinfo) {
		QueryHelper helper = new QueryHelper(Url.table);
		helper.build();
		Page<Url> paginate = DAO.paginate(pageinfo.getPageNo(), pageinfo.getPageSize(), helper.getSelect(), helper.getSqlExceptSelect(), helper.getParams());
		return new PagedResult<List<Url>>(paginate.getList(), paginate);
	}
}