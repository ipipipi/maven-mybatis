package com.pipidan.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {
    private int orderId;
    private Date orderTime;
    private double total;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(orderTime);
        return "Order{" +
                "orderId=" + orderId +
                ", orderTime=" + time +
                ", total=" + total +
                '}';
    }
}
