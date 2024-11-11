package it22049.helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    
    // Method to validate the email using a regex pattern
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        
        return matcher.matches();
    }
    
    // Method to validate if the input contains only letters
    public static boolean isAlphabetic(String input) {
        String alphabeticRegex = "^[a-zA-Z\u0370-\u03FF]+$";
        
        Pattern pattern = Pattern.compile(alphabeticRegex);
        Matcher matcher = pattern.matcher(input);
        
        return matcher.matches();
    }
    // Method to validate the address using a regex pattern
    public static boolean isValidAddress(String address) {
        // Regex pattern for a basic address validation
        String addressRegex = "^[a-zA-Z\u0370-\u03FF0-9\\s,.'-]{3,}$";
        Pattern pattern = Pattern.compile(addressRegex);
        Matcher matcher = pattern.matcher(address);
        
        return matcher.matches();
    }
    // Method to validate the input containing exactly 9 digits
    public static boolean isValidVatNumber(String input) {
        String nineDigitRegex = "^\\d{9}$";
        
        Pattern pattern = Pattern.compile(nineDigitRegex);
        Matcher matcher = pattern.matcher(input);
        
        return matcher.matches();
    }
    
    // Method to validate car license number
    public static boolean isValidCarLicense(String input) {
        String specificFormatRegex = "^[a-zA-Z\u0370-\u03FF]{3}-\\d{1,3}$";
        
        Pattern pattern = Pattern.compile(specificFormatRegex);
        Matcher matcher = pattern.matcher(input);
        
        return matcher.matches();
    }
    
    // Method to validate the full name
    public static boolean isValidFullName(String name) {
        // Regular expression pattern for validating full name with Greek letters
        String regex = "^[a-zA-Z\u0370-\u03FF\\s]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

}
