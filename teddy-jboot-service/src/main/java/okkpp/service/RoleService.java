package okkpp.service;

import okkpp.common.result.PageInfo;
import okkpp.common.result.PagedResult;
import okkpp.model.Role;

import java.util.List;

public interface RoleService  {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public Role findById(Object id);


    /**
     * find all model
     *
     * @return all <Role
     */
    public List<Role> findAll();


    /**
     * delete model by primary key
     *
     * @param id
     * @return success
     */
    public boolean deleteById(Object id);


    /**
     * delete model
     *
     * @param model
     * @return
     */
    public boolean delete(Role model);


    /**
     * save model to database
     *
     * @param model
     * @return
     */
    public boolean save(Role model);


    /**
     * save or update model
     *
     * @param model
     * @return if save or update success
     */
    public boolean saveOrUpdate(Role model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(Role model);

	PagedResult<List<Role>> list(PageInfo pageinfo, String tableName);
}