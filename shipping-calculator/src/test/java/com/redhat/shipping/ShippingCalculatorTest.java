package com.redhat.shipping;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ShippingCalculatorTest {

    // @Test
    // public void canCalculateTheCostForARegion() throws RegionNotFoundException {
    //     // Given
    //     ShippingCalculator calculator = new ShippingCalculator();
    //     // When

    //     // Then
    //     assertEquals(0, calculator.costForRegion("A Region"));
    // }

    @Test
    public void calculatedCostForNARegionis100() throws RegionNotFoundException {
        ShippingCalculator calculator = new ShippingCalculator();

        String regionName = "NA";
        Integer shippingCode = calculator.costForRegion(regionName);

        assertEquals(100, shippingCode);
    }

    @Test
    public void calculatedCostForLATANRegionis200() throws RegionNotFoundException {
        ShippingCalculator calculator = new ShippingCalculator();

        String regionName = "LATAN";
        Integer shippingCode = calculator.costForRegion(regionName);

        assertEquals(200, shippingCode);
    }

    @Test
    public void calculatedCostForEMEANRegionis300() throws RegionNotFoundException {
        ShippingCalculator calculator = new ShippingCalculator();

        String regionName = "EMEA";
        Integer shippingCode = calculator.costForRegion(regionName);

        assertEquals(300, shippingCode);
    }

    @Test
    public void calculatedCostForEMEANRegionis400() throws RegionNotFoundException {
        ShippingCalculator calculator = new ShippingCalculator();

        String regionName = "APAC";
        Integer shippingCode = calculator.costForRegion(regionName);

        assertEquals(400, shippingCode);
    }

    @Test
    public void onNonSupportedRegionARegionNotFoundExceptionIsRaised() throws RegionNotFoundException {
        ShippingCalculator calculator = new ShippingCalculator();
        assertThrows(
                RegionNotFoundException.class,
                () -> calculator.costForRegion("Unknown Region"));
    }
}
