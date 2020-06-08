package com.sha.msscbeerservice.web.modal;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @NotNull
    @Positive
    private BigDecimal price;
    @NotNull
    @Positive
    private Long upc;
    private Integer quantityOnHand;
    @Null
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.ssZ",shape = JsonFormat.Shape.STRING)
    private OffsetDateTime createdDate;
    @Null
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.ssZ",shape = JsonFormat.Shape.STRING)
    private OffsetDateTime lastModifiedDate;



}


