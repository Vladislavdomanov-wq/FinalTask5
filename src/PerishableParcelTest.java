import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PerishableParcelTest {

    @Test
    public void calculateDeliveryCostShouldReturnFortyWhenWeightIsTen() {
        PerishableParcel perishableParcel = new PerishableParcel("Рыба", 16, "Красно-Армейская",
                10, 5);

        int shippingCost = 40;

        int actualResult = perishableParcel.calculateDeliveryCost();

        assertEquals(shippingCost, actualResult);
    }

    @Test
    public void calculateDeliveryCostShouldReturnZeroWhenWeightIsZero() {
        PerishableParcel perishableParcel = new PerishableParcel("Рыба", 16, "Красно-Армейская",
                0, 5);

        int shippingCost = 0;

        int actualResult = perishableParcel.calculateDeliveryCost();

        assertEquals(shippingCost, actualResult);
    }

    @Test
    public void calculateDeliveryCostShouldReturnZeroWhenWeightIsMinusTen() {
        PerishableParcel perishableParcel = new PerishableParcel("Рыба", 16, "Красно-Армейская",
                -10, 5);

        int shippingCost = -40;

        int actualResult = perishableParcel.calculateDeliveryCost();

        assertEquals(shippingCost, actualResult);
    }

    @Test
    public void isExpired_shouldReturnFalse_whenCurrentDayIsBeforeExpiryT1() {
        PerishableParcel parcel = new PerishableParcel("Рыба", 10, "Адрес", 1, 5);

        boolean result = parcel.isExpired(12);

        assertFalse(result);  // ожидаем false — посылка НЕ испортилась
    }

    @Test
    public void isExpired_shouldReturnFalse_whenCurrentDayIsBeforeExpiryT2() {
        PerishableParcel parcel = new PerishableParcel("Рыба", 10, "Адрес", 1, 5);

        boolean result = parcel.isExpired(15);

        assertFalse(result);  // ожидаем false — посылка НЕ испортилась

    }

    @Test
    public void isExpired_shouldReturnTrue_whenCurrentDayIsBeforeExpiryT3() {
        PerishableParcel parcel = new PerishableParcel("Рыба", 10, "Адрес", 1, 5);

        boolean result = parcel.isExpired(16);

        assertTrue(result);  // ожидаем false — посылка НЕ испортилась

    }
}

