package com.sha.msscbeerservice.services;

import com.sha.msscbeerservice.domain.Beer;
import com.sha.msscbeerservice.repositories.BeerRepository;
import com.sha.msscbeerservice.web.controller.NotFoundException;
import com.sha.msscbeerservice.web.mappers.BeerMapper;
import com.sha.msscbeerservice.web.modal.BeerDto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Override
    public BeerDto getBeerById(UUID beerId) {
        return beerMapper.beerToBeerDto(beerRepository.findById(beerId).orElseThrow(NotFoundException::new));
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return beerMapper.beerToBeerDto(beerRepository.save(beerMapper.beetDtoToBeer(beerDto)));
    }

    @Override
    public BeerDto updateBeerById(UUID beerId, BeerDto beerDto) {
        Beer updateBeer = beerRepository.findById(beerId).orElseThrow(NotFoundException::new);
        updateBeer.setBeerName(beerDto.getBeerName());
        updateBeer.setBeerStyle(beerDto.getBeerStyle().name());
        updateBeer.setPrice(beerDto.getPrice());
        updateBeer.setUpc(beerDto.getUpc());
        return beerMapper.beerToBeerDto(beerRepository.save(updateBeer));
    }
}
