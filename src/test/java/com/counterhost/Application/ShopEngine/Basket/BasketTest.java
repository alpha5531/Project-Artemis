package com.counterhost.Application.ShopEngine.Basket;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasketTest {

    private Basket basket;

    @BeforeEach
    void setUp() {
        basket = new Basket();
    }

    @Test
    void openBasket() {
        assertNull(basket.getTimeOpenBasket());
        basket.openBasket();
        assertNotNull(basket.getTimeOpenBasket());
    }

    @Test
    void closeBasket() {
        assertNull(basket.getTimeCloseBasket());
        basket.closeBasket(1);
        assertNotNull(basket.getTimeCloseBasket());
    }

    @Test
    void payBasket() {
        assertNull(basket.getTimePaidBasket());
        basket.payBasket(2);
        assertNotNull(basket.getTimePaidBasket());
    }

    @Test
    void cancelBasket() {
        assertNull(basket.getTimeCancelledBasket());
        basket.cancelBasket(3);
        assertNotNull(basket.getTimeCancelledBasket());
    }
}
