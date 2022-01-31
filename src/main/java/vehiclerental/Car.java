package vehiclerental;

import java.time.LocalTime;

public class Car implements Rentable{

    private String ID;
    private int rentingPrice;
    private LocalTime RentingTime;

    public Car(String ID, int rentingPrice) {
        this.ID = ID;
        this.rentingPrice = rentingPrice;
    }

    public String getID() {
        return ID;
    }

    @Override
    public int calculateSumPrice(long minutes) {
        return (int)minutes*rentingPrice;
    }

    @Override
    public LocalTime getRentingTime() {
        return RentingTime;
    }

    @Override
    public void rent(LocalTime time) {
        RentingTime = time;
    }

    @Override
    public void closeRent() {
        RentingTime = null;
    }

}
