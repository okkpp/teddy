package okkpp.service.impl;

import io.jboot.aop.annotation.Bean;
import okkpp.service.WalletService;
import okkpp.common.result.PageInfo;
import okkpp.common.result.PagedResult;
import okkpp.common.sql.QueryHelper;
import okkpp.model.Wallet;
import io.jboot.service.JbootServiceBase;

import java.util.List;

import javax.inject.Singleton;

import org.springframework.stereotype.Service;

import com.jfinal.plugin.activerecord.Page;

@Service
@Bean
@Singleton
public class WalletServiceImpl extends JbootServiceBase<Wallet> implements WalletService {

	@Override
	public PagedResult<List<Wallet>> list(PageInfo pageinfo) {
		QueryHelper helper = new QueryHelper(Wallet.table);
		helper.build();
		Page<Wallet> paginate = DAO.paginate(pageinfo.getPageNo(), pageinfo.getPageSize(), helper.getSelect(), helper.getSqlExceptSelect(), helper.getParams());
		return new PagedResult<List<Wallet>>(paginate.getList(), paginate);
	}
}