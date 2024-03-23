package com.example.contactmanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.contactmanager.entities.User;



public interface UserRepository extends JpaRepository<User, Integer> {
    
}
