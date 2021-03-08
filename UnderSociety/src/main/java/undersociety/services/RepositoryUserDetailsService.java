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

import undersociety.models.Users;
import undersociety.repositories.UserRepository;


@Service
public class RepositoryUserDetailsService implements UserDetailsService {
 @Autowired
 private UserRepository userRepository;
 @Override
 public UserDetails loadUserByUsername(String username)
 throws UsernameNotFoundException {
	 Users user =  (userRepository.findByusername(username).orElseThrow(() -> new UsernameNotFoundException("User not found")));
	 List<GrantedAuthority> roles = new ArrayList<>();
	 roles.add(new SimpleGrantedAuthority("ROLE_USER"));
	 return new org.springframework.security.core.userdetails.User(user.getUser_name(), 
	 user.getPass(), roles);
 }
}
