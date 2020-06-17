package com.virtualClass.App.repository;

import org.springframework.data.repository.CrudRepository;

import com.virtualClass.App.model.User;

public interface UserRepository  extends CrudRepository<User, String>{

}
