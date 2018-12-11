package okkpp.service;

import okkpp.common.result.Result;
import okkpp.dto.PostContentDTO;
import okkpp.model.PostContent;

import java.util.List;

public interface PostContentService  {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public PostContent findById(Object id);


    /**
     * find all model
     *
     * @return all <PostContent
     */
    public List<PostContent> findAll();


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
    public boolean delete(PostContent model);


    /**
     * save model to database
     *
     * @param model
     * @return
     */
    public boolean save(PostContent model);


    /**
     * save or update model
     *
     * @param model
     * @return if save or update success
     */
    public boolean saveOrUpdate(PostContent model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(PostContent model);


	Result<PostContentDTO> getContentById(Long postId);


}