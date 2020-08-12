package com.practice.algorithms.Sort;

public class InsertionSort {
    int[] arr;

    public InsertionSort(int[] arr) {
        this.arr = arr;
    }

    public int[] doInsertionSort() {
        int i, j;
        int n = arr.length;
        for (j = 1; j <= n - 1; j++) {
            i = j - 1;
            if (arr[i] > arr[j]) {
                arr = swap(i, j, arr);
            }
                    }
      return arr;
    }

    public int[] swap(int i, int j, int[] a) {
        int temp = a[j];
        while (i >= 0 && a[i] > temp) {
            a[i+1] = a[i];
            i--;
        }
        a[i+1]=temp;
        return a;
    }

    public static void main(String[] args) {
        Input input = new Input();
        int[] arr = input.getInput();
        InsertionSort insertionSort = new InsertionSort(arr);
      int[] output=  insertionSort.doInsertionSort();
      for(int i=0;i<output.length;i++) {
          System.out.println(output[i]);
      }
      }
    }

