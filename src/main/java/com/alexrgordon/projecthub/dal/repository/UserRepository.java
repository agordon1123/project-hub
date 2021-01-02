package com.alexrgordon.projecthub.dal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alexrgordon.projecthub.dal.dao.model.User;

@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, User> {

}
