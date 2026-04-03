import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ParcelBox<T extends Parcel> {
    List<T> box = new ArrayList<>();
    int boxWeight = 20;

    public void addParcel(T parcel) {
        if (boxWeight >= parcel.weight) {
            boxWeight -= parcel.weight;
            box.add(parcel);
        } else {
            System.out.println("Коробочка заполнена.");
        }
    }

    public void getAllParcels() {
        for (T parcel : box) {
            System.out.println(parcel.toString());
        }

    }

    public int getParcelCount() {
        return box.size();
    }

}
