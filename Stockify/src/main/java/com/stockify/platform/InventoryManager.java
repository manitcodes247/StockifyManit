package com.stockify.platform;

import java.util.*;

public class InventoryManager {

    private final Map<String, Product> inventory = new LinkedHashMap<>();

    public String processCommand(String commandLine) {
        try {
            String[] parts = commandLine.trim().split("\\s+", 2);
            String command = parts[0];
            String args = parts.length > 1 ? parts[1] : "";

            switch (command) {
                case "ADD_PRODUCT":
                    return addProduct(args);
                case "UPDATE_QUANTITY":
                    return updateQuantity(args);
                case "UPDATE_PRICE":
                    return updatePrice(args);
                case "VIEW_PRODUCT":
                    return viewProduct(args);
                case "REMOVE_PRODUCT":
                    return removeProduct(args);
                case "LIST_PRODUCTS":
                    return listProducts();
                case "SORT_PRODUCTS":
                    return sortProducts(args);
                default:
                    return "INVALID_COMMAND";
            }
        } catch (Exception e) {
            return "REQUEST_PATTERN_INVALID";
        }
    }

    private String addProduct(String args) {
        String[] parts = args.split("\\s+");
        if (parts.length != 4) return "REQUEST_PATTERN_INVALID";

        String id = parts[0];
        String name = parts[1];
        int quantity = Integer.parseInt(parts[2]);
        int price = Integer.parseInt(parts[3]);

        if (inventory.containsKey(id)) return "PRODUCT_ALREADY_EXISTS";
        inventory.put(id, new Product(id, name, quantity, price));
        return "SUCCESS";
    }

    private String updateQuantity(String args) {
        String[] parts = args.split("\\s+");
        if (parts.length != 2) return "REQUEST_PATTERN_INVALID";

        String id = parts[0];
        int newQty = Integer.parseInt(parts[1]);

        Product product = inventory.get(id);
        if (product == null) return "PRODUCT_NOT_FOUND";
        if (newQty < 0) return "REQUEST_PATTERN_INVALID";

        product.setQuantity(newQty);
        return "SUCCESS";
    }

    private String updatePrice(String args) {
        String[] parts = args.split("\\s+");
        if (parts.length != 2) return "REQUEST_PATTERN_INVALID";

        String id = parts[0];
        int newPrice = Integer.parseInt(parts[1]);

        Product product = inventory.get(id);
        if (product == null) return "PRODUCT_NOT_FOUND";
        if (newPrice < 0) return "REQUEST_PATTERN_INVALID";

        product.setPrice(newPrice);
        return "SUCCESS";
    }

    private String viewProduct(String id) {
        Product product = inventory.get(id.trim());
        if (product == null) return "PRODUCT_NOT_FOUND";

        return "Product ID: " + product.getId() +
                "\nName: " + product.getName() +
                "\nQuantity: " + product.getQuantity() +
                "\nPrice: " + product.getPrice();
    }

    private String removeProduct(String id) {
        return inventory.remove(id.trim()) != null ? "SUCCESS" : "PRODUCT_NOT_FOUND";
    }

    private String listProducts() {
        if (inventory.isEmpty()) return "NO_PRODUCTS_AVAILABLE";

        StringBuilder sb = new StringBuilder();
        for (Product p : inventory.values()) {
            sb.append(p.getId()).append(":").append(p.getName())
                    .append(":").append(p.getQuantity())
                    .append(":").append(p.getPrice()).append("\n");
        }
        return sb.toString().trim();
    }

    private String sortProducts(String field) {
        if (inventory.isEmpty()) return "NO_PRODUCTS_AVAILABLE";

        List<Product> list = new ArrayList<>(inventory.values());
        switch (field.trim()) {
            case "name":
                list.sort(Comparator.comparing(Product::getName));
                break;
            case "price":
                list.sort(Comparator.comparingInt(Product::getPrice));
                break;
            case "quantity":
                list.sort(Comparator.comparingInt(Product::getQuantity));
                break;
            default:
                return "REQUEST_PATTERN_INVALID";
        }

        StringBuilder sb = new StringBuilder();
        for (Product p : list) {
            sb.append(p.getId()).append(":").append(p.getName())
                    .append(":").append(p.getQuantity())
                    .append(":").append(p.getPrice()).append("\n");
        }
        return sb.toString().trim();
    }

    public int getProductCount() {
        return inventory.size();
    }

    public int getTotalInventoryValue() {
        return inventory.values().stream()
                .mapToInt(p -> p.getQuantity() * p.getPrice())
                .sum();
    }
}
