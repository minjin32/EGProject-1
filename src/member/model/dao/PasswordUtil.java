package member.model.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
 
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
 
public class PasswordUtil {
    // 해시화 알고리즘
    private static final String ALGORITHM = "PBKDF2WithHmacSHA256";
    private static final int ITERATION_COUNT = 10000;
    private static final int KEY_LENGTH = 256;
 
    public static String getHashedPassword(String password, String userid) {
        // PBEKey 생성에 필요한 값
        char[] passCharAry = password.toCharArray();
        byte[] hashed = gethash(userid);
 
        // PBEKey 생성
        PBEKeySpec keySpec = new PBEKeySpec(passCharAry, hashed, ITERATION_COUNT, KEY_LENGTH);
        // 비밀키
        SecretKeyFactory skf = null;
 
        try {
            // PBKDF2 With HmacSHA256 알고리즘의 개인 키를 변환하는 객체 생성
            skf = SecretKeyFactory.getInstance(ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
 
        // 비밀키 인터페이스
        // 모든 비밀 키의 인터페이스를 다룰 수 있다
        SecretKey secretKey = null;
        try {
            // PBEKey 키 사양으로 비밀 키 생성
            secretKey = skf.generateSecret(keySpec);
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        // 키(비밀키)를 1차 부호화 형식
        byte[] passByteAry = secretKey.getEncoded();
         
        // 생성된 바이트 배열을 16진수 문자열로 변환
        StringBuffer sf = new StringBuffer(64);
        for (byte b : passByteAry) {
            sf.append(String.format("%02x", b & 0xff));
        }
        return sf.toString();
    }
 
    private static byte[] gethash(String salt) {
        byte[] hashBytes = null;
        MessageDigest messageDigest = null;
 
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if(messageDigest != null) {
            messageDigest.update(salt.getBytes());
            hashBytes = messageDigest.digest();
        }
        return hashBytes;
    }
 
}
