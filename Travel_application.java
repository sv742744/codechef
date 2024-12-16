import java.util.*;
class Travel_application {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Customer Name:");
        String name = sc.nextLine();
        System.out.println("Enter Customer ID:");
        int id = sc.nextInt();
        TravelApplication t = new TravelApplication(name, id);
        t.menu();
    }
}

class TravelApplication {
    String cname;
    int cid;
    int balance;
    int previoustransaction;
    String lastFlightBooking;
    int flightExpense;
    String lastHotelBooking;
    int hotelExpense;

    TravelApplication(String cname, int cid) {
        this.cname = cname;
        this.cid = cid;
        this.balance = 10000; // Starting balance for the sake of example
        this.previoustransaction = 0;
        this.lastFlightBooking = "";
        this.flightExpense = 0;
        this.lastHotelBooking = "";
        this.hotelExpense = 0;
    }

    public void addmoney(int amount) {
        if (amount > 0) {
            balance += amount;
            previoustransaction = amount;
        }
    }

    public void spendedmoney(int amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                previoustransaction = -amount;
            } else {
                System.out.println("Your balance is insufficient");
            }
        }
    }

    public void bookFlight(String from, String to, int cost) {
        if (cost <= balance) {
            lastFlightBooking = "Flight from " + from + " to " + to;
            flightExpense = cost;
            spendedmoney(cost);
        } else {
            System.out.println("Insufficient balance for flight booking.");
        }
    }

    public void bookHotel(String hotel, int cost) {
        if (cost <= balance) {
            lastHotelBooking = "Hotel booking at " + hotel;
            hotelExpense = cost;
            spendedmoney(cost);
        } else {
            System.out.println("Insufficient balance for hotel booking.");
        }
    }

    public void getPreviousTransactions() {
        if (previoustransaction > 0) {
            System.out.println(" money is added : " + previoustransaction);
        } else if (previoustransaction < 0) {
            System.out.println("money is spended : " + (-previoustransaction));
        } else {
            System.out.println("No transactions occurred");
        }
    }

    public void viewBookings() {
        System.out.println("=======================");
        System.out.println("Last Flight Booking: " + lastFlightBooking + " Cost: " + flightExpense);
        System.out.println("Last Hotel Booking: " + lastHotelBooking + " Cost: " + hotelExpense);
        System.out.println("=======================");
    }

    void menu() {
        System.out.println("Enter Option :-");
        char option = '\0';
        Scanner sc = new Scanner(System.in);
        System.out.println("Your name is: " + cname);
        System.out.println("Your cid is: " + cid);
        System.out.println(" A. add money ");
        System.out.println(" B. spend money");
        System.out.println(" C. Previous transaction");
        System.out.println(" D. Total Balance");
        System.out.println(" E. Book Flight");
        System.out.println(" F. Book Hotel");
        System.out.println(" G. View Bookings");
        System.out.println(" H. Exit");
        do {
            option = Character.toUpperCase(sc.next().charAt(0));
            switch (option) {
                case 'A':
                    System.out.println("Enter amount :");
                    int amount = sc.nextInt();
                    System.out.println("=======================");
                    addmoney(amount);
                    System.out.println("Amount added : " + previoustransaction);
                    System.out.println("=======================");
                    break;
                case 'B':
                    System.out.println("Enter amount : ");
                    int amount1 = sc.nextInt();
                    System.out.println("=======================");
                    spendedmoney(amount1);
                    System.out.println("Amount spended: " + (-previoustransaction));
                    System.out.println("=======================");
                    break;
                case 'C':
                    System.out.println("=======================");
                    System.out.println("Your previous transaction :");
                    getPreviousTransactions();
                    System.out.println("=======================");
                    break;
                case 'D':
                    System.out.println("=======================");
                    System.out.println("Total Balance is: " + balance);
                    System.out.println("=======================");
                    break;
                case 'E':
                    sc.nextLine(); // Consume newline
                    System.out.println("Enter starting location :");
                    String from = sc.nextLine();
                    System.out.println("Enter destination location :");
                    String to = sc.nextLine();
                    System.out.println("Enter cost of flight :");
                    int flightCost = sc.nextInt();
                    System.out.println("your flight booking is confirmed...");
                    System.out.println("=======================");
                    bookFlight(from, to, flightCost);
                    System.out.println("Remaining Balance: " + balance);
                    System.out.println("=======================");
                    break;
                case 'F':
                    sc.nextLine(); // Consume newline
                    System.out.println("Enter hotel name :");
                    String hotel = sc.nextLine();
                    System.out.println("Enter cost of hotel booking :");
                    int hotelCost = sc.nextInt();
                    System.out.println("your hotel booking is confirmed...");
                    System.out.println("=======================");
                    bookHotel(hotel, hotelCost);
                    System.out.println("Remaining Balance: " + balance);
                    System.out.println("=======================");
                    break;
                case 'G':
                    viewBookings();
                    break;
                case 'H':
                    System.out.println("=======================");
                    System.out.println("Exiting your application ");
                    System.out.println("THANKING "+cname+" FOR USING OUR WEBSITE");
                    break;
                default:
                    System.out.println("Invalid Option");
                    break;
            }
        } while (option != 'H');
    }
}
/*
Enter Customer Name:
sumanthi r
Enter Customer ID:
3053
Enter Option :-
Your name is: sumanthi r
Your cid is: 3053
 A. add money
 B. spend money
 C. Previous transaction
 D. Total Balance
 E. Book Flight
 F. Book Hotel
 G. View Bookings
 H. Exit
a
Enter amount :
50000
=======================
Amount added : 50000
=======================
e
Enter starting location :
india
Enter destination location :
bangkok
Enter cost of flight :
12742
your flight is booked...
=======================
Remaining Balance: 47258
=======================
f
Enter hotel name :
shasi   
Enter cost of hotel booking :
5000
your hotel is booked...
=======================
Remaining Balance: 42258
=======================
g
=======================
Last Flight Booking: Flight from india to bangkok Cost: 12742
Last Hotel Booking: Hotel booking at shasi Cost: 5000
=======================
c
=======================
Your previous transaction :
money is spended : 5000
=======================
b
Enter amount : 
10000
=======================
Amount spended: 10000
=======================
d
=======================
Total Balance is: 32258
=======================
c
=======================
Your previous transaction :
money is spended : 10000
=======================
*/
