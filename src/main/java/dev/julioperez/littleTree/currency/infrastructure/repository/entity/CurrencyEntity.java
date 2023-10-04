package dev.julioperez.littleTree.currency.infrastructure.repository.entity;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "CURRENCY", schema = "SL")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyEntity {

    @Id
    private String id;
    private String name;
    private Float buyPrice;
    private Float sellPrice;
    private Date updatedAt;
}
