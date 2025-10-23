/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ticketing;
 import java.util.*;
/**
 *
 * @author User
 */
public class Ticketing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            final double BASE_PRICE = 200.0;
            
            while (true) {
                System.out.print("\nEnter customer's age (or type 'exit' to quit): ");
                String ageInput = input.nextLine();
                
                // Exit condition
                if (ageInput.equalsIgnoreCase("exit")) {
                    System.out.println("Thank you for using the Cinema Ticketing System!");
                    break;
                }
                
                int age = Integer.parseInt(ageInput);
                
                System.out.print("Enter day of the week: ");
                String day = input.nextLine().trim();
                
                System.out.print("Enter number of tickets: ");
                int numTickets = Integer.parseInt(input.nextLine());
                
                double ticketPrice = BASE_PRICE;
                String discountApplied = "None";
                
                // --- Determine the best applicable discount ---
                if (age < 7) {
                    ticketPrice = 0;
                    discountApplied = "Free ticket (below 7 years old)";
                } else if (day.equalsIgnoreCase("Wednesday")) {
                    ticketPrice = BASE_PRICE * 0.5;
                    discountApplied = "50% Wednesday discount";
                } else if (age >= 60) {
                    ticketPrice = BASE_PRICE * 0.8;
                    discountApplied = "20% Senior Citizen discount";
                }
                
                // --- Compute total price ---
                double total = ticketPrice * numTickets;
                
                // --- Apply extra discount if total > 1000 ---
                if (total > 1000) {
                    total *= 0.9; // 10% discount
                    discountApplied += " + Extra 10% discount (₱1000+ purchase)";
                }
                
                // --- Display result ---
                System.out.println("\n========== TICKET SUMMARY ==========");
                System.out.printf("Ticket breakdown: %d × ₱%.2f%n", numTickets, ticketPrice);
                System.out.println("Discount applied: " + discountApplied);
                System.out.printf("Final amount to pay: ₱%.2f%n", total);
                
                // --- Check minimum purchase ---
                if (total < 200 && ticketPrice > 0) {
                    System.out.println("Note: Minimum purchase not reached.");
                }
                
                System.out.println("====================================");
            }
        }
     }
}
