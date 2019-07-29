package check_orders_jsons;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalesOrderLines {
    private String buyersItemNo;
    private String sellersMaterial;
    private String orderQuantity;
    private String orderUoM;
    private String returnPlantCode;
}
