package com.cg.niit.flightbooking.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cg.niit.flightbooking.entity.UserDetails;
import com.cg.niit.flightbooking.repository.UserDetailsRepository;
@Service
public class UserDetailsService 
{
	@Autowired
	UserDetailsRepository userRepository;
	
	@Transactional(readOnly=true)
	public UserDetails getUserDetail(int userId)
	{
		Optional<UserDetails> user = userRepository.findById(userId);
		if(user!=null)
			return user.get();
		throw new RuntimeException("No User Found");
	}
	
	@Transactional(readOnly=true)
	public boolean authenticate(int userId,String password)
	{
		UserDetails user = userRepository.findByUserIdAndPassword(userId,password);
		if(user!=null)
			return true;
		throw new RuntimeException("User Name Or Password Is Incorrect");
	}
	
	@Transactional
	public boolean addUserDetails(UserDetails details)
	{
		UserDetails u = userRepository.save(details);
		return u!=null;
	}
}
