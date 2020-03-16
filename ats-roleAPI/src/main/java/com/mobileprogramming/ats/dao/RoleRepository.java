package com.mobileprogramming.ats.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobileprogramming.ats.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}
