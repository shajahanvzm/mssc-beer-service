package com.sha.msscbeerservice.bootstrap;

import com.sha.msscbeerservice.domain.Beer;
import com.sha.msscbeerservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

//@Component
public class BeerLoader  implements CommandLineRunner {

    public static final String BEER_1_UPC = "0631234200036";
    public static final String BEER_2_UPC = "0631234300019";
    public static final String BEER_3_UPC = "0083783375213";

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
                .upc(BEER_1_UPC)
                .price(new BigDecimal("12.99"))
                .build());

            beerRepository.save(Beer.builder()
                .beerName("Galaxy Cat")
                .beerStyle("PALE_ALE")
                .quantityToBrew(100)
                .minOnHand(12)
                .upc(BEER_2_UPC)
                .price(new BigDecimal("11.99"))
                .build());
            beerRepository.save(Beer.builder()
                .beerName("No Hammers on the Bar")
                .beerStyle("PALE_ALE")
                .quantityToBrew(100)
                .minOnHand(12)
                .upc(BEER_3_UPC)
                .price(new BigDecimal("11.99"))
                .build());
        }

        System.out.println("Loaded beers :  "+beerRepository.count());
    }
}
