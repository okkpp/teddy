package okkpp.service;

import okkpp.model.Wallet;

import java.util.List;

public interface WalletService  {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public Wallet findById(Object id);


    /**
     * find all model
     *
     * @return all <Wallet
     */
    public List<Wallet> findAll();


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
    public boolean delete(Wallet model);


    /**
     * save model to database
     *
     * @param model
     * @return
     */
    public boolean save(Wallet model);


    /**
     * save or update model
     *
     * @param model
     * @return if save or update success
     */
    public boolean saveOrUpdate(Wallet model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(Wallet model);


}