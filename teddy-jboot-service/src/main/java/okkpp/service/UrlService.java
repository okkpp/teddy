package okkpp.service;

import okkpp.model.Url;

import java.util.List;

public interface UrlService  {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public Url findById(Object id);


    /**
     * find all model
     *
     * @return all <Url
     */
    public List<Url> findAll();


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
    public boolean delete(Url model);


    /**
     * save model to database
     *
     * @param model
     * @return
     */
    public boolean save(Url model);


    /**
     * save or update model
     *
     * @param model
     * @return if save or update success
     */
    public boolean saveOrUpdate(Url model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(Url model);


}