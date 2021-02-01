package com.techtorial.academy;

import java.util.Scanner;

public class RuntimeExceptionDemo {
    public static void main(String[] args) {
        Scanner consoleReader = new Scanner(System.in);
        int[] arr = {2, 4, 0, 8, 12};

        int firstIndex = getUserInput(consoleReader, "Enter the first index: ");
        int secondIndex = getUserInput(consoleReader, "Enter the second index: ");
        divideNumbers(arr[firstIndex], arr[secondIndex]);
    }

    private static int getUserInput(Scanner consoleReader, String message) {
        int index = -1;
        while (index < 0) {
            try {
                System.out.print(message);
                String userResponse = consoleReader.nextLine();
                index = Integer.parseInt(userResponse);
                if (index < 0) {
                    throw new IllegalArgumentException("The number cannot be less than 0");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return index;
    }

    private static void divideNumbers(int dividend, int divisor) {
        try {
            System.out.println(dividend + " / " + divisor + " = " + dividend / divisor);
        } catch (ArithmeticException e) {
            System.out.println("A divisor cannot be 0!");
        }
    }
}
