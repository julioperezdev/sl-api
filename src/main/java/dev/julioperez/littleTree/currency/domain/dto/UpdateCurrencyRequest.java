package dev.julioperez.littleTree.currency.domain.dto;

public record UpdateCurrencyRequest (String name, Float buyPrice, Float sellPrice){
}
