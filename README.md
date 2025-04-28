# StockifyManit 📦

A command-line-based Inventory Management System designed for e-commerce platforms.  
Stockify lets users add, update, view, list, sort, and remove products with real-time inventory tracking — all managed through simple commands.

---

## 🚀 Features
- Add products with validation of product ID, name, quantity, and price.
- Update product quantity and price dynamically.
- View product details on demand.
- Remove products from the inventory.
- List all products or sort products by ID, name, quantity, or price.
- Gracefully exit and display total inventory summary.
- Strict input validation to handle incorrect patterns.
- Built using Core Java and OOPs concepts.

---

## 🛠️ Tech Stack
- Java 17
- Gradle (build tool)
- IntelliJ IDEA (recommended IDE)

---

## 📂 Project Structure
- `src/main/java/com/stockify/platform/App.java` – Main application entry point (Command-Line Interface).
- `build.gradle` – Project build configuration.

---

## 🧩 Supported Commands
| Command | Description |
|:---|:---|
| `ADD_PRODUCT <product_id> <product_name> <quantity> <price>` | Add a new product to inventory. |
| `UPDATE_QUANTITY <product_id> <quantity>` | Update the quantity of an existing product. |
| `UPDATE_PRICE <product_id> <price>` | Update the price of an existing product. |
| `VIEW_PRODUCT <product_id>` | View detailed information about a specific product. |
| `REMOVE_PRODUCT <product_id>` | Remove a product from inventory. |
| `LIST_PRODUCTS` | List all products in insertion order. |
| `SORT_PRODUCTS <by_field>` | Sort products by `id`, `name`, `quantity`, or `price`. |
| `EXIT` | Show total inventory summary and exit the application. |

---

## 📦 How to Run the Application

### 1. Clone the Repository
```bash
git clone https://github.com/manitcodes247/StockifyManit.git
