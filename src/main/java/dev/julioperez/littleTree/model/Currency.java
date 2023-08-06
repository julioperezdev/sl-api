package dev.julioperez.littleTree.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "CURRENCY")
@Data
public class Currency {
    //to info
    @Id
    private String uuid;
    private String name;
    @Column(name = "BUY_PRICE")
    private Float buyPrice;
    @Column(name = "SELL_PRICE")
    private Float sellPrice;
    @Column(name = "UPDATE_AT")
    private Date updateAt;
}
