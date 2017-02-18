package security;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.*;

/**
 * Created by max on 2/18/17.
 */
public class RSALesson {
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException, UnsupportedEncodingException {
        Cipher cipher = Cipher.getInstance("RSA");
        int mode = Cipher.ENCRYPT_MODE;

        KeyPairGenerator pairgen = KeyPairGenerator.getInstance("RSA");
//        SecureRandom random = new SecureRandom();
//        pairgen.initialize(512, random);
        KeyPair keyPair = pairgen.generateKeyPair();
        Key publicKey = keyPair.getPublic();
        Key privateKey = keyPair.getPrivate();

        cipher.init(mode, privateKey);

        String hello = "hello world";
        byte[] bytes = cipher.doFinal(hello.getBytes(), 0, hello.length());
        for(byte b : bytes) {
            System.out.print(b);
        }
        System.out.println("\n----------");

        Cipher decryptCipher = Cipher.getInstance("RSA");
        decryptCipher.init(Cipher.DECRYPT_MODE, publicKey);
        byte[] bytes2 = decryptCipher.doFinal(bytes, 0, bytes.length);
        for(byte b : bytes2) {
            System.out.print((char)b);
        }
    }
}
