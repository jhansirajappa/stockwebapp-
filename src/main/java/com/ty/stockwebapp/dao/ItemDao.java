package com.ty.stockwebapp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.stockwebapp.dto.Item;

public class ItemDao {
	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;
	EntityTransaction entityTransaction;

	public EntityManager getEntityManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		return entityManagerFactory.createEntityManager();
	}
	public void addItem(Item item) {
		entityManager=getEntityManager();
		entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(item);
		entityTransaction.commit();
	}
	public void deleteItem(int id) {
		entityManager=getEntityManager();
		entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		Item item=entityManager.find(Item.class, id);
		if(item != null) {
		entityManager.remove(item);
		entityTransaction.commit();
		return;
		}
		entityTransaction.commit();
		
	}
	public List<Item> getAllItems(){
		entityManager=getEntityManager();
		entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		Query query=entityManager.createQuery("select i from Item i");
		List<Item> items=query.getResultList();
	    entityTransaction.commit();
	    return items;
	}
	public List<Item> getAllItemsBySearch(String search){
		entityManager=getEntityManager();
		entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		Query query=entityManager.createQuery("select i from Item i where  i.name like ?1");
		query.setParameter(1, search);
		List<Item> items=query.getResultList();
		return items;
	} 
	public List<Item> getAllItemsByType(String search,String type){
		entityManager=getEntityManager();
		entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		Query query=entityManager.createQuery("select i from Item i where i.name like ?1 and i.type like ?2");
		 query.setParameter(1, search);
		 query.setParameter(2, type);
		List<Item> items=query.getResultList();
		return items;
	}
	public List<Item> getAllItemsByType(String type){
		entityManager=getEntityManager();
		entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		Query query=entityManager.createQuery("from Item i where i.type LIKE ?1");
		query.setParameter(1, type);
		List<Item> items=query.getResultList();
		return items;
	} 
	public Item getItemById(int id) {
		entityManager=getEntityManager();
		entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		Item item= entityManager.find(Item.class, id);
		entityTransaction.commit();
		return item;
	}
	public void updateItem(Item item) {
		entityManager=getEntityManager();
		entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(item);
		entityTransaction.commit();
	}
}
