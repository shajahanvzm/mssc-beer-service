package com.sha.msscbeerservice.bootstrap;

import com.sha.msscbeerservice.domain.Beer;
import com.sha.msscbeerservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader  implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if(beerRepository.count()==0){
            beerRepository.save(Beer.builder()
                .beerName("Mango Bobs")
                .beerStyle("IPA")
                .quantityToBrew(100)
                .minOnHand(12)
                .upc(300000L)
                .price(new BigDecimal("12.99"))
                .build());

            beerRepository.save(Beer.builder()
                .beerName("Galaxy Cat")
                .beerStyle("PALE_ALE")
                .quantityToBrew(100)
                .minOnHand(12)
                .upc(3000012L)
                .price(new BigDecimal("11.99"))
                .build());
        }

        System.out.println("Loaded beers :  "+beerRepository.count());
    }
}
