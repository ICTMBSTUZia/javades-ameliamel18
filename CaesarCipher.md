# Programming Assignment: Encryption & Decryption

## Course / Module
Introduction to Programming — Cryptography Fundamentals

## Objective
This assignment assesses your ability to:
- Translate an algorithm description into working code
- Implement string manipulation logic (character-level processing)
- Design a program with two complementary functions (encryption and decryption) that correctly reverse each other
- Validate your own program's correctness using provided test cases

## Task Description
Write a single program that implements the **Caesar Cipher** encryption technique.

Your program must:
1. Accept a **plaintext** string and a **shift key** (an integer) as input.
2. **Encrypt** the plaintext into ciphertext using the Caesar Cipher algorithm.
3. **Decrypt** the resulting ciphertext back into the original plaintext, using the same shift key.
4. Run this encrypt → decrypt cycle on **all 5 sample plaintexts** provided below, and print the plaintext, the ciphertext, and the decrypted text for each one.
5. Confirm (programmatically or visually) that each decrypted result exactly matches the original plaintext.

### Caesar Cipher Rules
- Each alphabetic character is shifted forward by the **shift key** value (wrapping from `Z`→`A` or `z`→`a` as needed).
- **Uppercase and lowercase letters must preserve their case** after encryption/decryption.
- **Non-alphabetic characters** (digits, spaces, punctuation, symbols) must remain **unchanged**.
- Decryption is simply encryption with the shift applied in reverse.

Use **shift key = 4** for all sample data below.

> Example logic (pseudocode):
> ```
> encrypted_char = ((char - 'A' + shift) mod 26) + 'A'   // for uppercase
> decrypted_char = ((char - 'A' - shift + 26) mod 26) + 'A'
> ```

## Requirements
- You may use **any programming language** (Python, Java, C, C++, JavaScript, etc.) unless your instructor specifies otherwise.
- Implement **two distinct functions/methods**: one for encryption, one for decryption. Do not hardcode ciphertext values — they must be computed by your encryption function.
- Your program must process **all 5 sample plaintexts** in one execution (use a loop or list/array of inputs — do not write 5 separate copies of the code).
- Output must clearly display, for each of the 5 inputs:
  - The original plaintext
  - The shift key used
  - The resulting ciphertext
  - The decrypted text (recovered from the ciphertext)
- Include reasonable code comments explaining your logic.
- Code should run without errors and handle spaces, punctuation, and numbers gracefully (i.e., leave them unchanged).

## Sample Input

| No. | Plaintext | Shift Key |
|-----|-----------|-----------|
| 1 | `Hello, World!` | 4 |
| 2 | `Programming Assignment` | 4 |
| 3 | `Cyber Security 2026` | 4 |
| 4 | `Encrypt This Message` | 4 |
| 5 | `Stay Curious & Keep Learning` | 4 |

## Sample Output

Your program's output should match the following (formatting may vary slightly, but the values must be identical):

| No. | Plaintext | Ciphertext (Encrypted) | Decrypted Text |
|-----|-----------|-------------------------|-----------------|
| 1 | `Hello, World!` | `Lipps, Asvph!` | `Hello, World!` |
| 2 | `Programming Assignment` | `Tvskveqqmrk Ewwmkrqirx` | `Programming Assignment` |
| 3 | `Cyber Security 2026` | `Gcfiv Wigyvmxc 2026` | `Cyber Security 2026` |
| 4 | `Encrypt This Message` | `Irgvctx Xlmw Qiwweki` | `Encrypt This Message` |
| 5 | `Stay Curious & Keep Learning` | `Wxec Gyvmsyw & Oiit Pievrmrk` | `Stay Curious & Keep Learning` |

**Note:** Numbers (`2026`), spaces, punctuation (`,` `!` `&`) are unchanged in the ciphertext — only letters are shifted.

## Instructions for Submission
1. Write your program in a single source file (e.g., `cipher.py`, `Cipher.java`, `cipher.c`).
2. Test your program against all 5 sample inputs above and confirm your output matches the sample output exactly.
3. Add comments to your code explaining the encryption and decryption logic.
4. Submit:
   - Your source code file
   - A short text file or console screenshot showing the program's output for all 5 test cases
5. Ensure your program compiles/runs without errors before submission.

## Evaluation Criteria

| Criteria | Weight |
|----------|--------|
| Correct encryption logic (matches expected ciphertext) | 30% |
| Correct decryption logic (recovers original plaintext) | 30% |
| Handles all 5 sample inputs via loop/iteration (no hardcoding/duplication) | 15% |
| Proper handling of case, spaces, punctuation, and digits | 15% |
| Code clarity, comments, and output formatting | 10% |

## Bonus Challenge (Optional, +10%)
Modify your program to accept **plaintext and shift key as user input** (instead of hardcoded values), so it can encrypt/decrypt any message at runtime — not just the 5 provided samples.

## Academic Integrity
You may discuss the Caesar Cipher algorithm conceptually with classmates, but the code you submit must be written independently by you. Plagiarized or copy-pasted submissions will receive a zero.
