package net.cefacem.app.dao;

import net.cefacem.app.model.User;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl extends GenericDAOImpl<User, Integer> implements UserDAO {

	@Override
	protected Class<User> getEntityClass() {
		return User.class;
	}

	public User findByUsername(String username) {
		Query query = getSession().createQuery("from User where userName = :user");
		query.setParameter("user", username);
		return (User) query.uniqueResult();
	}
	
}
