package com.counterhost.Application.ShopEngine.Workers.BasketWorker;

import com.counterhost.Application.ShopEngine.Basket.Basket;
import com.counterhost.Application.ShopEngine.Basket.BasketStatus;
import com.counterhost.DbConnections.DbWorkers.BasketDb;
import com.counterhost.Loggers.exLog;

import java.sql.SQLException;

public class BasketWorker {
    private final BasketDb basketDb;
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
    public BasketStatus CloseBasket(int basketNr){
        BasketStatus status = BasketValidator(basketNr);

        if(status== BasketStatus.OPENED)
        {
            Basket basket = new Basket();
            try {
                basket = basketDb.getBasket(basketNr);
                basket.closeBasket(basketNr);
                BasketDb basketDb = new BasketDb();
                basketDb.updateBasket(basket);
            } catch (SQLException e) {
                new exLog(getClass().getSimpleName(), e);
                e.printStackTrace();
            }
            return BasketStatus.OPERATIONSUCCESFULL;
        }else {
            return status;
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
            return getBasket(basketNr);
        }catch (SQLException e){
            new exLog(getClass().getSimpleName(),e);
            e.printStackTrace();
        }
        return null;
    }
    private BasketStatus BasketValidator(int basketNr) {
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
