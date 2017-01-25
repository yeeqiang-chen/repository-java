package com.yiqiang.repository.javase.thread.forkandjoin.chapter01.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Title:
 * Description:
 * This class generates a product list of a determined size.
 * Each product is initialized with a predefined name and price.
 * Create Time: 2017/1/20 0020 23:08
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class ProductListGenerator {
    /**
     * This method generates the list of products
     * @param size the size of the product list
     * @return the generated list of products
     */
    public List<Product> generate (int size) {
        List<Product> ret=new ArrayList<Product>();

        for (int i=0; i<size; i++){
            Product product=new Product();
            product.setName("Product "+i);
            product.setPrice(10);
            ret.add(product);
        }

        return ret;
    }
}
