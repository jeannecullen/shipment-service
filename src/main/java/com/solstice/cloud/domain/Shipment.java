package com.solstice.cloud.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Shipment {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long shipmentId;
    private Long account;
    private Long address;
    private Long orderLineItems;
    private Timestamp shipDate;
    private Timestamp deliverDate;

    public Shipment() {
    }

    public Shipment(Long shipmentId, Long account, Long address, Long orderLineItems, Timestamp shipDate, Timestamp deliverDate) {
        this.shipmentId = shipmentId;
        this.account = account;
        this.address = address;
        this.orderLineItems = orderLineItems;
        this.shipDate = shipDate;
        this.deliverDate = deliverDate;
    }

    public Long getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(Long shipmentId) {
        this.shipmentId = shipmentId;
    }

    public Long getAccount() {
        return account;
    }

    public void setAccount(Long account) {
        this.account = account;
    }

    public Long getOrderLineItems() {
        return orderLineItems;
    }

    public void setOrderLineItems(Long orderLineItems) {
        this.orderLineItems = orderLineItems;
    }

    public Long getAddress() {
        return address;
    }

    public void setAddress(Long address) {
        this.address = address;
    }

    public Timestamp getShipDate() {
        return shipDate;
    }

    public void setShipDate(Timestamp shipDate) {
        this.shipDate = shipDate;
    }

    public Timestamp getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(Timestamp deliverDate) {
        this.deliverDate = deliverDate;
    }
}
