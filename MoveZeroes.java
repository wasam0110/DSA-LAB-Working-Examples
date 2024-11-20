/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wasam
 */
public class MoveZeroes {
    public static void moveZeroesToEnd(int[] array) {
        int index = 0;
        for (int num : array) {
            if (num != 0) {
                array[index++] = num;
            }
        }
        while (index < array.length) {
            array[index++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 0, 3, 12};
        moveZeroesToEnd(array);
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
