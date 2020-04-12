package com.gcu.data;

import java.util.List;


public interface DataAccessInterface<T> {

	/**
	 * This method is used to add an Object to the database.
	 * 
	 * @param t - Object that is going to be added to the database
	 * @param ID - Used for adding to another table
	 * @return integer
	 */
    public int create(T t, int ID);
    
    /**
     * This method is used to update the information of an Object in the database.
     * 
     * @param t - Object with the features that are going to be updated
     * @param id - ID of the model that is going to be updated
     * @return integer
     */
    public int update(T t, int id);
    
    /**
     * This method will delete the object from the database given its ID.
     * 
     * @param id - ID of the element that wants to be deleted from the database
     * @return integer
     */
    public int delete(int id);
    
    /**
     * This method will return a List of Objects to the BusinessService.
     * 
     * @return List - List of all objects
     */
    public List<T> viewAll();
    
    /**
     * This method will return an Object to the BusinessService given its ID
     * 
     * @param id - ID of the Object
     * @return T - Returns the Object based on the ID sent
     */
    public T viewById(int id);
    
    /**
     * This method will return a list of objects that are connected to the ParentID.
     * 
     * @param parentId - ID of the Parent
     * @return List - List of Objects based on parent ID
     */
    public List<T> viewByParentId(int parentId);
    
    /**
     * This method will return the object by sending the object (Method used to grab object ID from the database)
     * 
     * @param t - Object that needs to be searched. 
     * @return T - Object
     */
    public T viewByObject(T t);
    
}