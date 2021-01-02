package com.alexrgordon.projecthub.api.controller;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alexrgordon.projecthub.api.model.Board;
import com.alexrgordon.projecthub.api.model.Card;
import com.alexrgordon.projecthub.api.model.User;
import com.alexrgordon.projecthub.api.service.CardService;
import com.alexrgordon.projecthub.api.service.BoardService;

@RestController
class ApiController {

    private BoardService boardService;
    private CardService cardService;

    @Value("${test}")
	static String test;

    public ApiController() { 
        this.boardService = new BoardService();
        this.cardService = new CardService();
        System.out.println(">>> test: " + test);
    }

    @RequestMapping(path="/api/board", method=RequestMethod.POST)
    public ResponseEntity<Object> createBoard(@RequestBody Board board, User user) {

        try {
            Board createdBoard = boardService.createBoard(board, user);
            return new ResponseEntity<>(board, HttpStatus.CREATED);

        } catch (ValidationException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path="/api/board", method=RequestMethod.GET)
    public void getBoardsByUser(String username) {
        //
    }

    @RequestMapping(path="/api/board", method=RequestMethod.PUT)
    public void updateBoard(@RequestBody Board card) {
        //
    }

    @RequestMapping(path="/api/board", method=RequestMethod.DELETE)
    public void deleteBoard(int boardId) {
        //
    }

    @RequestMapping(path="/api/card", method=RequestMethod.POST)
    public String createCard(@RequestBody Card card) {
        System.out.println(card);
        com.alexrgordon.projecthub.dal.dao.model.Card mappedCard 
                = com.alexrgordon.projecthub.dal.dao.model.Card.toCard(card);
        System.out.println(mappedCard);
        return "Hello world";
    }

    @RequestMapping(path="/api/card", method=RequestMethod.GET)
    public void getCardsByBoard(String board) {
        //
    }

    @RequestMapping(path="/api/card", method=RequestMethod.PUT)
    public void updateCard(@RequestBody Card card) {
        //
    }

    @RequestMapping(path="/api/card", method=RequestMethod.DELETE)
    public void deleteCard(int cardId) {
        //
    }

}