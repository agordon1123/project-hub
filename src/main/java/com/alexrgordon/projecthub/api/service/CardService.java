package com.alexrgordon.projecthub.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexrgordon.projecthub.dal.repository.CardRepository;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    public CardService() { }
    
}
