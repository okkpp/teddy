package okkpp.service;

import okkpp.common.result.PageInfo;
import okkpp.common.result.PagedResult;
import okkpp.model.PostFavor;

import java.util.List;

public interface PostFavorService  {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public PostFavor findById(Object id);


    /**
     * find all model
     *
     * @return all <PostFavor
     */
    public List<PostFavor> findAll();


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
    public boolean delete(PostFavor model);


    /**
     * save model to database
     *
     * @param model
     * @return
     */
    public boolean save(PostFavor model);


    /**
     * save or update model
     *
     * @param model
     * @return if save or update success
     */
    public boolean saveOrUpdate(PostFavor model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(PostFavor model);

	PagedResult<List<PostFavor>> list(PageInfo pageinfo, String tableName);
}