package com.alexrgordon.projecthub.api.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alexrgordon.projecthub.api.model.Board;
import com.alexrgordon.projecthub.api.model.Card;
import com.alexrgordon.projecthub.api.model.ListModel;
import com.alexrgordon.projecthub.api.model.User;
import com.alexrgordon.projecthub.api.service.BoardService;
import com.alexrgordon.projecthub.api.service.CardService;
import com.alexrgordon.projecthub.api.service.ListService;

@RestController
public class ApiController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private CardService cardService;

    @Autowired
    private ListService listService;

    public ApiController() { }

    @RequestMapping(path="/api/board", method=RequestMethod.POST)
    public ResponseEntity<Object> createBoard(@RequestBody Board board, @RequestParam Integer userId) {
        try {
            Board createdBoard = boardService.createBoard(board, userId);
            return new ResponseEntity<>(createdBoard, HttpStatus.CREATED);

        } catch (ValidationException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path="/api/board", method=RequestMethod.GET)
    public ResponseEntity<Object> getBoardsByUser(@RequestParam Integer userId) {
        try {
            List<Board> userBoards = boardService.getBoardsByUserId(userId);
            return new ResponseEntity<>(userBoards, HttpStatus.OK);

        } catch (ValidationException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path="/api/board", method=RequestMethod.PUT)
    public ResponseEntity<Object> updateBoard(@RequestBody Board board) {
        try {
            Board updatedBoard = boardService.updateBoard(board);
            return new ResponseEntity<>(updatedBoard, HttpStatus.OK);

        } catch (ValidationException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path="/api/board", method=RequestMethod.DELETE)
    public ResponseEntity<Object> deleteBoard(@RequestParam Integer boardId) {
        try {
            boardService.deleteBoardById(boardId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (ValidationException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path="/api/card", method=RequestMethod.POST)
    public ResponseEntity<Object> createCard(@RequestBody Card card, @RequestParam Integer listId) {
        try {
            Card createdCard = cardService.createCard(card, listId);
            return new ResponseEntity<>(createdCard, HttpStatus.CREATED);

        } catch (ValidationException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path="/api/card", method=RequestMethod.GET)
    public ResponseEntity<Object> getCardsByList(@RequestParam Integer listId) {
        try {
            List<Card> cards = cardService.getCardsByListId(listId);
            return new ResponseEntity<>(cards, HttpStatus.OK);

        } catch (ValidationException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path="/api/card", method=RequestMethod.PUT)
    public ResponseEntity<Object> updateCard(@RequestBody Card card) {
        try {
            Card updatedCard = cardService.updateCard(card);
            return new ResponseEntity<>(updatedCard, HttpStatus.OK);

        } catch (ValidationException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path="/api/card", method=RequestMethod.DELETE)
    public ResponseEntity<Object> deleteCard(Integer cardId) {
        try {
            cardService.deleteCard(cardId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (ValidationException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path="/api/list", method=RequestMethod.POST)
    public ResponseEntity<Object> createList(@RequestBody ListModel list, @RequestParam Integer boardId) {
        try {
            ListModel createdList = listService.createList(list, boardId);
            return new ResponseEntity<>(createdList, HttpStatus.CREATED);

        } catch (ValidationException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path="/api/list", method=RequestMethod.GET)
    public ResponseEntity<Object> getListsByBoard(@RequestParam Integer boardId) {
        try {
            List<ListModel> lists = listService.getListsByBoardId(boardId);
            return new ResponseEntity<>(lists, HttpStatus.OK);

        } catch (ValidationException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path="/api/list", method=RequestMethod.PUT)
    public ResponseEntity<Object> updateList(@RequestBody ListModel list) {
        try {
            ListModel updatedList = listService.updateList(list);
            return new ResponseEntity<>(updatedList, HttpStatus.OK);

        } catch (ValidationException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path="/api/list", method=RequestMethod.DELETE)
    public ResponseEntity<Object> deleteList(@RequestParam Integer listId) {
        try {
            listService.deleteListById(listId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            
        } catch (ValidationException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path="/api/test", method=RequestMethod.GET)
    public ResponseEntity<Object> testJpaRelationships(@RequestParam Integer userId) {
        boardService.testJpaRelations(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}