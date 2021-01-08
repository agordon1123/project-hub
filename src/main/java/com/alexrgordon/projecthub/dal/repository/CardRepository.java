package com.alexrgordon.projecthub.dal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alexrgordon.projecthub.dal.dao.model.Card;

@Repository("cardRepository")
public interface CardRepository extends CrudRepository<Card, Integer> {

}
