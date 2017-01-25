package com.yiqiang.repository.javase.thread.forkandjoin.chapter01.util;

/**
 * Title:
 * Description: This class stores the data of a Product. It's name and it's price
 * Create Time: 2017/1/20 0020 23:07
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class Product {

    /**
     * Name of the product
     */
    private String name;

    /**
     * Price of the product
     */
    private double price;

    /**
     * This method returns the name of the product
     * @return the name of the product
     */
    public String getName() {
        return name;
    }

    /**
     * This method establish the name of the product
     * @param name the name of the product
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method returns the price of the product
     * @return the price of the product
     */
    public double getPrice() {
        return price;
    }

    /**
     * This method establish the price of the product
     * @param price the price of the product
     */
    public void setPrice(double price) {
        this.price = price;
    }

}
