package com.stockify.platform;

import java.util.Scanner;

public class App {

    private static final InventoryManager inventoryManager = new InventoryManager();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine().trim();
            if (line.equalsIgnoreCase("EXIT")) {
                System.out.println("Product Count: " + inventoryManager.getProductCount());
                System.out.println("Total Inventory Value: " + inventoryManager.getTotalInventoryValue());
                System.out.println("Goodbye!");
                break;
            }

            String result = inventoryManager.processCommand(line);
            System.out.println(result);
        }
    }
}
