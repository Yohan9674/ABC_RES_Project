ABC Restaurant Web Application

01 Project Overview
   ABC Restaurant is a popular restaurant chain located in various cities across Sri Lanka. The restaurant management has decided to expand its operations by leveraging modern technology, launching an interactive web-based application to streamline services and enhance the customer experience.

   This system is designed to provide customers with a seamless online experience, offering services such as online reservations, viewing services, and submitting queries. Admins and restaurant staff can manage bookings, respond to queries, and process payments through the web platform. The system ensures differential access rights for users, a user-friendly interface, and reports that add value to the overall business.

02 Features
   User-Specific Features
   2.1 Admin:

   Manage user access and roles.
   Monitor restaurant performance through generated reports.
   Manage reservations and customer queries.

   2.2 Restaurant Staff:

   Manage online reservations (dine-in or delivery).
   Respond to customer queries.
   Process online payments (cash/credit).

   2.3 Customers:

   Register on the platform and log in to access services.
   Make online reservations for dining or delivery.
   Search and view hospitality services, rates, and availability.
   Submit queries directly to the restaurant.


03 Key System Features
Online Reservation System: Allows customers to book tables or delivery services directly through the platform.
Search and View Services: Customers can browse available hospitality services, view facilities, and check availability.
Submit Queries: Customers can send inquiries regarding services, which staff or admins can respond to.
Dynamic Reports: The system generates daily/monthly sales reports to assist in business analysis.
Interactive Gallery: Displays images of the restaurant, services, and events to showcase offerings.


04 Technologies Used
Backend: Java (Spring Boot, Hibernate)
Frontend: HTML, CSS, JavaScript (React or plain JavaScript)
Database: MySQL
JUnit: For unit testing
IDE: Eclipse


05 System Flow
User Registration and Login: Users register on the website and log in to access their respective dashboards (Admin, Staff, Customer).
Reservations: Customers can check availability and make reservations for dining or delivery.
Queries: Customers can submit queries, which are handled by staff or admins.
Payments: Payments can be processed online using cash or credit.
Reports: Admins can view daily and monthly sales reports.



Database Query 

CREATE TABLE `cart_items` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int NOT NULL,
  `menu_item_id` int NOT NULL,
  `quantity` int DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `customer_id` (`customer_id`),
  KEY `menu_item_id` (`menu_item_id`),
  CONSTRAINT `cart_items_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`),
  CONSTRAINT `cart_items_ibfk_2` FOREIGN KEY (`menu_item_id`) REFERENCES `menu_items` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
;


CREATE TABLE `contact_us` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `subject` varchar(255) NOT NULL,
  `message` text NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
;

CREATE TABLE `customers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
)

CREATE TABLE `menu_items` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`)
)


CREATE TABLE `order_items` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_id` int NOT NULL,
  `item_id` int NOT NULL,
  `quantity` int NOT NULL,
  `total_price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  KEY `item_id` (`item_id`),
  CONSTRAINT `order_items_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`) ON DELETE CASCADE,
  CONSTRAINT `order_items_ibfk_2` FOREIGN KEY (`item_id`) REFERENCES `menu_items` (`id`) ON DELETE CASCADE
) 

CREATE TABLE `orders` (
  `id` int NOT NULL AUTO_INCREMENT,
  `total_price` decimal(10,2) NOT NULL,
  `order_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
)



06 Reports
Daily Sales Report: Shows total sales for a specific day.
Monthly Sales Report: Provides an overview of monthly performance and revenue.
These reports help management make informed decisions regarding restaurant performance.
