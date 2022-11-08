package unit_tests;

import managers.PricingManager;
import enums.AgeGroup;
import enums.TypeOfDay;

public class priceMatrixTest {
    public static void main(String[] args) {
        PricingManager.addPrice(TypeOfDay.PUBLIC_HOLIDAY, 2.12);
        PricingManager.addPrice(AgeGroup.ADULT, 3.12);
        PricingManager.addPrice(AgeGroup.STUDENT, -1.20);

        PricingManager.showPriceMatrix();
    }
    
}
