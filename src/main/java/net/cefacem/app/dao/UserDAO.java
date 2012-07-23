package net.cefacem.app.dao;

import net.cefacem.app.model.User;

public interface UserDAO extends GenericDAO<User, Long> {
	
	public User findByUsername(String username);
}
