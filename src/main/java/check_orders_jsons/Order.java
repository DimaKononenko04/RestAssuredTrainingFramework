package check_orders_jsons;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private String shipTo;
    private String plant;
    private String salesDoc;
    private String materialNumber;
    private String orderQuantity;
    private String allocatedQuantity;
    private String reorderQuantity;
    private String materialNetValue;
    private String poNumber;
    private String pricingDate;
    private String poDate;
    private String pricingType;
    private String mainTruckType;
    private String mainTruckDensity;
    private String mainWeight;
    private String mainMinVolume;
    private String mainMinValue;
    private String mainSlog;
    private String weightTruckType;
    private String weightTruckDensity;
    private String weightMinWeight;
    private String weightMinVolume;
    private String weightMinValue;
    private String weightSlog;
    private String materialEAN;
    private String materialWeight;
    private String materialVolume;
    private String materialDensity;
}
