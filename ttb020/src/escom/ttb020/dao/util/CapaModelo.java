package escom.ttb020.dao.util;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.criterion.Example;

import com.opensymphony.xwork2.inject.Scope;
import com.opensymphony.xwork2.inject.Scoped;

@Scoped(Scope.SINGLETON)
public class CapaModelo {

	/**
	 * 
	 */
	protected EntityManagerFactory factory = Persistence.createEntityManagerFactory("tt");;

	/**
	 * Proporciona acceso a la implementación del EntityManager de JPA
	 */
	protected EntityManager entityManager = factory.createEntityManager();

	public <C> C findById(Class<C> clazz, Serializable id) {
		entityManager.clear();
		return entityManager.find(clazz, id);
	}
	
	public <C> List<C> findAll(Class<C> clazz) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<C> criteria = builder.createQuery(clazz);
		criteria.from(clazz);
		return entityManager.createQuery(criteria).getResultList();
	}

	public <C> List<C> findByExample(C example) {
		Session session = entityManager.unwrap(Session.class);
		List<C> listReturn = (List<C>) session.createCriteria(example.getClass()).add(Example.create(example)).list();
		return listReturn;
	}


	public <C> C save(C entity) {
		Session session = entityManager.unwrap(Session.class);
		session.getTransaction().begin();
		session.saveOrUpdate(entity);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return entity;
	}

	public <C> C update(C entity) {
		Session session = entityManager.unwrap(Session.class);
		entityManager.clear();
		session.getTransaction().begin();
		session.update(entity);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return entity;
	}

	public CapaModelo() {
		super();
	}
}
