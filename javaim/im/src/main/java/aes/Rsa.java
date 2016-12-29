package aes;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

/**
 * Created by alongsea2 on 2016/12/22.
 */
public class Rsa {
    public static KeyPair generateRSAKeyPair(int keyLength) {
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(keyLength);
            return kpg.genKeyPair();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        KeyPair keyPair = generateRSAKeyPair(1024);
        byte[] privetKey = keyPair.getPrivate().getEncoded();
        byte[] publicKey = keyPair.getPublic().getEncoded();

    }
}
