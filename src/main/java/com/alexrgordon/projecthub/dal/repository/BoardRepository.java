package com.alexrgordon.projecthub.dal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alexrgordon.projecthub.dal.dao.model.Board;

@Repository("boardRepository")
public interface BoardRepository extends CrudRepository<Board, Board> {

}
