/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 123
 */
public class ReverseArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println("Array in reverse order:");
        printReverse(array, array.length - 1);
    }

    // Recursive method to print the array in reverse
    public static void printReverse(int[] array, int index) {
        if (index < 0) {
            return; // Base case: stop when index is less than 0
        }
        System.out.print(array[index] + " "); // Print current element
        printReverse(array, index - 1); // Recursive call for the previous index
    }
}

