package com.alexrgordon.projecthub.api.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexrgordon.projecthub.api.model.Board;
import com.alexrgordon.projecthub.api.model.User;
import com.alexrgordon.projecthub.dal.repository.BoardRepository;
import com.alexrgordon.projecthub.dal.repository.UserRepository;

@Service
public class BoardService {

    @Autowired 
    private DataSource dataSource;
    
    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserRepository userRepository;

    public BoardService() { }

    public Board createBoard(Board board, Integer userId) {
        // validate request params
        // todo: validate user does not already have that board name
        if (board.getName() == null || board.getName().trim().isEmpty()) {
            throw new ValidationException("Parameter Board.name is missing or empty.");
        }
        if (userId == null) {
            throw new ValidationException("Parameter userId cannot be null.");
        }
        if (!userRepository.existsById(userId)) {
            throw new EntityNotFoundException("User with Id " + userId + " was not found.");
        }
        
        // map to domain class and save to jpa repository
        com.alexrgordon.projecthub.dal.dao.model.Board domainBoard = 
                com.alexrgordon.projecthub.dal.dao.model.Board.toBoard(board);
        boardRepository.save(domainBoard);

        // add new board to joining table with user
        try {
            final Connection conn = dataSource.getConnection();
            final int boardId = domainBoard.getId();
            final String query = "INSERT INTO project_hub_db.UserBoards (UserId, BoardId) VALUES (?, ?);";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, boardId);
            preparedStatement.execute();
            conn.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            // throw e;
        }

        // map new board back to api model class
        Board mappedBoard = Board.toBoard(domainBoard);
        return mappedBoard;
    }
    
}