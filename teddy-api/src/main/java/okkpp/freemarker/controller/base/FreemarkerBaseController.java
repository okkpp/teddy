package okkpp.freemarker.controller.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.jboot.db.model.JbootModel;
import okkpp.common.base.BaseController;
import okkpp.common.result.PageInfo;
import okkpp.common.result.PagedResult;
import okkpp.common.result.Result;
import okkpp.service.BaseService;

public abstract class FreemarkerBaseController<M extends JbootModel<M>> extends BaseController {

	@Autowired
	private BaseService<M> baseService;
	
	@GetMapping("list")
	@ResponseBody
	public PagedResult<List<M>> list(PageInfo pageinfo) {
		return baseService.list(pageinfo);
	}
	
	@PostMapping("save")
	@ResponseBody
	public Result<String> save(M model) {
		System.out.println(model.toJson());
		return Result.judge(baseService.saveOrUpdate(model));
	}
	
	@PostMapping("del")
	@ResponseBody
	public Result<String> del(Integer id) {
		return Result.judge(baseService.deleteById(id));
	}
}
