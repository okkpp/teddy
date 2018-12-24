package okkpp.service.impl;

import io.jboot.aop.annotation.Bean;
import okkpp.service.UserRoleService;
import okkpp.common.result.PageInfo;
import okkpp.common.result.PagedResult;
import okkpp.common.sql.QueryHelper;
import okkpp.model.UserRole;
import io.jboot.service.JbootServiceBase;

import java.util.List;

import javax.inject.Singleton;

import org.springframework.stereotype.Service;

import com.jfinal.plugin.activerecord.Page;

@Service
@Bean
@Singleton
public class UserRoleServiceImpl extends JbootServiceBase<UserRole> implements UserRoleService {

	@Override
	public PagedResult<List<UserRole>> list(PageInfo pageinfo) {
		QueryHelper helper = new QueryHelper(UserRole.table);
		helper.build();
		Page<UserRole> paginate = DAO.paginate(pageinfo.getPageNo(), pageinfo.getPageSize(), helper.getSelect(), helper.getSqlExceptSelect(), helper.getParams());
		return new PagedResult<List<UserRole>>(paginate.getList(), paginate);
	}
}