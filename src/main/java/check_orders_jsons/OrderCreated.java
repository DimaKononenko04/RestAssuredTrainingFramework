package check_orders_jsons;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
@Getter
@Setter
public class OrderCreated {
    private String sellersProcessType;
    private String sellersOrderType;
    private String sellersPricingDate;
    private String sellersDeliveryBlock;
    private String buyersOrderType;
    private String buyersOrderNo;
    private String buyersOrderDate;
    private String deliveryDateRequested;
    private String paymentTerm;
    private String customerGroup5;
    private String shipTo;
    private ArrayList<Integer> salesDocs;
    private String salesOrganization;
    private String distributionChannel;
    private String division;
    private ArrayList<SalesOrderLines> salesOrderLines;
    private String buyersOrderReference;
    private String isProcessedCorrectly;
    private String isErrorOccurredWhileCreating;
    private String errorMessage;
    private String buyersCollectiveNo;
}
