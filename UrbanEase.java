import java.util.Scanner;

class Customer
 {
	String name;
	String address;		
	double contactNumber;
	final int pass;

    Customer(String name, String address, double contactNumber, int pass)
	{
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
        this.pass = pass;
    }
}

class Booking 
{
    Customer customer;
    Service service;
    String dateTime;
    int serviceCharge;

    Booking(Customer customer, Service service, String dateTime, int serviceCharge) 
	{
        this.customer = customer;
        this.service = service;
        this.dateTime = dateTime;
        this.serviceCharge = serviceCharge;
    }
}

class Service 
{
    int id;
    String name;

    Service(int id, String name)
	{
        this.id = id;
        this.name = name;
    }
}

class Main 
{
    static Customer[] customers = new Customer[10];  // For storing customer details
    static Service[] services = new Service[10];      // For storing services
    static Booking[] bookings = new Booking[10];      // For storing bookings

    static int customerCount = 0;  // Keep track of how many customers are registered
    static int serviceCount = 0;   // Keep track of how many services are available
    static int bookingCount = 0;   // Keep track of how many bookings are made

    public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);

        while (true) 
		{
            System.out.println("--- Urban Company Service Booking System ---\n");
            System.out.println("WELCOME TO URBAN EASE COMPANY");
            System.out.println();
            System.out.println("1. Register Customer");
            System.out.println("2. Book Service");
            System.out.println("3. Exit\n");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (choice) 
			{
                case 1:
                    registerCustomer(sc);
                    break;
                case 2:
                    bookService(sc);
                    break;
                case 3:
                    System.out.println("Exiting system. Thanks for using urban ease company!");
                    return;  // Exit the program
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    static void registerCustomer(Scanner sc) 
	{
        if (customerCount >= customers.length) 
		{
            System.out.println("Available slot is full! Cannot register more customers.");
            return;
        }

        System.out.print("Enter customer name: ");
        String name = sc.nextLine();
        System.out.print("Enter address: ");
        String address = sc.nextLine();
        System.out.print("Enter contact number: ");
        double contactNumber = sc.nextDouble();
        System.out.print("Create a pass: (only in number) ");
        final int pass = sc.nextInt();
        
        customers[customerCount++] = new Customer(name, address, contactNumber, pass);
        System.out.println("Customer registered successfully!\n");
    }

  static void bookService(Scanner sc)
  {
		if (customerCount == 0) 
		{
			System.out.println("No customers registered. Please register a customer first.");
			return;
		}

		while (true) // Loop to allow multiple bookings
		{
			System.out.println("Select a customer for booking:");
			for (int i = 0; i < customerCount; i++) 
			{
				System.out.println((i + 1) + ". " + customers[i].name);
			}
			System.out.print("Select your customer (by number): ");
			int customerChoice = sc.nextInt();
			sc.nextLine();  // Consume newline

			if (customerChoice < 1 || customerChoice > customerCount) 
			{
				System.out.println("Invalid choice. Please try again.");
				return;
			}

			Customer selectedCustomer = customers[customerChoice - 1];

			// Password verification
			System.out.print("Enter your password: ");
			int enteredPassword = sc.nextInt();
			if (enteredPassword != selectedCustomer.pass) 
			{
				System.out.println("Wrong password. Booking cannot be processed.");
				return;
			}

			// Adding some predefined services for booking
			if (serviceCount == 0) {
				services[serviceCount++] = new Service(1, "Lawn Cleaning");
				services[serviceCount++] = new Service(2, "AC Service");
				services[serviceCount++] = new Service(3, "Home Cleaning");
				services[serviceCount++] = new Service(4, "Home Painting");
			}
            System.out.println("");
			System.out.println("Select a service:");
			for (int i = 0; i < serviceCount; i++) 
			{
				System.out.println((i + 1) + ". " + services[i].name);
			}
			System.out.print("Select your choice (by number): ");
			int serviceChoice = sc.nextInt();
			sc.nextLine();  // Consume newline

			if (serviceChoice < 1 || serviceChoice > serviceCount)
			{
				System.out.println("Invalid choice. Please try again.");
				return;
			}

			Service selectedService = services[serviceChoice - 1];

			// Logic to handle charges based on selected service
			int serviceCharge = 0;
			if (selectedService.name.equals("Home Cleaning") || selectedService.name.equals("Lawn Cleaning")) 
			{
				System.out.print("Enter the square feet for " + selectedService.name + ": ");
				int squareFeet = sc.nextInt();
				serviceCharge = 2 * squareFeet;
			} 
			else if (selectedService.name.equals("AC Service")) 
			{
				serviceCharge = 500;
			} 
			else if (selectedService.name.equals("Home Painting")) 
			{
				serviceCharge = 400;
			}

			System.out.println("Your service charge is: " + serviceCharge + " rupees.");

			// Ask for the date and time and verify it
			String dateTime;
			while (true)
			{
				System.out.print("Enter date and time for service booking (e.g., 2025-01-26 10:00): ");
				dateTime = sc.nextLine();
				if (isValidDateTime(dateTime)) 
				{
					break;
				} 
				else 
				{
					System.out.println("Invalid date-time format. Please use 'YYYY-MM-DD HH:MM'.");
				}
			}

			if (bookingCount >= bookings.length) 
			{
				System.out.println("Booking slots are full! Cannot make more bookings.");
				return;
			}

			bookings[bookingCount++] = new Booking(selectedCustomer, selectedService, dateTime, serviceCharge);
			System.out.println("Service booked successfully!");

           // Print all details after booking
			printAllDetails();
			
			// Ask if the user wants to book another service
			System.out.print("Do you want to book another service? (yes/no): ");
			String anotherBooking = sc.nextLine().trim().toLowerCase();
			if (!anotherBooking.equals("yes")) {
				break;  // Exit the loop if the user doesn't want another booking
				
			
			}
		}
    }


    static boolean isValidDateTime(String dateTime) 
	{
    String[] dateTimeParts = dateTime.split(" ");
    if (dateTimeParts.length != 2) 
	{
        return false;
    }

    String date = dateTimeParts[0];
    String time = dateTimeParts[1];

    // Validate date in YYYY-MM-DD format
    String[] dateParts = date.split("-");
    if (dateParts.length != 3) 
	{
        return false;
    }

    int year, month, day;
    // Check if date parts are numeric
    if (!isNumeric(dateParts[0]) || !isNumeric(dateParts[1]) || !isNumeric(dateParts[2])) 
	{
        return false;
    }

    year = Integer.parseInt(dateParts[0]);
    month = Integer.parseInt(dateParts[1]);
    day = Integer.parseInt(dateParts[2]);

    if (year < 2025 || year > 9999) 
	{
        return false;
    }

    if (month < 1 || month > 12) 
	{
        return false;
    }

    if (day < 1 || day > 31) 
	{
        return false;
    }

    // Validate time in HH:MM format
    String[] timeParts = time.split(":");
    if (timeParts.length != 2) 
	{
        return false;
    }

    int hour, minute;
    // Check if time parts are numeric
    if (!isNumeric(timeParts[0]) || !isNumeric(timeParts[1]))
	{
        return false;
    }

    hour = Integer.parseInt(timeParts[0]);
    minute = Integer.parseInt(timeParts[1]);

    if (hour < 0 || hour > 23) 
	{
        return false;
    }

    if (minute < 0 || minute > 59) 
	{
        return false;
    }

    return true;
}

// Helper method to check if a string is numeric
static boolean isNumeric(String str) 
{
    for (char c : str.toCharArray()) 
	{
        if (!Character.isDigit(c))
		{
            return false;
        }
    }
    return true;
}


    // Method to print all details of customers, services, and bookings
    static void printAllDetails() 
	{
        for (int i = 0; i < bookingCount; i++) 
		{
            System.out.println((i + 1) + ". Customer: " + bookings[i].customer.name);
            System.out.println("   Service: " + bookings[i].service.name);
            System.out.println("   Date & Time: " + bookings[i].dateTime);
            System.out.println("   Your service charge is: " + bookings[i].serviceCharge + " rupees.");
            System.out.println("   ...Thanx for booking...\n");
        }
    }
}