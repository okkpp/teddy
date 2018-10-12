package okkpp.service;

import okkpp.model.Base;

import java.util.List;

public interface BaseService  {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public Base findById(Object id);


    /**
     * find all model
     *
     * @return all <Base
     */
    public List<Base> findAll();


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
    public boolean delete(Base model);


    /**
     * save model to database
     *
     * @param model
     * @return
     */
    public boolean save(Base model);


    /**
     * save or update model
     *
     * @param model
     * @return if save or update success
     */
    public boolean saveOrUpdate(Base model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(Base model);


}