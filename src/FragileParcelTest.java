import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FragileParcelTest {
    @Test
    public void calculateDeliveryCostShouldReturnWhenWeightIsNine() {
        FragileParcel fragileParcel = new FragileParcel("Посуда", 12,
                "Восточная", 3);

        int shippingCost = 12;

        int actualResult = fragileParcel.calculateDeliveryCost();

        assertEquals(shippingCost, actualResult);
    }

    @Test
    public void calculateDeliveryCostShouldReturnWhenWeightIsZero() {
        FragileParcel fragileParcel = new FragileParcel("Посуда", 12,
                "Восточная", 0);

        int shippingCost = 0;

        int actualResult = fragileParcel.calculateDeliveryCost();

        assertEquals(shippingCost, actualResult);
    }

    @Test
    public void calculateDeliveryCostShouldReturnWhenWeightIsMinusThree() {
        FragileParcel fragileParcel = new FragileParcel("Посуда", 12,
                "Восточная", -3);

        int shippingCost = -12;

        int actualResult = fragileParcel.calculateDeliveryCost();

        assertEquals(shippingCost, actualResult);
    }

}
