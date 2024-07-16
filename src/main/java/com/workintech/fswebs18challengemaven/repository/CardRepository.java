package com.workintech.fswebs18challengemaven.repository;

import com.workintech.fswebs18challengemaven.entity.Card;
import com.workintech.fswebs18challengemaven.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface CardRepository  {


    Card save(Card card);

    List<Card> findAll();

    Card update(Card card);

    Card remove(long id);

    List<Card> findByColor(String color);



    List<Card> findByValue(Integer value);


    List<Card> findByType(String type);

    Optional<Card> findById(Long id);
}