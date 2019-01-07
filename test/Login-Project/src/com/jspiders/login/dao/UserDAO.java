package com.jspiders.login.dao;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Repository;

import com.jspiders.login.dto.UserDTO;
import com.jspiders.login.service.UserService;

@Repository
public class UserDAO implements Serializable {

	@Autowired
	private SessionFactory factory;

	@Autowired
	private UserService service;

	public long saveUser(UserDTO userDTO) {
		Session session = null;
		long id = 0;
		try {
			session = factory.openSession();
			session.beginTransaction();
			id = (long) session.save(userDTO);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return id;
	}

	public UserDTO findByEmail(String email) {
		String qry = "SELECT user FROM UserDTO user WHERE user.eMail=:uEmail";
		UserDTO userDTO = null;
		try (Session session = factory.openSession();) {
			Query query = session.createQuery(qry);
			query.setParameter("uEmail", email);
			userDTO = (UserDTO) query.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return userDTO;
	}

	public UserDTO findByName(String name) {
		String qry = "SELECT user FROM UserDTO user WHERE user.name=:uName";
		UserDTO userDTO = null;
		try (Session session = factory.openSession();) {
			Query query = session.createQuery(qry);
			query.setParameter("uName", name);
			userDTO = (UserDTO) query.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return userDTO;
	}

	public UserDTO findByMobile(String mobileNumber) {
		String qry = "SELECT user FROM UserDTO user WHERE user.mobileNumber=:uMobileNum";
		UserDTO userDTO = null;
		try (Session session = factory.openSession();) {
			Query query = session.createQuery(qry);
			query.setParameter("uMobileNum", mobileNumber);
			userDTO = (UserDTO) query.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return userDTO;
	}

	public Integer updateProfile(String name, String mobileNumber, String email, String password) {
		Integer identifier = null;
		Session session = null;
		String qry = "UPDATE UserDTO user SET user.name=:uName,user.mobileNumber=:uMobileNumber WHERE user.eMail=:uEmail AND user.password=:uPwd";
		try {
			session = factory.openSession();
			session.beginTransaction();
			Query query = session.createQuery(qry);
			query.setParameter("uName", name);
			query.setParameter("uMobileNumber", mobileNumber);
			query.setParameter("uEmail", email);
			query.setParameter("uPwd", password);
			identifier = (Integer) query.executeUpdate();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return identifier;
	}

	public void updateUser(UserDTO user) {
		Session session = null;
		long id = 0;
		try {
			session = factory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(user);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}

	public UserDTO findById(long iD) {

		try (Session session = factory.openSession();) {
			UserDTO userFromDataBase = session.get(UserDTO.class, new Long(iD));
			return userFromDataBase;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void deleteUser(long id) {
		try (Session session = factory.openSession();) {

			System.out.println("method of dao reached ");
			session.beginTransaction();

			session.delete(id);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			System.out.println("eccetipn form dao method");
			e.printStackTrace();
		}
	}

	public void deleteByQuery(long id) {
		System.out.println("Entered in Deleting Query Method !");
		String qry = "DELETE FROM UserDTO user WHERE id=:uId";
		try (Session session = factory.openSession()) {
			session.beginTransaction();
			Query query = session.createQuery(qry);
			query.setParameter("uId", id);
			query.executeUpdate();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

}
