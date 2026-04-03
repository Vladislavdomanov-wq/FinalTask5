import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParcelBoxTest {

    @Test
    public void addParcelShouldAddParcelWhenEnoughSpace() {
        ParcelBox<StandardParcel> box = new ParcelBox<>();
        StandardParcel parcel = new StandardParcel("Тест", 1, "Адрес", 10);

        box.addParcel(parcel);

        assertEquals(1, box.getParcelCount());
    }

    @Test
    public void addParcelShouldAddParcelWhenWeightEqualsRemainingSpace() {
        ParcelBox<StandardParcel> box = new ParcelBox<>();
        StandardParcel parcel = new StandardParcel("Тест", 1, "Адрес", 20 );

        box.addParcel(parcel);

        assertEquals(1, box.getParcelCount());
    }

    @Test
    public void addParcelShouldNotAddParcelWhenWeightExceedsRemainingSpace() {
        ParcelBox<StandardParcel> box = new ParcelBox<>();
        StandardParcel parcel1 = new StandardParcel("Первая", 1, "Адрес", 15);
        StandardParcel parcel2 = new StandardParcel("Вторая", 1, "Адрес", 20);

        box.addParcel(parcel1);
        box.addParcel(parcel2);

        assertEquals(1, box.getParcelCount());
    }
}
