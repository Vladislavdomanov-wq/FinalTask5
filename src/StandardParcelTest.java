import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class StandardParcelTest {
    @Test
    public void calculateDeliveryCost_shouldReturnSix_whenWeightIsThree() {
        StandardParcel standardParcel = new StandardParcel("Стандартная", 15,
                "Кругликова", 3);

        int shippingCost = 6;


        int actualResult = standardParcel.calculateDeliveryCost();

        assertEquals(shippingCost, actualResult);

    }

    @Test
    public void calculateDeliveryCost_shouldReturnSix_whenWeightIsZero() {
        StandardParcel standardParcel = new StandardParcel("Стандартная", 15,
                "Кругликова", 0);

        int shippingCost = 0;


        int actualResult = standardParcel.calculateDeliveryCost();

        assertEquals(shippingCost, actualResult);

    }

    @Test
    public void CalculateShippingCostsAndReturnMoneyIfTheWeightIsMinusFive() {
        StandardParcel standardParcel = new StandardParcel("Стандартная", 15,
                "Кругликова", -5);

        int shippingCost = -10;


        int actualResult = standardParcel.calculateDeliveryCost();

        assertEquals(shippingCost, actualResult);

    }
}


