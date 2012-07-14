package net.cefacem.app.dao;

import net.cefacem.app.model.User;

public interface UserDAO extends GenericDAO<User, Integer> {
	
	public User findByUsername(String username);
}
