package com.yiqiang.repository.javase.thread.forkandjoin.chapter05.utils;

import java.util.Random;

/**
 * Title:
 * Description:
 * Class that generates an array of integer numbers between 0 and 10
 * with a size specified as parameter
 * Create Time: 2017/1/20 0020 23:52
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class ArrayGenerator {
    /**
     * Method that generates an array of integer numbers between 0 and 10
     * with the specified size
     * @param size The size of the array
     * @return An array of random integer numbers between 0 and 10
     */
    public int[] generateArray(int size) {
        int array[]=new int[size];
        Random random=new Random();
        for (int i=0; i<size; i++){
            array[i]=random.nextInt(10);
        }
        return array;
    }
}
