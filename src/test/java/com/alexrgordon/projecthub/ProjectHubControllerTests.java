package com.alexrgordon.projecthub;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import com.alexrgordon.projecthub.api.controller.ApiController;
import com.alexrgordon.projecthub.dal.repository.BoardRepository;
import com.alexrgordon.projecthub.dal.repository.CardRepository;
import com.alexrgordon.projecthub.dal.repository.ListRepository;
import com.alexrgordon.projecthub.dal.repository.UserRepository;

/**
 * This class represents a series of unit tests for REST API Controller.
 * Each method represents a CRUD function for a specific type. 
 * As models are built out more and expanded upon, this class will serve 
 * as a source of truth for required mapping properties. 
 */
@SpringBootTest
class ProjectHubControllerTests {

	@MockBean
	private BoardRepository boardRepository;
	
	@MockBean
	private CardRepository cardRepository;
	
	@MockBean
	private ListRepository listRepository;
	
	@MockBean
	private UserRepository userRepository;
	
	@Autowired
	private ApiController controller;

	@Test
	public void testCreateBoard() {
		// stub methods
		when(userRepository.existsById( any(Integer.class) )).thenReturn(true);
		when( boardRepository.save( any(com.alexrgordon.projecthub.dal.dao.model.Board.class) ) )
				.thenReturn( this.getMockDomainBoard() );

		// call controller
		ResponseEntity<Object> res = controller.createBoard(getMockApiModelBoard(), 1);
		
		// declare assertions
		assertEquals(201, res.getStatusCodeValue());
		assertNotNull(res.getBody());
		assertEquals(getMockApiModelBoard().getClass(), res.getBody().getClass());
	}

	@Test 
    @Transactional
	public void testGetBoardsByUserID() {
		// stub and mock methods
		com.alexrgordon.projecthub.dal.dao.model.User mock = this.getMockDomainUser();
		mock.setBoards( Arrays.asList(this.getMockDomainBoard()) );
		when(userRepository.existsById( any(Integer.class) )).thenReturn(true);
		when(userRepository.findById( any(Integer.class) )).thenReturn( Optional.of(mock) );
		
		// call controller 
		ResponseEntity<Object> res = controller.getBoardsByUser(1);
		
		// declare assertions
		assertEquals(200, res.getStatusCodeValue());
		assertNotNull(res.getBody());
		assertFalse( ((ArrayList)res.getBody()).isEmpty() );
	}

	@Test 
	public void testUpdateBoard() {
		// stub methods and mock
		com.alexrgordon.projecthub.api.model.Board mock = this.getMockApiModelBoard();
		when(boardRepository.existsById( any(Integer.class) )).thenReturn(true);
		when( boardRepository.save( any(com.alexrgordon.projecthub.dal.dao.model.Board.class) ) )
				.thenReturn( com.alexrgordon.projecthub.dal.dao.model.Board.toBoard(mock) );
		
		// call controller 
		ResponseEntity<Object> res = controller.updateBoard( this.getMockApiModelBoard() );
		
		// declare assertions
		assertEquals(200, res.getStatusCodeValue());
		assertNotNull(res.getBody());
		assertEquals(getMockApiModelBoard().getClass(), res.getBody().getClass());
	}

	@Test 
	public void testDeleteBoard() {
		// stub methods
		when(boardRepository.existsById( any(Integer.class) )).thenReturn(true);
		doNothing().when(boardRepository).deleteById( any(Integer.class) );

		// call controller 
		ResponseEntity<Object> res = controller.deleteBoard(3);

		// declare assertions
		assertEquals(204, res.getStatusCodeValue());
	}

	@Test
	public void testCreateList() {
		// stub methods and mock
		com.alexrgordon.projecthub.api.model.ListModel mock = this.getMockApiModelList();
		when(boardRepository.existsById( any(Integer.class) )).thenReturn(true);
		when(listRepository.save( any(com.alexrgordon.projecthub.dal.dao.model.ListModel.class) ))
				.thenReturn( com.alexrgordon.projecthub.dal.dao.model.ListModel.toListModel(mock, 1) );

		// call controller
		ResponseEntity<Object> res = controller.createList(mock, 1);
		
		// declare assertions
		assertEquals(201, res.getStatusCodeValue());
		assertNotNull(res.getBody());
		assertEquals(getMockApiModelList().getClass(), res.getBody().getClass());
	}

