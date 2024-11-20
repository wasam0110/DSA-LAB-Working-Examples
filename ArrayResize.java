/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wasam
 */
import java.util.Arrays;

public class ArrayResize {

    public static int[] resizeArray(int[] array, int newSize) {
        int[] resizedArray = new int[newSize];
        for (int i = 0; i < Math.min(array.length, newSize); i++) {
            resizedArray[i] = array[i];
        }
        return resizedArray;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int[] resizedArray = resizeArray(array, 7);
        System.out.println("Resized Array: " + Arrays.toString(resizedArray));
    }
}

