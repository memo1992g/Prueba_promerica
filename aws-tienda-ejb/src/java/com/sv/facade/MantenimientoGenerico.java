/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.facade;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author USER
 * @param <T>
 */
public abstract class MantenimientoGenerico<T> {
    private Class<T> entityClass;

		public MantenimientoGenerico(Class<T> entityClass) {
			this.entityClass = entityClass;
		}

		protected abstract EntityManager getEntityManager();

		public void create(T entity) {	
			EntityManager em = getEntityManager();
			EntityTransaction et = null;
			
			try {
				et = em.getTransaction();			
				et.begin();
				em.persist(entity);
				et.commit();
                                System.out.println("se proceso exitosamente");
			} catch (Exception e) {
				// TODO: handle exception 
			System.out.println("falla mantenimiento"+"---->"+e.getMessage()+" "+e.getLocalizedMessage());
			e.printStackTrace();
				if (et != null && et.isActive()) {
					et.rollback();
				}
			} finally {
				em.clear();
				
			}
		}
		
		public void batchCreate(List<T> entities) {
			EntityManager em = getEntityManager();
			EntityTransaction et = null;
			
			try {
				et = em.getTransaction();
				et.begin();
				
				for (T entity : entities) {
					em.persist(entity);
				}
				
				et.commit();			
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				if (et != null && et.isActive()) {
					et.rollback();
				}
			} finally {
				if (em != null && em.isOpen()) {
					em.close();
				}
			}
		}

		public void edit(T entity) {
			EntityManager em = getEntityManager();
			EntityTransaction et = null;
			
			try {
				et = em.getTransaction();	
				et.begin();
				em.merge(entity);
				et.commit();
			} catch (Exception e) {
				// TODO: handle exception 
				e.printStackTrace();
				if (et != null && et.isActive()) {
					et.rollback();
				}
			} 
		}
		
		
		public void batchEdit(List<T> entities) {
			EntityManager em = getEntityManager();
			EntityTransaction et = null;
			
			try {
				et = em.getTransaction();	
				et.begin();
				
				for (T entity : entities) {
					em.merge(entity);
				}
				
				et.commit();
			} catch (Exception e) {
				// TODO: handle exception 
				e.printStackTrace();
				if (et != null && et.isActive()) {
					et.rollback();
				}
			} 
		}

		public void remove(T entity) {
			EntityManager em = getEntityManager();
			EntityTransaction et = null;
			
			try {
				et = em.getTransaction();	
				et.begin();
				em.remove(em.merge(entity));
				et.commit();			
			} catch (Exception e) {
				// TODO: handle exception 
				e.printStackTrace();
				if (et != null && et.isActive()) {
					et.rollback();
				}
		 	
			}
		}
		
		public void bacthRemove(List<T> entities) {
                 EntityManager em = getEntityManager();
			EntityTransaction et = null;
			
			try {
				et = em.getTransaction();	
				et.begin();
				
				for (T entity : entities) {
					em.remove(em.merge(entity));
				}
				
				et.commit();			
			} catch (Exception e) {
				// TODO: handle exception 
				e.printStackTrace();
				if (et != null && et.isActive()) {
					et.rollback();
				}
			} finally {
				if (em != null && em.isOpen()) {
					em.close();	
				}		
			}
		}

		public T find(Object id) {
			return getEntityManager().find(entityClass, id);
		}

		public List<T> findAll() {
			CriteriaQuery<T> cq = getEntityManager().getCriteriaBuilder().createQuery(entityClass);
			cq.select(cq.from(entityClass));
			
			return getEntityManager().createQuery(cq).getResultList();
		}

		public List<T> findRange(int[] range) {
			CriteriaQuery<T> cq = getEntityManager().getCriteriaBuilder().createQuery(entityClass);
			cq.select(cq.from(entityClass));
			TypedQuery<T> q = getEntityManager().createQuery(cq);
			q.setMaxResults(range[1] - range[0]);
			q.setFirstResult(range[0]);
			
			return q.getResultList();
		}

		public int count() {
			CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
			CriteriaQuery<Long> cq = cb.createQuery(Long.class);
			Root<T> rt = cq.from(entityClass);
			cq.select(cb.count(rt));
			TypedQuery<Long> q = getEntityManager().createQuery(cq);
			
			return q.getSingleResult().intValue();
		}

}
