package com.Dima.Model;

import java.util.Arrays;

public class Array {

    public int[] array;
    public int numberOfElements;

    public void createArray(){
        this.array = new int[this.numberOfElements];
        for (int i = 0; i < this.array.length; i++){
            this.array[i] = (int) (Math.random() *this.numberOfElements);
        }
    }

    public String getArray(){
        return Arrays.toString(this.array);

    }

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
    public void setNumberOfElements(int n){
        this.numberOfElements = n;
    }
}
