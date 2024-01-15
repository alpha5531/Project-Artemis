package com.counterhost.Application.ShopEngine.Basket;

public enum BasketStatus {
    PAID(0),
    NOTPAID(1),
    OPENED(2),
    CLOSED(3),
    CANCELLED(4),
    NODATA(5),
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
                "value=" + value +
                '}';
    }
}