package com.ssoysal.letMeIn.dataAccess;

import java.util.List;

import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ssoysal.letMeIn.entities.Login;

@Repository
public class HibernateLoginDal implements ILoginDal{

	private EntityManager entityManager;

	@Autowired
	public HibernateLoginDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public List<Login> getAll() {
		Session session = entityManager.unwrap(Session.class);
		List<Login> logins = session.createQuery("from Login", Login.class).getResultList();
		return logins;
	}

	@Override
	@Transactional
	public void add(Login login) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(login);
	}

	@Override
	@Transactional
	public void update(Login login) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(login);
	}

	@Override
	@Transactional
	public void delete(Login login) {
		Session session = entityManager.unwrap(Session.class);
		Login loginToDelete = (Login) session.load(Login.class, login.getId());
		session.delete(loginToDelete);
		session.flush();
	}
}
