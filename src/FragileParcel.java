public class FragileParcel extends Parcel implements Trackable {
    final static int PRICE = 3;

    public FragileParcel(String description, int sendDay, String deliveryAddress, int weight) {
        super(description, sendDay, deliveryAddress, weight, PRICE);
    }


    @Override
    public void packageItem() {
        System.out.println("Посылка " + description + " обёрнута в защитную плёнку");
        super.packageItem();
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка " + description + " изменила местоположение на " + newLocation);
    }

    @Override
    public String toString() {
        return "Посылка: " + description + ", вес: " + weight + ", адрес: " + deliveryAddress;
    }
}
