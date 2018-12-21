package okkpp.service;

import java.util.List;

import com.jfinal.plugin.activerecord.Page;

import io.jboot.db.model.JbootModel;
import io.jboot.service.JbootServiceBase;
import okkpp.common.result.PageInfo;
import okkpp.common.result.PagedResult;
import okkpp.common.sql.QueryHelper;

public class TeddyServiceBase<M extends JbootModel<M>> extends JbootServiceBase<M> {

	public PagedResult<List<M>> list(PageInfo pageinfo, String tableName) {
		QueryHelper helper = new QueryHelper(tableName);
		helper.build();
		Page<M> paginate = DAO.paginate(pageinfo.getPageNo(), pageinfo.getPageSize(), helper.getSelect(), helper.getSqlExceptSelect(), helper.getParams());
		return new PagedResult<List<M>>(paginate.getList(), paginate);
	}
}
