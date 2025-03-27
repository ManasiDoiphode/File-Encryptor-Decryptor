import java.io.*;
import java.util.Random;
import java.util.Scanner;

/**
 * A simple file encryption and decryption program using a randomized Caesar cipher.
 * The encryption stores the shift value in the encrypted file, allowing proper decryption.
 */
public class FileEncryptor {
    private static final int SHIFT_MIN = 1;  // Minimum shift value
    private static final int SHIFT_MAX = 25; // Maximum shift value

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Choose an option (1 - Encrypt, 2 - Decrypt): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter the file path to encrypt: ");
                String inputFileEncrypt = scanner.nextLine();
                encryptFile(inputFileEncrypt, "encryptionResult.enc");
                break;

            case 2:
                System.out.print("Enter the encrypted file path to decrypt: ");
                String inputFileDecrypt = scanner.nextLine();
                decryptFile(inputFileDecrypt, "decryptionResult.txt");
                break;

            default:
                System.out.println("Invalid option. Please choose 1 or 2.");
        }

        scanner.close();
    }

    /**
     * Encrypts the content of a given file using a random shift (Caesar Cipher).
     * The shift value is stored at the beginning of the encrypted file.
     *
     * @param inputFile  The file to encrypt.
     * @param outputFile The file where the encrypted content will be saved.
     */
    private static void encryptFile(String inputFile, String outputFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            // Generate a random shift value
            Random random = new Random();
            int shift = random.nextInt(SHIFT_MAX - SHIFT_MIN + 1) + SHIFT_MIN;
            writer.write(shift + "\n"); // Store the shift value in the file

            int ch;
            while ((ch = reader.read()) != -1) {
                writer.write(encryptCharacter((char) ch, shift));
            }

            System.out.println("File encrypted successfully! Saved as " + outputFile);
        } catch (IOException e) {
            System.out.println("Error: Unable to process the file. " + e.getMessage());
        }
    }

    /**
     * Decrypts a file by reading the shift value and reversing the Caesar cipher.
     *
     * @param inputFile  The encrypted file to decrypt.
     * @param outputFile The file where the decrypted content will be saved.
     */
    private static void decryptFile(String inputFile, String outputFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            // Read shift value from the first line of the file
            int shift = Integer.parseInt(reader.readLine().trim());

            int ch;
            while ((ch = reader.read()) != -1) {
                writer.write(decryptCharacter((char) ch, shift));
            }

            System.out.println("File decrypted successfully! Saved as " + outputFile);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error: Unable to decrypt the file. " + e.getMessage());
        }
    }

    /**
     * Encrypts a single character using the Caesar cipher.
     *
     * @param ch    The character to encrypt.
     * @param shift The shift value.
     * @return The encrypted character.
     */
    private static char encryptCharacter(char ch, int shift) {
        if (Character.isLetter(ch)) {
            char base = Character.isLowerCase(ch) ? 'a' : 'A';
            return (char) ((ch - base + shift) % 26 + base);
        }
        return ch; // Leave non-alphabet characters unchanged
    }

    /**
     * Decrypts a single character using the Caesar cipher.
     *
     * @param ch    The character to decrypt.
     * @param shift The shift value.
     * @return The decrypted character.
     */
    private static char decryptCharacter(char ch, int shift) {
        if (Character.isLetter(ch)) {
            char base = Character.isLowerCase(ch) ? 'a' : 'A';
            return (char) ((ch - base - shift + 26) % 26 + base);
        }
        return ch; // Leave non-alphabet characters unchanged
    }
}
