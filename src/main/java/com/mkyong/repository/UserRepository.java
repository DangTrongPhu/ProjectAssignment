package com.mkyong.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mkyong.model.User;

public interface UserRepository extends JpaRepository<User,Long>{
	@Query(value="select * from user where email= :email and pass= :pass" ,nativeQuery= true)
	  User loginUser(@Param("email") String email,@Param("pass") String pass);
}