	@Test 
	public void testGetLists() {
		// stub methods and mock
		com.alexrgordon.projecthub.dal.dao.model.Board mock = new com.alexrgordon.projecthub.dal.dao.model.Board();
		mock.setLists( Arrays.asList(this.getMockDomainList()) );
		when(boardRepository.existsById( any(Integer.class) )).thenReturn(true);
		when(boardRepository.findById( any(Integer.class) )).thenReturn( Optional.of(mock) );

		// call controller
		ResponseEntity<Object> res = controller.getListsByBoard(1);
		
		// declare assertions
		assertEquals(200, res.getStatusCodeValue());
		assertNotNull(res.getBody());
		assertFalse( ((ArrayList)res.getBody()).isEmpty() );
	}

	@Test 
	public void testUpdateList() {
		// stub methods and mock
		com.alexrgordon.projecthub.api.model.ListModel mock = this.getMockApiModelList();
		mock.setBoardId(1);
		when(listRepository.existsById( any(Integer.class) )).thenReturn(true);
		when(boardRepository.existsById( any(Integer.class) )).thenReturn(true);
		when(listRepository.save( any(com.alexrgordon.projecthub.dal.dao.model.ListModel.class) ))
				.thenReturn( com.alexrgordon.projecthub.dal.dao.model.ListModel.toListModel(mock) );

		// call controller
		ResponseEntity<Object> res = controller.updateList(mock);

		// declare assertions
		assertEquals(200, res.getStatusCodeValue());
		assertNotNull(res.getBody());
		assertEquals(mock.getClass(), res.getBody().getClass());
	}

	@Test 
	public void testDeleteList() {
		// stub methods
		when(listRepository.existsById( any(Integer.class) )).thenReturn(true);
		doNothing().when(listRepository).deleteById( any(Integer.class) );

		// call controller 
		ResponseEntity<Object> res = controller.deleteList(1);

		// declare assertions
		assertEquals(204, res.getStatusCodeValue());
	}

	@Test
	public void testCreateCard() {
		// stub methods and mock
		com.alexrgordon.projecthub.api.model.Card mock = this.getMockApiModelCard();
		when(listRepository.existsById( any(Integer.class) )).thenReturn(true);
		when( cardRepository.save( any(com.alexrgordon.projecthub.dal.dao.model.Card.class) ) )
				.thenReturn( com.alexrgordon.projecthub.dal.dao.model.Card.toCard(mock) );
		
		// call controller
		ResponseEntity<Object> res = controller.createCard(this.getMockApiModelCard(), 1);
		
		// declare assertions
		assertEquals(201, res.getStatusCodeValue());
		assertNotNull(res.getBody());
		assertEquals(getMockApiModelCard().getClass(), res.getBody().getClass());
	}

	@Test 
	public void testGetCards() {
		// stub methods and mock 
		com.alexrgordon.projecthub.dal.dao.model.ListModel mock = this.getMockDomainList();
		mock.setCards( Arrays.asList(this.getMockDomainCard()) );
		when(listRepository.existsById( any(Integer.class) )).thenReturn(true);
		when(listRepository.findById( any(Integer.class) )).thenReturn( Optional.of(mock) );

		// call controller 
		ResponseEntity<Object> res = controller.getCardsByList(1);

		// declare assertions 
		assertEquals(200, res.getStatusCodeValue());
		assertNotNull(res.getBody());
		assertFalse( ((ArrayList)res.getBody()).isEmpty() );
	}

	@Test 
	public void testUpdateCard() {
		// stub methods and mock
		com.alexrgordon.projecthub.api.model.Card mock = this.getMockApiModelCard();
		mock.setListId(1);
		when(cardRepository.existsById( any(Integer.class) )).thenReturn(true);
		when(cardRepository.save( any(com.alexrgordon.projecthub.dal.dao.model.Card.class) ))
				.thenReturn( com.alexrgordon.projecthub.dal.dao.model.Card.toCard(mock) );

		// call controller 
		ResponseEntity<Object> res = controller.updateCard(mock);

		// declare assertions
		assertEquals(200, res.getStatusCodeValue());
		assertNotNull(res.getBody());
		assertEquals(mock.getClass(), res.getBody().getClass());
	}

