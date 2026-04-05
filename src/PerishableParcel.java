public class PerishableParcel extends Parcel {
    private int timeToLive;
   private final static int PRICE = 3;// срок годности

    public PerishableParcel(String description, int sendDay, String deliveryAddress, int weight, int timeToLive) {
        super(description, sendDay, deliveryAddress, weight, PRICE);
        this.timeToLive = timeToLive;
    }


    public boolean isExpired(int currentDay) {
        return timeToLive + sendDay < currentDay;
    }

    public int getTimeToLive() {
        return timeToLive;
    }

    public void setTimeToLive(int timeToLive) {
        this.timeToLive = timeToLive;
    }

    @Override
    public String toString() {
        return "Посылка: " + description + ", вес: " + weight + ", адрес: " + deliveryAddress;
    }

}
