public class StandardParcel extends Parcel {
   private final static int PRICE = 2;

    public StandardParcel(String description, int sendDay, String deliveryAddress, int weight) {
        super(description, sendDay, deliveryAddress, weight, PRICE);
    }

    @Override
    public String toString() {
        return "Посылка: " + description + ", вес: " + weight + ", адрес: " + deliveryAddress;
    }

}