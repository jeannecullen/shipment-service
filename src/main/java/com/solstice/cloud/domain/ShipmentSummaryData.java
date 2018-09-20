package com.solstice.cloud.domain;

import java.sql.Timestamp;

public class ShipmentSummaryData {

  private Long orderNumber;
  private Timestamp shipmentDate;
  private Timestamp deliverDate;
  private String productName;
  private int quantity;

    public ShipmentSummaryData() {
    }

    public ShipmentSummaryData(Long orderNumber, Timestamp shipmentDate, Timestamp deliverDate, String productName, int quantity) {
        this.orderNumber = orderNumber;
        this.shipmentDate = shipmentDate;
        this.deliverDate = deliverDate;
        this.productName = productName;
        this.quantity = quantity;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Timestamp getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(Timestamp shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    public Timestamp getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(Timestamp deliverDate) {
        this.deliverDate = deliverDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
