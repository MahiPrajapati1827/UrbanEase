# 🏠 UrbanEase – Service Booking System

UrbanEase is a Java-based console application designed to simplify customer registration and home-service booking.

## 📌 Project Overview

The application allows users to:

* Register as a customer
* Store customer details
* Verify customer password
* Select a home service
* Calculate service charges
* Schedule a service
* Validate booking date and time
* View booking details
* Make multiple service bookings

## ✨ Features

### 👤 Customer Registration

* Customer name
* Address
* Contact number
* Password

### 🔐 Password Verification

Customers must enter the correct password before booking a service.

### 🛠️ Available Services

1. Lawn Cleaning
2. AC Service
3. Home Cleaning
4. Home Painting

### 💰 Service Charges

| Service       |         Charge |
| ------------- | -------------: |
| Lawn Cleaning | ₹2 per sq. ft. |
| Home Cleaning | ₹2 per sq. ft. |
| AC Service    |           ₹500 |
| Home Painting |           ₹400 |

### 📅 Date & Time Validation

The application accepts booking dates in:

`YYYY-MM-DD HH:MM`

Example:

`2026-09-25 10:00`

The program validates the year, month, day, hour, and minutes.

## 💻 Technologies Used

* Java
* Core Java
* Object-Oriented Programming
* Java Scanner
* Arrays
* Classes and Objects
* Constructors
* Methods
* Conditional Statements
* Loops

## 🏗️ Project Structure

```text
UrbanEase/
│
├── UrbanEase.java
└── README.md
```

### Java Classes

**Customer**
Stores customer name, address, contact number, and password.

**Service**
Stores service ID and service name.

**Booking**
Stores customer, selected service, date/time, and service charge.

**Main**
Contains the main menu, customer registration, service booking, validation, and display logic.

## 🔄 Application Flow

```text
Start
  ↓
Register Customer
  ↓
Enter Customer Details
  ↓
Book Service
  ↓
Select Customer
  ↓
Password Verification
  ↓
Select Service
  ↓
Calculate Service Charge
  ↓
Enter Date & Time
  ↓
Validate Date & Time
  ↓
Confirm Booking
  ↓
Display Booking Details
  ↓
Book Another Service / Exit
```

## ▶️ How to Run

### 1. Compile

```bash
javac UrbanEase.java
```

### 2. Run

```bash
java Main
```

## 🖥️ Sample Output

```text
--- Urban Company Service Booking System ---

WELCOME TO URBAN EASE COMPANY

1. Register Customer
2. Book Service
3. Exit

Choose an option: 1

Enter customer name: Mahi
Enter address: Ahmedabad
Enter contact number: 9876543210
Create a pass: (only in number) 1234

Customer registered successfully!
```

## 🎯 Learning Outcomes

This project demonstrates practical use of:

* Java OOP concepts
* Classes and Objects
* Constructors
* Arrays of Objects
* Static variables and methods
* Final variables
* User input handling
* Password verification
* Input validation
* Service charge calculation
* Menu-driven programming

## 🚀 Future Improvements

Possible future enhancements include:

* MySQL database integration
* Admin dashboard
* Booking history
* Booking cancellation
* Online payment
* Service provider management
* Java Swing/JavaFX interface
* Web-based interface

## 👩‍💻 Author

**Mahi Prajapati**

Computer Science & Engineering Student

### Connect With Me

* GitHub: [MahiPrajapati1827](https://github.com/MahiPrajapati1827)
* LinkedIn: [Mahi Prajapati](https://www.linkedin.com/in/mahi-prajapati-1345523a/)

## 📄 License

This project is created for educational and academic purposes.
