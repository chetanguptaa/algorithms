package practice;

import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read the input
        String input = scanner.nextLine();
        // Split the input into parts
        String[] nameParts = input.split(" ");
        if (nameParts.length == 3) {
            // If there are three parts, it's in the format: firstName middleName lastName
            String firstName = nameParts[0];
            String middleName = nameParts[1];
            String lastName = nameParts[2];
            // Format the name
            String formattedName = lastName + ", " + firstName.charAt(0) + "." + middleName.charAt(0) + ".";
            System.out.println(formattedName);
        } else if (nameParts.length == 2) {
            // If there are two parts, it's in the format: firstName lastName
            String firstName = nameParts[0];
            String lastName = nameParts[1];
            // Format the name
            String formattedName = lastName + ", " + firstName.charAt(0) + ".";
            System.out.println(formattedName);
        } else {
            // Invalid input
            System.out.println("Invalid input format. Please provide first name and last name, or first name, middle name, and last name.");
        }
    }
}