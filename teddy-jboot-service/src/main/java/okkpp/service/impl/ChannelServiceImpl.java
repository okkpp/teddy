package okkpp.service.impl;

import io.jboot.aop.annotation.Bean;
import okkpp.service.ChannelService;
import okkpp.common.result.PageInfo;
import okkpp.common.result.PagedResult;
import okkpp.common.sql.QueryHelper;
import okkpp.model.Channel;
import io.jboot.service.JbootServiceBase;

import java.util.List;

import javax.inject.Singleton;

import org.springframework.stereotype.Service;

import com.jfinal.plugin.activerecord.Page;

@Service
@Bean
@Singleton
public class ChannelServiceImpl extends JbootServiceBase<Channel> implements ChannelService {

	@Override
	public PagedResult<List<Channel>> list(PageInfo pageinfo) {
		QueryHelper helper = new QueryHelper(Channel.table);
		helper.build();
		Page<Channel> paginate = DAO.paginate(pageinfo.getPageNo(), pageinfo.getPageSize(), helper.getSelect(), helper.getSqlExceptSelect(), helper.getParams());
		return new PagedResult<List<Channel>>(paginate.getList(), paginate);
	}
}