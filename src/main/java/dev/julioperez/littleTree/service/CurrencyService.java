package dev.julioperez.littleTree.service;

import dev.julioperez.littleTree.model.Currency;

public interface CurrencyService {
    Currency getCurrencyById(String id) throws Exception;
}
