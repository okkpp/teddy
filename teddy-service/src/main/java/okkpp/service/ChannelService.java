package okkpp.service;

import okkpp.model.Channel;

import java.util.List;

public interface ChannelService  {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public Channel findById(Object id);


    /**
     * find all model
     *
     * @return all <Channel
     */
    public List<Channel> findAll();


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
    public boolean delete(Channel model);


    /**
     * save model to database
     *
     * @param model
     * @return
     */
    public boolean save(Channel model);


    /**
     * save or update model
     *
     * @param model
     * @return if save or update success
     */
    public boolean saveOrUpdate(Channel model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(Channel model);


}