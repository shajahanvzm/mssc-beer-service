package com.sha.msscbeerservice.web.mappers;

import com.sha.msscbeerservice.domain.Beer;
import com.sha.msscbeerservice.web.modal.BeerDto;

import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);
    Beer beetDtoToBeer(BeerDto beerDto);

}
