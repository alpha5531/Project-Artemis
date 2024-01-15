package com.counterhost.Application.ShopEngine.Basket;

import com.counterhost.StaticVariables.Time;
import java.time.LocalDateTime;

public class Basket implements Baskets{
    private long basketNr;
    private LocalDateTime timeOpenBasket;
    private LocalDateTime timeCloseBasket;
    private LocalDateTime timePaidBasket;
    private LocalDateTime timeCancelledBasket;
    private boolean isBasketOpen;
    private boolean isBasketPaid;
    private boolean isBasketCancelled;
    private Long basketOwnerId;

    public Basket() {
    }

    public Basket(long basketNr, LocalDateTime timeOpenBasket, LocalDateTime timeCloseBasket, LocalDateTime timePaidBasket, LocalDateTime timeCancelledBasket, boolean isBasketOpen, boolean isBasketPaid, boolean isBasketCancelled, Long basketOwnerId) {
        this.basketNr = basketNr;
        this.timeOpenBasket = timeOpenBasket;
        this.timeCloseBasket = timeCloseBasket;
        this.timePaidBasket = timePaidBasket;
        this.timeCancelledBasket = timeCancelledBasket;
        this.isBasketOpen = isBasketOpen;
        this.isBasketPaid = isBasketPaid;
        this.isBasketCancelled = isBasketCancelled;
        this.basketOwnerId = basketOwnerId;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "basketNr=" + basketNr +
                ", timeOpenBasket=" + timeOpenBasket +
                ", timeCloseBasket=" + timeCloseBasket +
                ", timePaidBasket=" + timePaidBasket +
                ", timeCancelledBasket=" + timeCancelledBasket +
                ", isBasketOpen=" + isBasketOpen +
                ", isBasketPaid=" + isBasketPaid +
                ", isBasketCancelled=" + isBasketCancelled +
                ", basketOwnerId=" + basketOwnerId +
                '}';
    }

    @Override
    public void openBasket() {
        timeOpenBasket = Time.getCurrentDateTime();
        isBasketOpen = true;

    }
    @Override
    public void closeBasket(int basketNr) {
        timeCloseBasket = Time.getCurrentDateTime();
        isBasketOpen = false;
        this.basketNr = basketNr;
    }

    @Override
    public void payBasket(int basketNr) {
        timePaidBasket = Time.getCurrentDateTime();
        isBasketOpen = false;
        isBasketPaid = true;
    }

    @Override
    public void cancelBasket(int basketNr) {
        timeCancelledBasket = Time.getCurrentDateTime();
        isBasketOpen = false;
        isBasketCancelled = true;
    }

    @Override
    public void infoBasket(int basketNr) {

    }

    public long getBasketNr() {
        return basketNr;
    }

    public void setBasketNr(long basketNr) {
        this.basketNr = basketNr;
    }

    public LocalDateTime getTimeOpenBasket() {
        return timeOpenBasket;
    }

    public void setTimeOpenBasket(LocalDateTime timeOpenBasket) {
        this.timeOpenBasket = timeOpenBasket;
    }

    public LocalDateTime getTimeCloseBasket() {
        return timeCloseBasket;
    }

    public void setTimeCloseBasket(LocalDateTime timeCloseBasket) {
        this.timeCloseBasket = timeCloseBasket;
    }

    public LocalDateTime getTimePaidBasket() {
        return timePaidBasket;
    }

    public void setTimePaidBasket(LocalDateTime timePaidBasket) {
        this.timePaidBasket = timePaidBasket;
    }

    public LocalDateTime getTimeCancelledBasket() {
        return timeCancelledBasket;
    }

    public void setTimeCancelledBasket(LocalDateTime timeCancelledBasket) {
        this.timeCancelledBasket = timeCancelledBasket;
    }

    public Long getBasketOwnerId() {
        return basketOwnerId;
    }

    public void setBasketOwnerId(Long basketOwnerId) {
        this.basketOwnerId = basketOwnerId;
    }

    public boolean isBasketOpen() {
        return isBasketOpen;
    }

    public void setBasketOpen(boolean basketOpen) {
        isBasketOpen = basketOpen;
    }

    public boolean isBasketPaid() {
        return isBasketPaid;
    }

    public void setBasketPaid(boolean basketPaid) {
        isBasketPaid = basketPaid;
    }

    public boolean isBasketCancelled() {
        return isBasketCancelled;
    }

    public void setBasketCancelled(boolean basketCancelled) {
        isBasketCancelled = basketCancelled;
    }
}
