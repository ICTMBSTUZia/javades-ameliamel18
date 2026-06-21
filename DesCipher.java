import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.nio.charset.StandardCharsets;

public class DesCipher {

    private static final String KEY_ASCII = "DESKEY12";
    private static final String ALGORITHM  = "DES/ECB/PKCS5Padding"; // Java's PKCS5Padding == PKCS7 for DES

    public static SecretKey buildKey() throws Exception {
        byte[] keyBytes = KEY_ASCII.getBytes(StandardCharsets.US_ASCII);
        DESKeySpec desKeySpec = new DESKeySpec(keyBytes);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        return keyFactory.generateSecret(desKeySpec);
    }

    public static String encrypt(String plaintext, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encrypted = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
        return bytesToHex(encrypted);
    }

    public static String decrypt(String ciphertextHex, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decrypted = cipher.doFinal(hexToBytes(ciphertextHex));
        return new String(decrypted, StandardCharsets.UTF_8);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }

    private static byte[] hexToBytes(String hex) {
        int len = hex.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
                    + Character.digit(hex.charAt(i + 1), 16));
        }
        return data;
    }

    public static void main(String[] args) throws Exception {
        SecretKey key = buildKey();

        String[] plaintexts = {
                "HELLO123",
                "Computer Network Security",
                "DES Algorithm Test 2026!"
        };

        // Header
        System.out.printf("%-3s  %-30s  %-64s  %s%n",
                "No.", "Plaintext", "Ciphertext (Hex)", "Decrypted Text");
        System.out.println("-".repeat(120));

        for (int i = 0; i < plaintexts.length; i++) {
            String plaintext  = plaintexts[i];
            String cipherHex  = encrypt(plaintext, key);
            String decrypted  = decrypt(cipherHex, key);
            System.out.printf("%-3d  %-30s  %-64s  %s%n",
                    (i + 1), plaintext, cipherHex, decrypted);
        }
    }
}