package com.alexrgordon.projecthub.dal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alexrgordon.projecthub.dal.dao.model.ListModel;

@Repository("listRepository")                      // <    T    ,    ID  >
public interface ListRepository extends CrudRepository<ListModel, Integer> {

}