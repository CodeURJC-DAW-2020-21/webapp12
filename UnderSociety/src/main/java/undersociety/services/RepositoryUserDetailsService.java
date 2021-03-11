package undersociety.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import undersociety.models.Roles;
import undersociety.models.Users;
import undersociety.repositories.RolesRepository;
import undersociety.repositories.UserRepository;


@Service
public class RepositoryUserDetailsService implements UserDetailsService {
 @Autowired
 private UserRepository userRepository;
 @Autowired
 private RolesRepository rolesRepository;
 @Override
 public UserDetails loadUserByUsername(String username)
 throws UsernameNotFoundException {
	 Users user =  (userRepository.findByusername(username).orElseThrow(() -> new UsernameNotFoundException("User not found")));
	 List<Roles> r = rolesRepository.findByiduser(user);
	 List<GrantedAuthority> roles = new ArrayList<>();
	 for (Roles rol : r) {
		 roles.add(new SimpleGrantedAuthority("ROLE_"+rol.getRol()));
	}
	 return new org.springframework.security.core.userdetails.User(user.getUser_name(), 
	 user.getPass(), roles);
 }
}
