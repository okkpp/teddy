package okkpp.service.impl;

import io.jboot.Jboot;
import io.jboot.aop.annotation.Bean;
import okkpp.service.RoleUrlService;
import okkpp.common.result.PageInfo;
import okkpp.common.result.PagedResult;
import okkpp.common.sql.QueryHelper;
import okkpp.config.PublicRoleConfig;
import okkpp.model.RoleUrl;
import io.jboot.service.JbootServiceBase;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;

@Service
@Bean
@Singleton
public class RoleUrlServiceImpl extends JbootServiceBase<RoleUrl> implements RoleUrlService {

	@Override
	@Cacheable("data")
	public List<String> getPublicRole() {
		PublicRoleConfig config = Jboot.config(PublicRoleConfig.class);
		List<Record> list = Db.find("select t_role_url.role_id,t_url.url from t_role_url left join t_url "
				+ "on t_role_url.url_id = t_url.id "
				+ "where t_role_url.`enable` = t_url.`enable` and t_role_url.`enable` = 1 "
				+ "and t_role_url.role_id = ? ",
				config.getId());
		List<String> result = new ArrayList<>();
		for(Record r : list) {
			result.add(r.getStr("url"));
		}
		return result;
	}

	@Override
	public PagedResult<List<RoleUrl>> list(PageInfo pageinfo) {
		QueryHelper helper = new QueryHelper(RoleUrl.table);
		helper.build();
		Page<RoleUrl> paginate = DAO.paginate(pageinfo.getPageNo(), pageinfo.getPageSize(), helper.getSelect(), helper.getSqlExceptSelect(), helper.getParams());
		return new PagedResult<List<RoleUrl>>(paginate.getList(), paginate);
	}

}