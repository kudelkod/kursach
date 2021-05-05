package com.Dima.Model;

import java.util.Arrays;

/**
 *<strong>Модель массива</strong>
 *
 * <i>Содержит все необходимые методы для создания объектов класса {@link Array},
 * а так же методы для установления и получения значений полей класса</i>
 *
 * @author Dmitriy Kudelko
 * @version 1.0
 */
public class Array {
    /** <b>Массив</b> */
    private int[] array;

    /** <b>Количество элементов массива</b>*/
    private int numberOfElements;

    /**
     *<i>Метод для создания массива заполненного случайным набором числовых данных</i>
     */
    public void createArray(){
        this.array = new int[this.numberOfElements];
        for (int i = 0; i < this.array.length; i++){
            this.array[i] = (int) (Math.random() *this.numberOfElements);
        }
    }

    /**
     * <i>Метод, получающий значение поля {@link Array#array}</i>
     * @return Массив значений
     */
    public String getArray(){
        return Arrays.toString(this.array).replace("[","").replace("]","");

    }

    /**
     *<i>Метод для сортировки массива по возрастанию</i>
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
     *<i>Метод для сортировки массива по убыванию</i>
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
     * <i>Метод устанавливающий количество элементов поля {@link Array#numberOfElements}</i>
     * @param n Количество элементов массива
     */
    public void setNumberOfElements(int n){
        this.numberOfElements = n;
    }
}
