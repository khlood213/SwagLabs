package util;

import java.util.Random;

public class Utility {
//generate name
        public static String generateRandomName() {
            Random random = new Random();
            int length = 20 + random.nextInt(11); // random length between 20 and 30

            StringBuilder name = new StringBuilder(length);
            for (int i = 0; i < length; i++) {
                // randomly choose uppercase or lowercase letter
                char letter;
                if (random.nextBoolean()) {
                    letter = (char) ('A' + random.nextInt(26)); // A-Z
                } else {
                    letter = (char) ('a' + random.nextInt(26)); // a-z
                }
                name.append(letter);
            }

            return name.toString();
        }
        //generate email
    public static String generateRandomGmail() {
        Random random = new Random();

        int length = 10 + random.nextInt(6);

        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder username = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            username.append(characters.charAt(index));
        }

        return username.toString() + "@gmail.com";
    }
    // to generate phone number
        public static String generateRandomPhoneNumber() {
            Random random = new Random();

            StringBuilder phone = new StringBuilder("012"); // start with 012

            for (int i = 0; i < 8; i++) {
                int digit = random.nextInt(10);
                phone.append(digit);
            }

            return phone.toString();
        }
// to generate password
    public static String generateRandomPassword() {
        Random random = new Random();

        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()-_=+<>?";

        int length = 15 ;

        StringBuilder password = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }

        return password.toString();
    }
    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
    private static final Random random = new Random();

    // Generate random 5-digit ZIP code
    public static String generateRandomZip() {
        StringBuilder zip = new StringBuilder(5);
        for (int i = 0; i < 5; i++) {
            int digit = random.nextInt(10); // 0-9
            zip.append(digit);
        }
        return zip.toString();
    }


    }
