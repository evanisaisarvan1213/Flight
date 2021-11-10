package com.cg.niit.flightbooking.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.niit.flightbooking.entity.UserDetails;
public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> 
{
	public UserDetails findByUserIdAndPassword(int userId,String password);
}