	@Test 
	public void testDeleteCard() {
		// stub methods 
		when(cardRepository.existsById( any(Integer.class) )).thenReturn(true);
		doNothing().when(cardRepository).deleteById( any(Integer.class) );

		// call controller 
		ResponseEntity<Object> res = controller.deleteCard(1);

		// declare assertions
		assertEquals(204, res.getStatusCodeValue());
	}

	private com.alexrgordon.projecthub.dal.dao.model.User getMockDomainUser() {
		com.alexrgordon.projecthub.dal.dao.model.User mock = new com.alexrgordon.projecthub.dal.dao.model.User();
		mock.setId(1);
		mock.setFirstName("Alex");
		mock.setLastName("Gordon");
		mock.setUsername("argordon");
		return mock;
	}

	private com.alexrgordon.projecthub.api.model.User getMockApiModelUser() {
		com.alexrgordon.projecthub.api.model.User mock = new com.alexrgordon.projecthub.api.model.User();
		mock.setId(1);
		mock.setFirstName("Alex");
		mock.setLastName("Gordon");
		mock.setUsername("argordon");
		return mock;
	}

	private com.alexrgordon.projecthub.dal.dao.model.Board getMockDomainBoard() {
		com.alexrgordon.projecthub.dal.dao.model.Board mock = new com.alexrgordon.projecthub.dal.dao.model.Board();
		com.alexrgordon.projecthub.dal.dao.model.User userFK = new com.alexrgordon.projecthub.dal.dao.model.User();
		userFK.setId(1);
		mock.setId(1);
		// mock.setUser(userFK);
		mock.setName("Project Hub Back End API");
		return mock;
	}

	private com.alexrgordon.projecthub.api.model.Board getMockApiModelBoard() {
		com.alexrgordon.projecthub.api.model.Board mock = new com.alexrgordon.projecthub.api.model.Board();
		mock.setId(1);
		mock.setName("Project Hub Back End API");
		return mock;
	}

	private com.alexrgordon.projecthub.dal.dao.model.ListModel getMockDomainList() {
		com.alexrgordon.projecthub.dal.dao.model.ListModel mock = new com.alexrgordon.projecthub.dal.dao.model.ListModel();
		com.alexrgordon.projecthub.dal.dao.model.Board boardFK = new com.alexrgordon.projecthub.dal.dao.model.Board();
		boardFK.setId(1);
		mock.setId(1);
		mock.setBoard(boardFK);
		mock.setName("In Progress");
		mock.setSortOrder(1);
		return mock;
	}

	private com.alexrgordon.projecthub.api.model.ListModel getMockApiModelList() {
		com.alexrgordon.projecthub.api.model.ListModel mock = new com.alexrgordon.projecthub.api.model.ListModel();
		mock.setId(1);
		mock.setName("In Progress");
		mock.setSortOrder(1);
		return mock;
	}

	private com.alexrgordon.projecthub.dal.dao.model.Card getMockDomainCard() {
		com.alexrgordon.projecthub.dal.dao.model.Card mock = new com.alexrgordon.projecthub.dal.dao.model.Card();
		com.alexrgordon.projecthub.dal.dao.model.ListModel listFK = new com.alexrgordon.projecthub.dal.dao.model.ListModel();
		listFK.setId(1);
		mock.setId(1);
		mock.setList(listFK);
		mock.setTitle("Test Controller Methods");
		mock.setDescription("Unit test controller methods and assert expectations");
		return mock;
	}

	private com.alexrgordon.projecthub.api.model.Card getMockApiModelCard() {
		com.alexrgordon.projecthub.api.model.Card mock = new com.alexrgordon.projecthub.api.model.Card();
		mock.setId(1);
		mock.setTitle("Test Controller Methods");
		mock.setDescription("Unit test controller methods and assert expectations");
		return mock;
	}
}
