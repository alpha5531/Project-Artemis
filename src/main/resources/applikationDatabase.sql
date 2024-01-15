CREATE TABLE Basket (
                        basketNr BIGSERIAL PRIMARY KEY,
                        timeOpenBasket TIMESTAMP,
                        timeCloseBasket TIMESTAMP,
                        timePaidBasket TIMESTAMP,
                        timeCancelledBasket TIMESTAMP,
                        isBasketOpen BOOLEAN,
                        isBasketPaid BOOLEAN,
                        isBasketCancelled BOOLEAN,
                        basketOwnerId BIGINT
);