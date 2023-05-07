package com.portfolio.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.portfolio.models.User;
import com.portfolio.repositories.UserRepo;

public class userDetailsService implements UserDetailsService {
	@Autowired
	private UserRepo userRepo;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
     User user = this.userRepo.getuserByUserName(username);
     System.out.print("user is admin"+user.getEmail());
     if(user==null) {
    	 throw new UsernameNotFoundException("username not found");
    	 
    	 
     }
     
     CustomUserDetail detail = new CustomUserDetail(user);
		return detail;
	}

}
