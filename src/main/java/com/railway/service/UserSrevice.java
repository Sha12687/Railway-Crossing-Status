package com.railway.service;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.railway.admin.Admin;
import com.railway.dao.HibernateUtil;
import com.railway.entity.CrossingStation;
import com.railway.entity.FavoriteStation;
import com.railway.entity.User;

public class UserSrevice {
	private static Session session=HibernateUtil.getSessionFactory();
	public static void Insert(User u) {
		Transaction tx=session.beginTransaction();
		session.save(u);
		tx.commit();
	}
	public static User getUserByuserName(String email,String password) {
		Transaction tx = session.beginTransaction();
	    String hql = "FROM User WHERE email = :email AND password = :password";
	    Query query = session.createQuery(hql);
	    query.setParameter("email", email);
	    query.setParameter("password", password);
	    User user=null;
	    try {
	        user = (User) query.getSingleResult();
	    } catch (NoResultException e) {
	        // Handle the case where no user is found
	    }
	    session.getTransaction().commit();
	    return user;
	}
	public static Admin getUserByAdminName(String email,String password) {
		Transaction tx = session.beginTransaction();
		String hql = "FROM com.railway.admin.Admin WHERE email = :email AND password = :password";
	    Query query = session.createQuery(hql);
	    query.setParameter("email", email);
	    query.setParameter("password", password);
	    Admin admin=null;
	    try {
	        admin = (Admin) query.getSingleResult();
	    } catch (NoResultException e) {
	        // Handle the case where no user is found
	    }
	    session.getTransaction().commit();
	    return admin;
	}
	public static boolean LoginValidation(String email,String password) {
		Transaction tx = session.beginTransaction();
	    String hql = "FROM User WHERE email = :email AND password = :password";
	    Query query = session.createQuery(hql);
	    query.setParameter("email", email);
	    query.setParameter("password", password);
	    User user = null;
	    try {
	        user = (User) query.getSingleResult();
	    } catch (NoResultException e) {
	        // Handle the case where no user is found
	    }
	    session.getTransaction().commit();
	    return user != null;
	}
	public static List<CrossingStation> allStations(){
		Transaction tx=session.beginTransaction();
		List<CrossingStation> crossingStation = session.createQuery("FROM CrossingStation", CrossingStation.class).getResultList();
		tx.commit();
		return crossingStation;
	}
	public static void addFavorite(FavoriteStation favoriteStation) {
		// TODO Auto-generated method stub
		Transaction tx=session.beginTransaction();
	session.save(favoriteStation);
		tx.commit();
	}
	public static List<FavoriteStation> getFavoriteStations(long id){
		Transaction tx=session.beginTransaction();
		System.out.println(id);
		  String hql = "FROM FavoriteStation fs WHERE fs.user.id = :user_id";
		  Query query = session.createQuery(hql, FavoriteStation.class);
		  query.setParameter("user_id",id );
		List<FavoriteStation> favoriteStation =(List<FavoriteStation>) query.getResultList();
			tx.commit();
			return favoriteStation;
	}
	public static void save(Admin admin) {
		Transaction tx=session.beginTransaction();
		session.save(admin);
		tx.commit();
	}
	public static boolean LoginValidationAdmin(String email, String password) {
		Transaction tx = session.beginTransaction();
		String hql = "FROM com.railway.admin.Admin WHERE email = :email AND password = :password";
	    Query query = session.createQuery(hql);
	    query.setParameter("email", email);
	    query.setParameter("password", password);
	    Admin admin = null;
	    try {
	        admin = (Admin) query.getSingleResult();
	    } catch (NoResultException e) {
	        // Handle the case where no user is found
	    }
	    session.getTransaction().commit();
	    return admin != null;
	}
	public static void save(CrossingStation station) {
		Transaction tx=session.beginTransaction();
		session.save(station);
		tx.commit();
	}
	public static void delete(long id) {
		Transaction tx=session.beginTransaction();
		String hql = "DELETE FROM CrossingStation cs WHERE cs.id = :id";
        Query query = session.createQuery(hql);
        System.out.println(id);
        query.setParameter("id", id);
        query.executeUpdate();
		tx.commit();
	}
}
