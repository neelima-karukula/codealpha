import java.util.ArrayList;
import java.util.Scanner;

// Stock Class
class Stock {

    String name;
    double price;

    // Constructor
    Stock(String name, double price) {

        this.name = name;
        this.price = price;
    }
}

// Main Class
public class StockTradingPlatform {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // User Balance
        double balance = 10000;

        // Available Stocks
        ArrayList<Stock> marketStocks = new ArrayList<>();

        marketStocks.add(new Stock("TCS", 3500));
        marketStocks.add(new Stock("Infosys", 1400));
        marketStocks.add(new Stock("Wipro", 500));
        marketStocks.add(new Stock("HCL", 1200));

        // User Portfolio
        ArrayList<Stock> portfolio = new ArrayList<>();

        while (true) {

            System.out.println("\n===== STOCK TRADING SYSTEM =====");

            System.out.println("1. View Stocks");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. View Balance");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                // View Stocks
                case 1:

                    System.out.println("\n===== AVAILABLE STOCKS =====");

                    for (Stock s : marketStocks) {

                        System.out.println(
                                s.name + " - ₹" + s.price
                        );
                    }

                    break;

                // Buy Stock
                case 2:

                    sc.nextLine();

                    System.out.print("Enter stock name to buy: ");

                    String buyName = sc.nextLine();

                    boolean bought = false;

                    for (Stock s : marketStocks) {

                        if (s.name.equalsIgnoreCase(buyName)) {

                            bought = true;

                            if (balance >= s.price) {

                                balance = balance - s.price;

                                portfolio.add(s);

                                System.out.println(
                                        "Stock purchased successfully!"
                                );

                                System.out.println(
                                        "Remaining Balance: ₹" + balance
                                );

                            } else {

                                System.out.println(
                                        "Not enough balance."
                                );
                            }
                        }
                    }

                    if (!bought) {

                        System.out.println("Stock not found.");
                    }

                    break;

                // Sell Stock
                case 3:

                    sc.nextLine();

                    System.out.print("Enter stock name to sell: ");

                    String sellName = sc.nextLine();

                    boolean sold = false;

                    for (int i = 0; i < portfolio.size(); i++) {

                        Stock s = portfolio.get(i);

                        if (s.name.equalsIgnoreCase(sellName)) {

                            balance = balance + s.price;

                            portfolio.remove(i);

                            System.out.println(
                                    "Stock sold successfully!"
                            );

                            System.out.println(
                                    "Updated Balance: ₹" + balance
                            );

                            sold = true;

                            break;
                        }
                    }

                    if (!sold) {

                        System.out.println(
                                "Stock not in portfolio."
                        );
                    }

                    break;

                // View Portfolio
                case 4:

                    System.out.println("\n===== YOUR PORTFOLIO =====");

                    if (portfolio.size() == 0) {

                        System.out.println("No stocks purchased.");

                    } else {

                        for (Stock s : portfolio) {

                            System.out.println(
                                    s.name + " - ₹" + s.price
                            );
                        }
                    }

                    break;

                // View Balance
                case 5:

                    System.out.println(
                            "\nCurrent Balance: ₹" + balance
                    );

                    break;

                // Exit
                case 6:

                    System.out.println("Thank You!");

                    sc.close();

                    System.exit(0);

                // Invalid Choice
                default:

                    System.out.println("Invalid choice.");
            }
        }
    }
}