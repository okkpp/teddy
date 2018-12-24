package okkpp.service;

import java.util.List;

import io.jboot.db.model.JbootModel;
import okkpp.common.result.PageInfo;
import okkpp.common.result.PagedResult;

public interface BaseService<M extends JbootModel<M>> {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public M findById(Object id);


    /**
     * find all model
     *
     * @return all <Base
     */
    public List<M> findAll();


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
    public boolean delete(M model);


    /**
     * save model to database
     *
     * @param model
     * @return
     */
    public boolean save(M model);


    /**
     * save or update model
     *
     * @param model
     * @return if save or update success
     */
    public boolean saveOrUpdate(M model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(M model);

    PagedResult<List<M>> list(PageInfo pageinfo);
}