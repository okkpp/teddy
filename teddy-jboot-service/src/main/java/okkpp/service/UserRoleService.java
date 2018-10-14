package okkpp.service;

import okkpp.model.UserRole;

import java.util.List;

public interface UserRoleService  {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public UserRole findById(Object id);


    /**
     * find all model
     *
     * @return all <UserRole
     */
    public List<UserRole> findAll();


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
    public boolean delete(UserRole model);


    /**
     * save model to database
     *
     * @param model
     * @return
     */
    public boolean save(UserRole model);


    /**
     * save or update model
     *
     * @param model
     * @return if save or update success
     */
    public boolean saveOrUpdate(UserRole model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(UserRole model);


}