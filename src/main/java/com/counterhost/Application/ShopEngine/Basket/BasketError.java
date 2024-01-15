package com.counterhost.Application.ShopEngine.Basket;

public class BasketError {
    private String info = "Info";
    private int kod;
    private String description;

    public BasketError(int kod) {
        this.kod = kod;
        this.description = errorInfo(kod);
    }
    protected String errorInfo(int kod)
    {
        //Spaghetti code :(
        if(BasketStatus.OPERATIONSUCCESFULL.getValue() == kod){
            return "Operation Successfull!";
        } else if(BasketStatus.PAID.getValue() == kod){
            return "Basket is allready Paid!";
        } else if (BasketStatus.CLOSED.getValue()==kod) {
            return "Basket is Already Closed!";
        } else if (BasketStatus.CANCELLED.getValue() == kod) {
            return "Basket is Cancelled!";
        } else if (BasketStatus.NODATA.getValue() == kod) {
            return "Could not find basket with provided number!";
        }
         return "Error during processing request, please try again later!";
    }

    @Override
    public String toString() {
        return "BasketError{" +
                "info='" + info + '\'' +
                ", kod=" + kod +
                ", description='" + description + '\'' +
                '}';
    }

}
