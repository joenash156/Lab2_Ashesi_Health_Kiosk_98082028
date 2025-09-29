// Project: Ashesi Health Kiosk
// Author: Joshua Adjei
// Date: Sep 28, 2025

import java.util.Scanner;

public class HealthKiosk {
  public static void main(String[] args) {
    System.out.println(); // Print a new line

    System.out.println("---- Welcome to Ashesi Health Kiosk ----");
    System.out.println("=========================================");
    System.out.println(); // Print a new line

    // Declare neccessary variables
    char serviceCode;
    String service = "";
    
    // Use try-with-resources to open and close Scanner
    try(Scanner input = new Scanner(System.in)) {

      // --- Task  1

      System.out.print("Enter service code (P / L / T / C): ");
      serviceCode = input.next().toUpperCase().charAt(0);

      // Give out service based on code entered
      switch(serviceCode) {
        
        case 'P' -> {
          service = "Pharmacy Desk";
          System.out.printf("Go to: %s", service);
          break;
        }
        case 'L' -> {
          service = "Lab Desk";
          System.out.printf("Go to: %s", service);
          System.out.println(); // Print a new line
          break;
        }
        case 'T' -> {
          service = "Triage Desk";
          System.out.printf("Go to: %s", service);
          System.out.println(); // Print a new line
          break;
        }
        case 'C' -> {
          service = "Counseling Desk";
          System.out.printf("Go to: %s", service);
          System.out.println(); // Print a new line
          break;
        }
        default -> {
          System.out.printf("Invalid service code");
          System.out.println(); // Print a new line
          return;
        }
      } // End of switch in task 1
    

      // --- Task 2

      double metricValue = 0.0;
      double roundedMetric = 0.0;

      if(service.equals("Triage Desk")) {
        System.out.print("Enter health metric (1: BMI, 2: Dosage, 3: Trig): ");
        int option = input.nextInt();

        System.out.println(); // Print a new line

        // Check for the options
        switch(option) {
          case 1 -> {
            
            String bmicategory;

            System.out.println("--- Body Mass Index Calculator ---");
            System.out.println("===================================");

            System.out.print("Enter weight(Kg): ");
            double weight = input.nextDouble();
            System.out.print("Enter height(m): ");
            double height = input.nextDouble();

            System.out.println(); //

            // Calculate BMI
            metricValue = weight / (Math.pow(height, 2));
            // double bmi = weight / (Math.pow(height, 2));
            double bmiRounded = Math.round(metricValue * 10) / 10.0;
            roundedMetric = Math.round(metricValue);
            
            // Check for the category of the BMI
            if(bmiRounded < 18.5) {
              bmicategory = "Underweight";
            } else if(bmiRounded >= 18.5 && bmiRounded <= 24.9) {
              bmicategory = "Normal";
            } else if(bmiRounded >= 25.0 && bmiRounded <= 29.9) {
              bmicategory = "Overweight";
            } else {
              bmicategory = "Obese";
            }

            // Option A output
            System.out.printf("Weight: %.2f m %n", weight);
            System.out.printf("Height: %.2fkg %n", height);
            System.out.printf("BMI: %.1f  Category: %s %n", bmiRounded, bmicategory);

            metricValue = bmiRounded;
            break;


          } // End of case for option 1
          case 2 -> {

            System.out.println("--- Dosage round-up ---");
            System.out.println("========================");

            System.out.print("Enter required dosage (mg): ");
            double dosage = input.nextDouble();
            int tablets = (int) (Math.ceil(dosage / 250.0));

            System.out.printf("Tablets required: %d %n", tablets);
            break;

    
          }
          case 3 -> {
          System.out.println("--- Simple Trig Helper ---");
          System.out.println("==========================");

          System.out.print("Enter angle (degrees): ");
          double angleDeg = input.nextDouble();
          double angleRad = Math.toRadians(angleDeg);

          double sinValue = Math.round(Math.sin(angleRad) * 1000) / 1000.0;
          double cosValue = Math.round(Math.cos(angleRad) * 1000) / 1000.0;

          System.out.printf("sin angle: %.3f %n", sinValue);
          System.out.printf("cos angle: %.3f %n", cosValue);

          break;

          }
          default -> {
            System.out.println("Invalid input");
            return;
          }
        }
        System.out.println(); // Print a new line


      } // End of if in task 2

      // --- Task 3

        // Generate random uppercase letter (A - Z) using the Unicode
        char randChar = (char) ('A' + (int) (Math.random() * 26));

        // Generate digits 3 - 9 without a loop
        int randDigit1 = 3 + (int)(Math.random() * 7);
        int randDigit2 = 3 + (int)(Math.random() * 7);
        int randDigit3 = 3 + (int)(Math.random() * 7);
        int randDigit4 = 3 + (int)(Math.random() * 7);

        // Form the short ID
        String id = "" + randChar + randDigit1 + randDigit2 + randDigit3 + randDigit4;
        
        System.out.printf("Generated ID: %s", id);

        System.out.println(); // Print a new line

        // Validate Short ID
        if(id.length() != 5) {
          System.out.println("Invalid: Short ID most be 5 characters");
        } else if(!Character.isLetter(id.charAt(0))) {
          System.out.println("Invalid: First character must be letter");
        } else if(!Character.isDigit(id.charAt(1)) || !Character.isDigit(id.charAt(2)) || !Character.isDigit(id.charAt(3))) {
          System.out.println("Invalid: Last four characters must be digits");
        } else {
          System.out.println("ID OK");
        }

      
      // --- Task 4

      System.out.println("");

      System.out.print("Enter your first name: ");
      String firstName = input.next();
      char baseChar = Character.toUpperCase(firstName.charAt(0));
      char shifted = (char)('A' + (baseChar - 'A' + 2) % 26);

      String lastTwo = id.substring(3); // last 2 characters
      String displayCode = shifted + lastTwo + "-" + (int)roundedMetric;

      System.out.println("Display Code: " + displayCode);


      // --- Task 5
      String summary = "Summary: " + service + " | ID = " + id;
      if(service.equals("TRIAGE")) {
          summary += " | BMI = " + metricValue;
      }
      summary += " | Code = " + displayCode;

      System.out.println(); // Print a new line

      System.out.println("--- Summary ---");

      System.out.printf("%s %n", summary);


      System.out.println();
      System.out.println("Thank you");
      System.out.println("");// Print a new line
    } // End of try-with-resources block

  } // End of main method

} // End of HealthKiosk class
