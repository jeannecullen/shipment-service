package com.solstice.cloud.domain;

import java.sql.Timestamp;

public class OrdersResult {

    private Long accountId;
    private Long orderNumber;
    private Timestamp orderDate;
    private Long addressId;
    private Long ordersLineId;
    private double totalPrice;

    public OrdersResult() {
    }

    public OrdersResult(Long accountId, Long orderNumber, Timestamp orderDate, Long addressId, Long ordersLineId, double totalPrice) {
        this.accountId = accountId;
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.addressId = addressId;
        this.ordersLineId = ordersLineId;
        this.totalPrice = totalPrice;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Long getOrdersLineId() {
        return ordersLineId;
    }

    public void setOrdersLineId(Long ordersLineId) {
        this.ordersLineId = ordersLineId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
