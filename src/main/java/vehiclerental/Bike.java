package vehiclerental;

import java.time.LocalTime;

public class Bike implements Rentable{

    private String ID;
    private LocalTime RentingTime;

    public Bike(String ID) {
        this.ID = ID;
    }

    public Bike(String ID, LocalTime rentingTime) {
        this.ID = ID;
        RentingTime = rentingTime;
    }

    @Override
    public int calculateSumPrice(long minutes) {
        return (int)minutes*15;
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
