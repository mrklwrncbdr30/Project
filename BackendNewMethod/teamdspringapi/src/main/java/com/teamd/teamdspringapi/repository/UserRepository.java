package com.teamd.teamdspringapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teamd.teamdspringapi.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long>{

}
