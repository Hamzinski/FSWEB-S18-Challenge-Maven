package com.workintech.fswebs18challengemaven.controller;

import com.workintech.fswebs18challengemaven.entity.Card;
import com.workintech.fswebs18challengemaven.exceptions.CardException;
import com.workintech.fswebs18challengemaven.repository.CardRepository;
import com.workintech.fswebs18challengemaven.util.CardValidation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/cards")
public class CardController {

    private final CardRepository cardRepository;

    @PostMapping
    public Card save(@RequestBody Card card) {
        CardValidation.validateCard(card);
        return cardRepository.save(card);
    }

    @GetMapping
    public List<Card> getAll() {
        return cardRepository.findAll();
    }

    @GetMapping("/byColor/{color}")
    public List<Card> getAllByColor(@PathVariable("color") String color) {
        return cardRepository.findByColor(color);
    }

    @GetMapping("byValue/{value}")
    public List<Card> getAllByValue(@PathVariable("value") Integer value) {
        return cardRepository.findByValue(value);
    }

    @GetMapping("byType/{type}")
    public List<Card> getAllByValue(@PathVariable("type") String type) {
        return cardRepository.findByType(type);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Card> update(@PathVariable Long id, @RequestBody Card card) {
        Optional<Card> optionalCard = cardRepository.findById(id);
        if (optionalCard.isPresent()) {
            Card existingCard = optionalCard.get();
            existingCard.setType(card.getType());
            cardRepository.save(existingCard);
            return ResponseEntity.ok(existingCard);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        cardRepository.remove(id);
    }

}