package com.redhat.shipping;

import java.util.HashMap;
import java.util.Map;

public class ShippingCalculator {
    public static final Map<String, Integer> REGIONS = new HashMap<>();
    
    public ShippingCalculator() {
        REGIONS.put("NA", 100);
        REGIONS.put("LATAN", 200);
        REGIONS.put("EMEA", 300);
        REGIONS.put("APAC", 400);
    }

    public int costForRegion(String regionName) throws RegionNotFoundException {


        if (ShippingCalculator.REGIONS.containsKey(regionName)) {
            return ShippingCalculator.REGIONS.get(regionName);
        }

        throw new RegionNotFoundException();
    }
}
