# File Encryptor & Decryptor

## Overview
This is a simple file encryption and decryption program using a randomized Caesar cipher. The encryption process stores the shift value within the encrypted file, allowing proper decryption without external keys.

## Features
- Encrypts any text-based file using a randomly generated shift value.
- Stores the shift value in the encrypted file for seamless decryption.
- Uses a variation of the classic Caesar cipher.
- Handles uppercase, lowercase, and non-alphabet characters appropriately.

## How It Works
### Encryption
1. The program reads the content of the input file.
2. It generates a random shift value (between 1 and 25).
3. The shift value is written as the first line in the encrypted file.
4. The file content is encrypted using the shift and saved.

### Decryption
1. The program reads the encrypted file and retrieves the shift value from the first line.
2. It decrypts the remaining content using the stored shift value.
3. The original content is saved to a new file.

## Usage
### Running the Program
1. Compile the Java file:
   ```sh
   javac FileEncryptor.java
   ```
2. Run the program:
   ```sh
   java FileEncryptor
   ```
3. Choose an option:
   - `1` for Encryption
   - `2` for Decryption

### Encrypting a File
- Provide the path of the file to encrypt.
- The encrypted file will be saved as `encryptionResult.enc`.

### Decrypting a File
- Provide the path of the encrypted file.
- The decrypted file will be saved as `decryptionResult.txt`.

## Example
**Encrypting a file:**
```
Choose an option (1 - Encrypt, 2 - Decrypt): 1
Enter the file path to encrypt: sample.txt
File encrypted successfully! Saved as encryptionResult.enc
```

**Decrypting a file:**
```
Choose an option (1 - Encrypt, 2 - Decrypt): 2
Enter the encrypted file path to decrypt: encryptionResult.enc
File decrypted successfully! Saved as decryptionResult.txt
```

## Limitations
- Only works with text-based files.
- Shift value is stored in the encrypted file, making it recoverable.
- Uses a basic substitution cipher, which is not secure for high-level encryption needs.

## Future Improvements
- Implement stronger encryption algorithms like AES.
- Support encryption of binary files.
- Add a user-defined shift key option for enhanced security.

## License
This project is open-source and free to use under the MIT License.

