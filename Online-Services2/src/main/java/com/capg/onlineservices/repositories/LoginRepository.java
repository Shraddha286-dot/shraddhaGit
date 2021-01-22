package com.capg.onlineservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.capg.onlineservices.models.Login;

public interface LoginRepository extends JpaRepository<Login, String> {

    Login findByUsername(String username);

}
