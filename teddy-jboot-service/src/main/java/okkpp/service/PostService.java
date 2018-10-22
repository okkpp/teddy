package okkpp.service;

import okkpp.vo.PostVO;
import okkpp.model.Post;

import java.util.List;

public interface PostService  {

	public boolean postArticle(PostVO post, String content);
	
	public boolean postTrends(PostVO post);
    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public Post findById(Object id);


    /**
     * find all model
     *
     * @return all <Post
     */
    public List<Post> findAll();


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
    public boolean delete(Post model);


    /**
     * save model to database
     *
     * @param model
     * @return
     */
    public boolean save(Post model);


    /**
     * save or update model
     *
     * @param model
     * @return if save or update success
     */
    public boolean saveOrUpdate(Post model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(Post model);


}