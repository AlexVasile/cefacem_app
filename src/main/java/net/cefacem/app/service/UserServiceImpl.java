package net.cefacem.app.service;

import java.util.List;

import net.cefacem.app.dao.UserDAO;
import net.cefacem.app.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value="userServiceImpl")
public class UserServiceImpl implements UserService, UserDetailsService {
	
	@Autowired
	private UserDAO userDao;
	@Autowired
	private SecurityUserAssembler assembler;
	@Autowired
	private ShaPasswordEncoder encoder;
	
	public boolean addUser(User user) {
		User u = userDao.findByUsername(user.getUserName());
		if (u == null) {
			String p = encoder.encodePassword(user.getPassword(), user.getUserName());
			user.setPassword(p);
			userDao.save(user);
			return true;
		}
		else {
			return false;
		}
	}
	
	public void addOrUpdateUser(User user) {
		userDao.saveOrUpdate(user);	
	}
	
	public User merge(User user) {
		return userDao.merge(user);
	}
	
	public void delete(User user) {
		userDao.delete(user);
	}
	
	public User findById(int id) {
		return userDao.findById(id);
	}
	
	public List<User> getAllUsers() {
		return userDao.findAll();
	}
	
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}
	
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

		User user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("No user with username '" + username + "' found!");
		}
		return assembler.buildSecurityUser(user);	
	}
	
}
