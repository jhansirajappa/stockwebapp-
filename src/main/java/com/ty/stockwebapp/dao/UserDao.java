package com.ty.stockwebapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.stockwebapp.dto.User;

public class UserDao {
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    EntityTransaction entityTransaction;
    public EntityManager getEntityManager() {
    	entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
    	return entityManagerFactory.createEntityManager();
    }
     public void addUser(User user) {
    	 entityManager=getEntityManager();
    	 entityTransaction=entityManager.getTransaction();
    	 entityTransaction.begin();
    	 entityManager.persist(user);
    	entityTransaction.commit();
     }
     public User getUser(String mail,String password) {
    	 entityManager=getEntityManager();
    	 entityTransaction=entityManager.getTransaction();
    	 entityTransaction.begin();
    	 Query query=entityManager.createQuery("select u from User u");
    	
    	 for(User user: (List<User>)query.getResultList()) {
    		 if(user.getMail().equals(mail) && user.getPassword().equals(password)) {
    			 entityTransaction.commit();
    			 return user;
    		 }
    	 }
    	 entityTransaction.commit();
    	 return null;
    	 
     }
}
