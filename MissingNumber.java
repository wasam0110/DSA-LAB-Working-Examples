/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wasam
 */
public class MissingNumber {

    public static int findMissingNumber(int[] array, int n) {
        int totalSum = n * (n + 1) / 2;
        int arraySum = 0;
        for (int num : array) {
            arraySum += num;
        }
        return totalSum - arraySum;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 5, 6};
        int n = 6;
        System.out.println("Missing number: " + findMissingNumber(array, n));
    }
}

