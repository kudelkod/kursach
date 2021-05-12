package com.Dima.Model;

import java.util.Arrays;

/**
 *<strong>Array model</strong>
 *
 * <i>Содержит все необходимые методы для создания объектов класса {@link Array},
 * а так же методы для установления и получения значений полей класса</i>
 *
 * @author Dmitriy Kudelko
 * @version 1.0
 */
public class Array {
    /** <b>Array</b> */
    public int[] array;

    /** <b>Number of elements in array</b>*/
    public int numberOfElements;

    public Array(){
        this.numberOfElements=1000;
    }

    /**
     *<i>Method to create array</i>
     */
    public void createArray(){
        this.array = new int[this.numberOfElements];
        for (int i = 0; i < this.array.length; i++){
            this.array[i] = (int) (Math.random() *this.numberOfElements);
        }
    }

    /**
     * <i>Method to get{@link Array#array}</i>
     * @return Array
     */
    public String getArray(){
        return Arrays.toString(this.array).replace("[","").replace("]","");

    }

    /**
     *<i>Method to sort array increase</i>
     */
    public void sortArrayIncreace(){
        int step = (int) (this.array.length / 1.247);
        int swapCount = 1;
        while (step > 1 || swapCount > 0) {
            swapCount = 0;
            for(int i = 0; i + step < this.array.length; i++){
                if (this.array[i] > this.array[i + step]){
                    int temp = this.array[i];
                    this.array[i] = this.array[i + step];
                    this.array[i + step] = temp;
                    swapCount++;
                }
            }
            if (step > 1){
                step = (int) (step / 1.247);
            }
        }
    }

    /**
     *<i>Method to sort array waning</i>
     */
    public void sortArrayWaning(){
        int step = (int) (this.array.length / 1.247);
        int swapCount = 1;
        while (step > 1 || swapCount > 0) {
            swapCount = 0;
            for(int i = 0; i + step < this.array.length; i++){
                if (this.array[i] < this.array[i + step]){
                    int temp = this.array[i];
                    this.array[i] = this.array[i + step];
                    this.array[i + step] = temp;
                    swapCount++;
                }
            }
            if (step > 1){
                step = (int) (step / 1.247);
            }
        }
    }

    /**
     * <i>Method to set {@link Array#numberOfElements}</i>
     * @param n Number of elements in array
     */
    public void setNumberOfElements(int n){
        this.numberOfElements = n;
    }
}
