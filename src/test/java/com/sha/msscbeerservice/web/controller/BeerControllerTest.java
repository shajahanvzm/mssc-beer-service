package com.sha.msscbeerservice.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sha.msscbeerservice.domain.Beer;
import com.sha.msscbeerservice.services.BeerService;
import com.sha.msscbeerservice.web.modal.BeerDto;
import com.sha.msscbeerservice.web.modal.BeerStyleEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    BeerService beerService;

    @Test
    void getBeerById() throws Exception {
        given(beerService.getBeerById(any())).willReturn(getValidBeerDto());
        mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    }


    @Test
    void saveNewBeer() throws Exception {
        BeerDto beerDto = getValidBeerDto();
        given(beerService.saveNewBeer(any())).willReturn(getValidBeerDto());

        String beerDtoJson = objectMapper.writeValueAsString(beerDto);
        mockMvc.perform(post("/api/v1/beer")
            .contentType(MediaType.APPLICATION_JSON)
            .content(beerDtoJson))
            .andExpect(status().isCreated());
    }

    //@Test
    void updateBeerById() throws Exception {
        BeerDto beerDto = getValidBeerDto();
        given(beerService.updateBeerById(any(),any())).willReturn(getValidBeerDto());
        beerDto.setId(UUID.randomUUID());
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);
        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID().toString())
            .contentType(MediaType.APPLICATION_JSON)
            .content(beerDtoJson))
            .andExpect(status().isNoContent());

    }

    private BeerDto getValidBeerDto() {
        return BeerDto.builder()
            .beerName("My Beer")
            .beerStyle(BeerStyleEnum.LG)
            .price(new BigDecimal("2.99"))
            .upc("123123123")
            .build();
    }



}
