package utils;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Validate {
    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Get an integer number within the allowed range.
     * 
     * @param messageInfo             The message required input.
     * @param messsageErrorOutOfRange The message required if out of range.
     * @param messageErrorNumber      The message required if the number format is
     *                                wrong.
     * @param min                     The minimum value.
     * @param max                     The maximum value.
     * @return the valid integer number.
     */
    public static int getInt(
            String messageInfo,
            String messsageErrorOutOfRange,
            String messageErrorNumber,
            int min,
            int max) {
        do {
            try {
                System.out.print(messageInfo);
                int number = Integer.parseInt(SCANNER.nextLine());
                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.out.println(messsageErrorOutOfRange);
                }
            } catch (NumberFormatException e) {
                System.out.println(messageErrorNumber);
            }
        } while (true);
    }

    /**
     * Get a string.
     *
     * @param prompt       The message required input.
     * @param regex        The regular expression to check the string.
     * @param errorInvalid The message required if the string is invalid.
     * @return the valid string.
     */
    public static String getString(String prompt, String regex, String errorInvalid) {
        while (true) {
            System.out.print(prompt);
            String input = SCANNER.nextLine().trim();
            if (!input.matches(regex)) {
                System.out.println(errorInvalid);
            } else {
                return input;
            }
        }

    }

    /**
     * Get a real number (double) within the allowed range.
     *
     * @param prompt             The message required input.
     * @param errorOutOfRange    The message required if out of range.
     * @param errorInvalidNumber The message required if the number format is wrong.
     * @param min                The minimum value.
     * @param max                The maximum value.
     * @return the valid real number.
     */
    public static double getDouble(String prompt, String errorOutOfRange, String errorInvalidNumber,
            double min, double max) {
        while (true) {
            try {
                System.out.print(prompt);
                double value = Double.parseDouble(SCANNER.nextLine().trim());
                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.println(errorOutOfRange);
                }
            } catch (NumberFormatException e) {
                System.out.println(errorInvalidNumber);
            }
        }
    }

    /**
     * Get a date within the allowed range.
     * 
     * @param messageInfo            The message required input.
     * @param messageErrorOutOfRange The message required if out of range.
     * @param messageErrorDate       The message required if the date format is
     *                               wrong.
     * @param format                 The format of the date.
     * @param min                    The minimum date.
     * @param max                    The maximum date.
     * @return the valid date.
     */
    public static String getDate(String messageInfo, String errorOutOfRange,
            String errorInvalid, String format,
            LocalDate min, LocalDate max) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        while (true) {
            System.out.print(messageInfo);
            String input = SCANNER.nextLine().trim();
            String[] parts = input.split("/");
            if (parts.length != 3) {
                System.out.println(errorInvalid);
                continue;
            }
            try {
                int day = Integer.parseInt(parts[0]);
                int month = Integer.parseInt(parts[1]);
                int year = Integer.parseInt(parts[2]);
                if (month == 2 && day == 29 && !Year.isLeap(year)) {
                    System.out.println("Invalid date! " + year + " is not a leap year.");
                    continue;
                }
                LocalDate date = LocalDate.of(year, month, day);
                if (!date.isBefore(min) && !date.isAfter(max)) {
                    return date.format(formatter);
                } else {
                    System.out.println(errorOutOfRange);
                }
            } catch (NumberFormatException | DateTimeException e) {
                System.out.println(errorInvalid);
            }
        }
    }

}
