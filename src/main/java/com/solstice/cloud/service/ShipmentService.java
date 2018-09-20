package com.solstice.cloud.service;

import com.solstice.cloud.domain.*;
import com.solstice.cloud.repo.ShipmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShipmentService {

    Logger logger = LoggerFactory.getLogger("ShipmentService");

    @Autowired OrderService orderService;
    @Autowired ProductService productService;
    @Autowired OrderLineService orderLineService;
    ShipmentRepository shipmentRepository;

    public ShipmentService(ShipmentRepository shipmentRepository) {
        super();
        this.shipmentRepository = shipmentRepository;
    }

    public List<Shipment> findAllShipments() {
        return shipmentRepository.findAll();
    }

    public Shipment save(Shipment shipment) {
        if(shipment.getAccount()==null) {
            logger.info("Shipment is null");
        } else {
            logger.info("Shipment is not null");
        }
        Shipment shipmentSaved = shipmentRepository.save(shipment);
        return shipmentSaved;
    }

    public Optional<Shipment> getShipment(Long shipmentId) {
        return shipmentRepository.findById(shipmentId);
    }

    public Long getOrders(Long ordersId) {
        return orderService.getOrders(ordersId);
    }

    public ProductResult getProduct(Long productId) { return productService.getProduct(productId); }

    public OrderLineResult getOrderLine(Long orderLineId) {
        return orderService.getOrderLine(orderLineId);
    }

    public OrderLineResult getOrderLineItems(Long orderLineId) { return orderLineService.listOrderLineItems(orderLineId);}

    public List<Shipment> findAllShipmentsForAccount(long accountId) {
        return shipmentRepository.findAllByAccountOrderByDeliverDateAsc(accountId);
    }

}
