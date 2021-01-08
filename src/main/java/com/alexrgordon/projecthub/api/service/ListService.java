package com.alexrgordon.projecthub.api.service;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexrgordon.projecthub.api.model.ListModel;
import com.alexrgordon.projecthub.dal.repository.BoardRepository;
import com.alexrgordon.projecthub.dal.repository.CardRepository;
import com.alexrgordon.projecthub.dal.repository.ListRepository;

@Service
public class ListService {

    @Autowired
    private ListRepository listRepository;
    
    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private BoardRepository boardRepository;

    public ListService() { }

    public ListModel createList(ListModel list, Integer boardId) {
        // validate request params
        if (list.getName() == null || list.getName().trim().isEmpty()) {
            throw new ValidationException("Parameter List.name is missing or empty.");
        }
        if (list.getSortOrder() == null || list.getSortOrder() <= 0) {
            throw new ValidationException("Parameter List.sortOrder is missing or empty.");
        }
        if (boardId == null) {
            throw new ValidationException("Parameter boardId cannot be null.");
        }
        if (!boardRepository.existsById(boardId)) {
            throw new EntityNotFoundException("Board with Id " + boardId + " was not found.");
        }

        // map to domain class and save to repository
        com.alexrgordon.projecthub.dal.dao.model.ListModel domainList 
                = com.alexrgordon.projecthub.dal.dao.model.ListModel.toListModel(list, boardId);
        listRepository.save(domainList);

        // map back to api model class and return
        return ListModel.toListModel(domainList);
    }

    public List<ListModel> getListsByBoardId(Integer boardId) {
        // validate request params
        if (boardId == null) {
            throw new ValidationException("Parameter boardId cannot be null.");
        }
        if (!boardRepository.existsById(boardId)) {
            throw new EntityNotFoundException("Board with Id " + boardId + " was not found.");
        }

        // query board from repository, map lists to api model class, collect and return
        com.alexrgordon.projecthub.dal.dao.model.Board domainBoard = boardRepository.findById(boardId).get();
        List<ListModel> lists = new ArrayList<>();
        for (com.alexrgordon.projecthub.dal.dao.model.ListModel list : domainBoard.getLists()) {
            lists.add( ListModel.toListModel(list) );
        }
        return lists;
    }

    // todo: can be combined with create for create/update?
    public ListModel updateList(ListModel list) {
        // validate request params
        if (list.getId() == null || list.getId() < 0) {
            throw new ValidationException("Parameter ListModel.id is missing or invalid.");
        }
        if (!listRepository.existsById(list.getId())) {
            throw new EntityNotFoundException("List with Id " + list.getId() + " was not found.");
        }
        if (list.getBoardId() == null || list.getBoardId() < 0) {
            throw new ValidationException("Parameter ListModel.boardId is missing or invalid.");
        }
        if (!boardRepository.existsById(list.getBoardId())) {
            throw new EntityNotFoundException("Board with Id " + list.getBoardId() + " was not found.");
        }
        if (list.getName() == null || list.getName().trim().isEmpty()) {
            throw new ValidationException("Parameter ListModel.name is missing or empty.");
        }
        if (list.getSortOrder() == null || list.getSortOrder() <= 0) {
            throw new ValidationException("Parameter ListModel.sortOrder is missing or invalid.");
        }

        // map to domain class and save to repository
        com.alexrgordon.projecthub.dal.dao.model.ListModel domainList 
                = com.alexrgordon.projecthub.dal.dao.model.ListModel.toListModel(list);
        listRepository.save(domainList);

        // map back to api model class and return
        return ListModel.toListModel(domainList);
    }

    public void deleteListById(Integer listId) {
        // validate list exists and delete from repository
        if (!listRepository.existsById(listId)) {
            throw new EntityNotFoundException("List with Id " + listId + " was not found.");
        }
        listRepository.deleteById(listId);
    }
    
}