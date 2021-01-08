package com.alexrgordon.projecthub.api.service;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexrgordon.projecthub.api.model.Card;
import com.alexrgordon.projecthub.dal.repository.BoardRepository;
import com.alexrgordon.projecthub.dal.repository.CardRepository;
import com.alexrgordon.projecthub.dal.repository.ListRepository;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired 
    private BoardRepository boardRepository;

    @Autowired 
    private ListRepository listRepository;

    public CardService() { }

    public Card createCard(Card card, Integer listId) {
        // validate request params
        if (card.getTitle() == null || card.getTitle().trim().isEmpty()) {
            throw new ValidationException("Parameter Card.title is missing or empty.");
        }
        if (listId == null) {
            throw new ValidationException("Parameter boardId cannot be null.");
        }
        if (!listRepository.existsById(listId)) {
            throw new EntityNotFoundException("List with Id " + listId + " was not found.");
        }

        // map to domain class and save to repository
        com.alexrgordon.projecthub.dal.dao.model.Card domainCard 
                = com.alexrgordon.projecthub.dal.dao.model.Card.toCard(card, 1);
        domainCard = cardRepository.save(domainCard);

        // map back to api model class and return
        return Card.toCard(domainCard);
    }

    // need to set up to pull cards from lists and not board
    public List<Card> getCardsByListId(Integer listId) {
        // validate request params
        if (listId == null) {
            throw new ValidationException("Parameter listId cannot be null.");
        }
        if (!listRepository.existsById(listId)) {
            throw new EntityNotFoundException("List with Id " + listId + " was not found.");
        }

        // query board from repository and get list of cards
        com.alexrgordon.projecthub.dal.dao.model.ListModel domainList = listRepository.findById(listId).get();
        // loop through cards, convert to api model class, collect and return
        List<Card> cards = new ArrayList<>();
        for (com.alexrgordon.projecthub.dal.dao.model.Card card : domainList.getCards()) {
            cards.add( Card.toCard(card) );
        }
        return cards;
    }

    public Card updateCard(Card card) {
        // validate request params
        if (card.getId() == null || card.getId() <= 0) {
            throw new ValidationException("Parameter Card.id is null or invalid.");
        }
        if (card.getListId() == null || card.getListId() <= 0) {
            throw new ValidationException("Parameter Card.listId is null or invalid.");
        }
        if (card.getTitle() == null || card.getTitle().trim().isEmpty()) {
            throw new ValidationException("Parameter Card.title is null or empty.");
        }
        if (!cardRepository.existsById(card.getId())) {
            throw new EntityNotFoundException("Card with id " + card.getId() + " was not found.");
        }

        // map to domain class and save to repository
        com.alexrgordon.projecthub.dal.dao.model.Card domainCard = 
                com.alexrgordon.projecthub.dal.dao.model.Card.toCard(card);
        domainCard = cardRepository.save(domainCard);

        // map back to api model class and return
        return Card.toCard(domainCard);
    }

    public void deleteCard(Integer cardId) {
        // validate entity exists and delete from repository
        if (!cardRepository.existsById(cardId)) {
            throw new EntityNotFoundException("Card with Id " + cardId + " was not found.");
        }
        
        cardRepository.deleteById(cardId);
    }
    
}
