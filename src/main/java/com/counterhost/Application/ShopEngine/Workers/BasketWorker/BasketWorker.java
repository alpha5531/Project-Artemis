package com.counterhost.Application.ShopEngine.Workers.BasketWorker;

import com.counterhost.Application.ShopEngine.Basket.Basket;
import com.counterhost.Application.ShopEngine.Basket.BasketStatus;
import com.counterhost.DbConnections.DbWorkers.BasketDb;
import com.counterhost.Loggers.exLog;

import java.sql.SQLException;

public class BasketWorker {
    private BasketDb basketDb;
    public BasketWorker(){
        this.basketDb = new BasketDb();
    }
    public Basket OpenBasket(){
        Basket basket = new Basket();
        basket.openBasket();
        try {
            BasketDb basketDb = new BasketDb();
            long basketId = basketDb.addBasket(basket);
            basket.setBasketNr(basketId);
        } catch (SQLException e) {
            new exLog(getClass().getSimpleName(), e);
            e.printStackTrace();
        }
        return basket;
    }
    public Basket CloseBasket(int basketNr){
        if(BasketValidator(basketNr)==BasketStatus.OPENED)
        {
            Basket basket = new Basket();
            basket.closeBasket(basketNr);
            try {
                BasketDb basketDb = new BasketDb();
                basketDb.updateBasket(basket);
            } catch (SQLException e) {
                new exLog(getClass().getSimpleName(), e);
                e.printStackTrace();
            }
            return basket;
        }else {
            return null;
        }

    }
    public Basket payBasket(int basketNr){
        Basket basket = new Basket();
        basket.payBasket(basketNr);
        return basket;
    }
    public Basket cancelBasket(int basketNr){
        Basket basket = new Basket();
        basket.cancelBasket(basketNr);
        return basket;
    }
    public Basket infoBasket(int basketNr){
        try {
            Basket basket = getBasket(basketNr);
            return basket;
        }catch (SQLException e){
            new exLog(getClass().getSimpleName(),e);
            e.printStackTrace();
        }
        return null;
    }
    public BasketStatus BasketValidator(int basketNr) {
        try {
            Basket basket = basketDb.getBasket(basketNr);
            if (basket != null) {
                if (basket.isBasketPaid()&&basket.getTimePaidBasket()!=null) {
                    return BasketStatus.PAID;
                } else if (basket.isBasketOpen() && basket.getTimeOpenBasket() != null &&
                !basket.isBasketCancelled() && basket.getTimeCancelledBasket() == null
                        &&!basket.isBasketPaid() && basket.getTimePaidBasket() == null) {
                    return BasketStatus.OPENED;
                } else if (basket.isBasketCancelled() && basket.getTimeCancelledBasket()!=null) {
                    return BasketStatus.CANCELLED;
                } else {
                    return BasketStatus.CLOSED;
                }
            } else {
                return BasketStatus.NODATA;
            }
        } catch (SQLException e) {
            new exLog(getClass().getSimpleName(), e);
            e.printStackTrace();
            return BasketStatus.ERROR;
        }
    }

    private Basket getBasket(int basketNr) throws SQLException {
        return basketDb.getBasket(basketNr);
    }
}
