package okkpp.service.impl;

import io.jboot.aop.annotation.Bean;
import okkpp.service.RoleService;
import okkpp.common.result.PageInfo;
import okkpp.common.result.PagedResult;
import okkpp.common.sql.QueryHelper;
import okkpp.model.Role;
import io.jboot.service.JbootServiceBase;

import java.util.List;

import javax.inject.Singleton;

import org.springframework.stereotype.Service;

import com.jfinal.plugin.activerecord.Page;

@Service
@Bean
@Singleton
public class RoleServiceImpl extends JbootServiceBase<Role> implements RoleService {

	@Override
	public PagedResult<List<Role>> list(PageInfo pageinfo) {
		QueryHelper helper = new QueryHelper(Role.table);
		helper.build();
		Page<Role> paginate = DAO.paginate(pageinfo.getPageNo(), pageinfo.getPageSize(), helper.getSelect(), helper.getSqlExceptSelect(), helper.getParams());
		return new PagedResult<List<Role>>(paginate.getList(), paginate);
	}
}