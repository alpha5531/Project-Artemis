package com.counterhost.Application.ShopEngine.Basket;

public interface Baskets {
    void openBasket();
    void closeBasket(int basketNr);
    void payBasket(int basketNr);
    void cancelBasket(int basketNr);
    void infoBasket(int basketNr);
}
