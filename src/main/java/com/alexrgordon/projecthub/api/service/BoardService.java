package com.alexrgordon.projecthub.api.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;

import com.alexrgordon.projecthub.api.model.Board;
import com.alexrgordon.projecthub.api.model.User;
import com.alexrgordon.projecthub.dal.repository.BoardRepository;
import com.alexrgordon.projecthub.dal.repository.UserRepository;

public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserRepository userRepository;

    public BoardService() { }

    public Board createBoard(Board board, User user) {
        if (board.getName() == null || board.getName().trim().isEmpty()) {
            throw new ValidationException("Parameter Board.name is missing or empty.");
        }
        if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
            throw new ValidationException("Parameter User.username is missing or empty.");
        }
        // map to domain obj
        com.alexrgordon.projecthub.dal.dao.model.Board domainBoard = 
                com.alexrgordon.projecthub.dal.dao.model.Board.toBoard(board);
        // save to repository
        boardRepository.save(domainBoard);

        // add board to joining table
        // create sql connection 
        // execute query
        final int boardId = domainBoard.getId();
        // final int userId = userRepository.find_UserByUsername(user.getUsername());
        final String query = "INSERT INTO project_hub_db.UserBoards (UserId, BoardId) VALUES (?, ?);";
        DataSource ds = null;
        // Connection c = ds.getConnection();
        // c.

        // map back to api model
        Board mappedBoard = Board.toBoard(domainBoard);
        return mappedBoard;
    }
    
}