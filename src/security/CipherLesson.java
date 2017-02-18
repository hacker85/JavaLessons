package security;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by max on 2/17/17.
 */
public class CipherLesson {
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException, UnsupportedEncodingException {
        Cipher cipher = Cipher.getInstance("AES");
        int mode = Cipher.ENCRYPT_MODE;

//        KeyGenerator kgen = KeyGenerator.getInstance("AES");
//        kgen.init(128);
//        SecretKey key = kgen.generateKey();

        SecretKeySpec key = new SecretKeySpec("Bar12345Bar12345".getBytes(), "AES");
        cipher.init(mode, key);

        String hello = "hello world";
        byte[] bytes = cipher.doFinal(hello.getBytes(), 0, hello.length());
        for(byte b : bytes) {
            System.out.print(b);
        }
        System.out.println("----------");

        Cipher decryptCipher = Cipher.getInstance("AES");
        decryptCipher.init(Cipher.DECRYPT_MODE, key);
        byte[] bytes2 = decryptCipher.doFinal(bytes, 0, bytes.length);
        for(byte b : bytes2) {
            System.out.print((char)b);
        }
    }
}
