package project1;

import java.util.Scanner;

public class InputValidator
{
    private Scanner scanner;

    public InputValidator(Scanner scanner)
    {
        this.scanner = scanner;
    }


    public int getValidIntegerInput(String prompt)
    {
        while (true)
        {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            try
            {
                int value = Integer.parseInt(input);
                if (value < 1)
                {
                    System.out.println(
                        "Sets and reps must be positive numbers. Please enter a value of 1 or higher.");
                    continue;
                }
                return value;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Input must be an integer.");
            }
        }
    }


    public double getValidDoubleInput(String prompt)
    {
        while (true)
        {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            try
            {
                double value = Double.parseDouble(input);
                if (value < 0)
                {
                    System.out.println(
                        "Weight cannot be negative. Please enter 0 or higher.");
                    continue;
                }
                return value;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Input must be numerical.");
            }
        }
    }


    public String getValidStringInput(String prompt)
    {
        while (true)
        {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (input.isEmpty())
            {
                System.out.println("Cannot save an empty workout.");
                continue;
            }
            return input;
        }
    }
}
