package com.alexrgordon.projecthub.api.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.alexrgordon.projecthub.dal.repository.CardRepository;

public class CardService {

    @Autowired
    private CardRepository cardRepository;

    public CardService() { }
    
}
