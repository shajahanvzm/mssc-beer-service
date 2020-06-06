package com.sha.msscbeerservice.web.modal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {
    @Null
    private UUID id;

    @NotBlank
    private String beerName;
    @NotNull
    private BeerStyleEnum beerStyle;
    @Null
    private Integer version;
    @NotNull
    @Positive
    private BigDecimal price;
    @NotNull
    @Positive
    private Long upc;
    private Integer quantityOnHand;
    @Null
    private OffsetDateTime createdDate;
    @Null
    private OffsetDateTime lastModifiedDate;



}


