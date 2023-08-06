package dev.julioperez.littleTree.currency.infrastructure.repository.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "CURRENCY")
@Data
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
