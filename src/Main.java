import java.security.SecureRandom;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        final byte[] secret = "Hii".getBytes();
        final byte[] encrypted = new byte[secret.length];
        final byte[] decrypted = new byte[secret.length];
        
        final byte[] key = getKey(secret.length);

        OTP(secret, key, encrypted);
        OTP(encrypted, key, decrypted);

        System.out.println("Encrypted: " + new String(encrypted));
        System.out.println("Decrypted: " + new String(decrypted));
    }

    private static void OTP(byte[] input, byte[] key, byte[] output) {
        IntStream.range(0, input.length).forEach(i -> output[i] = (byte) (input[i] ^ key[i]));
    }

    private static byte[] getKey(int length) {
        final byte[] key = new byte[length];
        new SecureRandom().nextBytes(key);
        return key;
    }
}
