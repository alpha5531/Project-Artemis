package com.counterhost.Application.ShopEngine.Basket;

public enum BasketStatus {
    OPERATIONSUCCESFULL(0),
    PAID(1),
    NOTPAID(2),
    OPENED(3),
    CLOSED(4),
    CANCELLED(5),
    NODATA(6),
    ERROR(99);

    private final int value;

    BasketStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "BasketStatus{" +
                "Status=" + new BasketError(value).toString() +
                '}';
    }
}