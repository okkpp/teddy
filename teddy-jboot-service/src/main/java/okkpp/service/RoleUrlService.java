package okkpp.service;

import okkpp.model.RoleUrl;

import java.util.List;

public interface RoleUrlService extends BaseService<RoleUrl> {

	List<String> getPublicRole();
}