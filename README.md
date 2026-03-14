# ECommerceSystem (Core Java)

A simple **console-based e-commerce simulation** built with **Core Java and OOP principles**.
The system allows users to register, browse products, manage a cart, and place orders through a menu-driven interface.

## Features

* User registration and login
* Admin product management
* Product search and listing
* Add/remove items from cart
* Order placement
* Order history tracking

## Tech Used

* Java (Core Java)
* OOP (Encapsulation, Composition)
* Collections (`List`, `ArrayList`)
* Console-based UI

## Project Structure

```text
Core
 ├─ Product
 ├─ Cart
 ├─ CartItem
 ├─ Order
 └─ User

Service
 └─ ECommerceSystem

Execution
 └─ Main
```

## Example Flow

```
Register → Login → View Products → Add to Cart → Place Order
```

The main system logic is handled by the **ECommerceSystem service class**, which coordinates users, products, carts, and orders. 

## Run

Compile and run `Main.java`:

```bash
javac Main.java
java Main
```

The program launches an interactive menu where users can register, login, shop, and place orders.

## Purpose

This project demonstrates:

* Object-oriented design
* Separation of concerns
* Basic system architecture for e-commerce workflows
