package net.cefacem.app.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.GrantedAuthority;

@Service
public class SecurityUserAssembler {
	
	public User buildSecurityUser(net.cefacem.app.model.User user) {
		
		String username = user.getUserName();
		String password = user.getPassword();
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return new User(username, password, enabled, accountNonExpired, credentialsNonExpired,
					accountNonLocked, authorities);
	}
}
