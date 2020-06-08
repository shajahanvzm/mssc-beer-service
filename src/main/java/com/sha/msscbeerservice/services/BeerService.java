package com.sha.msscbeerservice.services;

import com.sha.msscbeerservice.web.modal.BeerDto;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeerById(UUID beerId,BeerDto beerDto);
}
