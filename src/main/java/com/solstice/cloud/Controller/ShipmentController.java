package com.solstice.cloud.Controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.solstice.cloud.domain.*;
import com.solstice.cloud.service.OrderLineService;
import com.solstice.cloud.service.OrderService;
import com.solstice.cloud.service.ProductService;
import com.solstice.cloud.service.ShipmentService;
import org.apache.commons.math.stat.descriptive.summary.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ShipmentController {

    Logger logger  = LoggerFactory.getLogger("ShipmentController");

    @Autowired ShipmentService shipmentService;

    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @PostMapping("/shipment")
    @HystrixCommand(fallbackMethod = "createShipmentFallback")
    @ResponseBody
    public Shipment createShipment(@RequestBody Shipment shipment) {
        Shipment shipmentSaved = shipmentService.save(shipment);
        logger.info("Account saved: " +shipmentSaved.getShipmentId());
        return shipment;
    }

    @GetMapping("/shipment/{shipmentId}")
    @HystrixCommand(fallbackMethod = "getShipmentFallback")
    public Shipment getShipment(@PathVariable("shipmentId") Long shipmentId) {
        Optional <Shipment> shipmentRetrieved = shipmentService.getShipment(shipmentId);
        Shipment shipment = shipmentRetrieved.get();
        return shipment;
    }

    @GetMapping("/shipment/account/{account}")
    @HystrixCommand(fallbackMethod = "getSummaryFallback")
    @ResponseBody
    public List<ShipmentSummaryData> getSummary(@PathVariable("account") Long account) {

        List<Shipment> shipment = new ArrayList<>();
        List<ShipmentSummaryData> shipmentSummaryData= new ArrayList<>();

        shipmentService.findAllShipmentsForAccount(account).forEach(shipment::add);

        for (Shipment s : shipment) {
            Long orderLineItems = s.getOrderLineItems();
            OrderLineResult orderLineResult = shipmentService.getOrderLineItems(orderLineItems);
            Long orderNumber = shipmentService.getOrders(orderLineItems);
            Long productId = orderLineResult.getProductId();
            ProductResult product = shipmentService.getProduct(productId);

            ShipmentSummaryData summaryData = new ShipmentSummaryData(orderNumber, s.getShipDate(), s.getDeliverDate(), product.getProductName(), orderLineResult.getQuantity());
            shipmentSummaryData.add(summaryData);
        }
        return shipmentSummaryData;

    }

    public Shipment createShipmentFallback (Shipment shipment) {
        logger.info("Error creating shipment");
        return new Shipment();
    }

    public Optional<Shipment> getShipmentFallback(Shipment shipmentId) {
        logger.info("Error getting Shipment " + shipmentId);
        return Optional.of(new Shipment());
    }

    public void getSummaryFallback(Long account) {
        logger.info("Error getting summary data for account " +account);
    }
}
