import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);
        try {
            final String origColor = "\u001B[0m";
            final String redColor = "\u001B[31m";
            final String greenColor = "\u001B[32m";
            int choice;

            do {
                out.println("------------------GWA CALCULATOR------------------");
                out.println("""
                        What do you want to do?
                         1. Calculate GWA for a semester.
                         2. Calculate GWA for entire academic year.
                         3. Calculate GWA for entire college life.
                         0. Exit.
                        """);
                out.print("Enter your choice: ");
                choice = scan.nextInt();
                switch (choice) {
                    case 1 -> {
                        int semester;
                        float totalSubjects, unitPerSubject, totalUnits = 0, gradePerSubject, totalGrade = 0, gwa;
                        out.print("What semester is this (1 or 2)? ");
                        semester = scan.nextInt();
                        String currentSemester = (semester == 1) ? "\nCalculate GWA for First Semester \uD83D\uDC47" : "\nCalculate GWA for Second Semester \uD83D\uDC47";
                        out.println(currentSemester + "\n");

                        out.print("Enter total number of subjects for this semester: ");
                        totalSubjects = scan.nextFloat();
                        out.println(redColor + "Note: Please enter the unit and grade for each subject alternatively." + origColor);
                        for (int i = 0; i < totalSubjects; i++) {
                            out.print("Enter unit for subject " + (i + 1) + ": ");
                            unitPerSubject = scan.nextFloat();
                            totalUnits += unitPerSubject;
                            for (int j = i; j < totalSubjects;) {
                                out.print("Enter grade for subject " + (j + 1) + ": ");
                                gradePerSubject = scan.nextFloat();
                                totalGrade += unitPerSubject * gradePerSubject;
                                break;
                            }
                        }

                        out.println("\nTotal number of units for this semester: " + (int) (totalUnits));
                        out.println("Total Grade x Total Units formula for this semester: " + String.format("%.3f", totalGrade));

                        gwa = totalGrade / totalUnits;
                        out.println("\nYour GWA for this semester is " + (greenColor + String.format("%.3f", gwa) + origColor) + ".\n");
                    }
                    case 2 -> {
                        String acadYear;
                        int semesters;
                        float gwaFirstSem, gwaSecondSem, totalGWA;

                        out.print("Enter Academic Year (e.g. 2021-2022): ");
                        acadYear = scan.next();

                        out.print("How many semesters did you take for the academic year " + acadYear + "? ");
                        semesters = scan.nextInt();
                        if (semesters < 2) {
                            out.println(redColor + "You must have taken at least two semesters to calculate your GWA for the entire academic year.\n" + origColor);
                            break;
                        }

                        out.print("Enter GWA for First Semester (3 decimal places only): ");
                        gwaFirstSem = scan.nextFloat();
                        out.print("Enter GWA for Second Semester (3 decimal places only): ");
                        gwaSecondSem = scan.nextFloat();

                        totalGWA = (gwaFirstSem + gwaSecondSem) / semesters;
                        out.println("\nYour GWA for the Academic Year " + acadYear + " is " + (greenColor + String.format("%.3f", totalGWA) + origColor) + ".\n");

                    }
                    case 3 -> {
                        String degree, yearLevel1, yearLevel2, yearLevel3, yearLevel4;
                        int collegeYears;
                        float firstGWA, secondGWA = 0, thirdGWA = 0, fourthGWA = 0, totalGWA;

                        out.print("What is/was your degree program (e.g. BSIT, BSCS, BSCPE)? ");
                        degree = scan.next();
                        out.print("How many years did you spend in college? ");
                        collegeYears = scan.nextInt();

                        if (collegeYears == 1) {
                            yearLevel1 = "First";
                            out.print("Enter GWA for " + yearLevel1 + " Year (3 decimal places only): ");
                            firstGWA = scan.nextFloat();
                        } else if (collegeYears == 2) {
                            yearLevel1 = "First";
                            yearLevel2 = "Second";
                            out.print("Enter GWA for " + yearLevel1 + " Year (3 decimal places only): ");
                            firstGWA = scan.nextFloat();
                            out.print("Enter GWA for " + yearLevel2 + " Year (3 decimal places only): ");
                            secondGWA = scan.nextFloat();
                        } else if (collegeYears == 3) {
                            yearLevel1 = "First";
                            yearLevel2 = "Second";
                            yearLevel3 = "Third";
                            out.print("Enter GWA for " + yearLevel1 + " Year (3 decimal places only): ");
                            firstGWA = scan.nextFloat();
                            out.print("Enter GWA for " + yearLevel2 + " Year (3 decimal places only): ");
                            secondGWA = scan.nextFloat();
                            out.print("Enter GWA for " + yearLevel3 + " Year (3 decimal places only): ");
                            thirdGWA = scan.nextFloat();
                        } else if (collegeYears == 4) {
                            yearLevel1 = "First";
                            yearLevel2 = "Second";
                            yearLevel3 = "Third";
                            yearLevel4 = "Fourth";
                            out.print("Enter GWA for " + yearLevel1 + " Year (3 decimal places only): ");
                            firstGWA = scan.nextFloat();
                            out.print("Enter GWA for " + yearLevel2 + " Year (3 decimal places only): ");
                            secondGWA = scan.nextFloat();
                            out.print("Enter GWA for " + yearLevel3 + " Year (3 decimal places only): ");
                            thirdGWA = scan.nextFloat();
                            out.print("Enter GWA for " + yearLevel4 + " Year (3 decimal places only): ");
                            fourthGWA = scan.nextFloat();
                        } else {
                            out.println(redColor + "You must have spent at least a year or more in college to calculate your GWA for your entire college life.\n" + origColor);
                            break;
                        }
                        totalGWA = (firstGWA + secondGWA + thirdGWA + fourthGWA) / collegeYears;
                        out.println("\nAs a " + degree + " student, your GWA for your entire college life is " + (greenColor + String.format("%.3f", totalGWA) + origColor) + "!\n");
                    }
                    case 0 -> out.println("\nExiting...\n");
                    default -> out.println(redColor + "\nPlease choose between 0 to 3 only." + origColor + "\n");
                }
            } while (choice != 0);
        } catch(InputMismatchException e) {
            out.println("\nYou are only allowed to enter the number of your preferred choice.");
        } finally {
            out.println("Thank you for using the GWA Calculator!");
            scan.close();
        }
    }
}