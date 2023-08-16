package dev.julioperez.littleTree.currency.infrastructure.repository.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "CURRENCY")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyEntity {

    @Id
    private String id;
    private String name;
    @Column(name = "BUY_PRICE")
    private Float buyPrice;
    @Column(name = "SELL_PRICE")
    private Float sellPrice;
    @Column(name = "UPDATE_AT")
    private Date updateAt;
}
