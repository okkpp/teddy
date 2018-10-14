package okkpp.service;

import okkpp.model.RoleUrl;

import java.util.List;

public interface RoleUrlService  {

	public List<String> getPublicRole();
	
    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public RoleUrl findById(Object id);


    /**
     * find all model
     *
     * @return all <RoleUrl
     */
    public List<RoleUrl> findAll();


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
    public boolean delete(RoleUrl model);


    /**
     * save model to database
     *
     * @param model
     * @return
     */
    public boolean save(RoleUrl model);


    /**
     * save or update model
     *
     * @param model
     * @return if save or update success
     */
    public boolean saveOrUpdate(RoleUrl model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(RoleUrl model);


}