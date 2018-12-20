package okkpp.service;

import okkpp.common.result.PageInfo;
import okkpp.common.result.PagedResult;
import okkpp.model.User;

import java.util.List;

public interface UserService  {

	public List<String> findUserUrl(Long userId);
	public List<String> findUserUrl(String username);
	
	public User getUserByName(String username);
	
    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public User findById(Object id);


    /**
     * find all model
     *
     * @return all <User
     */
    public List<User> findAll();


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
    public boolean delete(User model);


    /**
     * save model to database
     *
     * @param model
     * @return
     */
    public boolean save(User model);


    /**
     * save or update model
     *
     * @param model
     * @return if save or update success
     */
    public boolean saveOrUpdate(User model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(User model);
    PagedResult<List<User>> list(PageInfo pageinfo);


}