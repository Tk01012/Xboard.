package com.example.keybb;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class SecKey extends AppCompatActivity {

    private static final String ALPHANUM = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890 `,./;'[]\\~!@#$%^&*()}{+_\":?><-=";
    private static final int ALPHANUM_LENGTH = ALPHANUM.length();
    public static String genKey()
    {
        StringBuilder localAN = new StringBuilder(ALPHANUM);    // Modifiable copy of ALPHANUM
        StringBuilder localKey = new StringBuilder();           // StringBuilder for the Key
        int rand;

        for (int i = 0; i < ALPHANUM_LENGTH; i++) { // Take a random character in the list of chars, append it to the key and delete it from the list of chars until we have a full key
            rand = (int)(Math.random()*100)%(ALPHANUM_LENGTH-i);
            localKey.append(localAN.charAt(rand));
            localAN.deleteCharAt(rand);
        }

        return localKey.toString();
    }

}


    /*
    
    private static final String SECRET_KEY = "my_super_secret_key_ho_ho_ho";
    private static final String SALT = "ssshhhhhhhhhhh!!!!";

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String key() {
        try {
            byte[] iv = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            IvParameterSpec ivspec = new IvParameterSpec(iv);

            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray(), SALT.getBytes(), 65536, 256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

            return secretKey.toString();
        } catch (Exception e) {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

     */