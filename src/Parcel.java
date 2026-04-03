public abstract class Parcel {
    protected String description;
    protected int weight;
    protected String deliveryAddress;
    protected int sendDay;
    protected int price;

    public Parcel(String description, int sendDay, String deliveryAddress, int weight, int priceX) {
        this.description = description;
        this.sendDay = sendDay;
        this.deliveryAddress = deliveryAddress;
        this.weight = weight;
        this.price = priceX;
    }

    public void packageItem() {
        System.out.println("Посылка " + description + " упакована");
    }

    public void deliver() {
        System.out.println("Посылка " + description + " доставлена по адресу " + deliveryAddress);
    }

    public int calculateDeliveryCost() {

        return price * weight;
    }

    public String getDescription() {
        return description;
    }
}
