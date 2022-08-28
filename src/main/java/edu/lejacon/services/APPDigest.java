package edu.lejacon.services;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
public class APPDigest {
    static String[] ALGS = {"MD4", "MD5",
            "SHA-256", "SHA-512",
            "GOST3411", "WHIRLPOOL", "TIGER", "SM3"};
    public static int serviceFuncNum=ALGS.length;

    private final Provider PROVIDER;
    public APPDigest() {
        Provider provider = Security.getProvider("BC");
        if (provider != null) {
            PROVIDER = provider;
        } else {
            PROVIDER = new BouncyCastleProvider();
        }
        Security.addProvider(PROVIDER);
    }
    public static String readUsingFiles(String fileName) {
        try {
            return new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public void run() {
        System.out.println("run app-digest");
        String message = readUsingFiles("/Users/mxinyuan/workspace/JavaSpace/LejaconService/src/main/resources/rand256K");
        wrappedService("ALL", 1, message);
        System.out.println("finish app-digest");
    }
    public int getServiceFuncNum(){return serviceFuncNum;}

    private String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public String wrappedService(String alg, int iterNum, String message) {
        long beforeComp = System.nanoTime();
        String result = "";
        for (int i = 0; i< iterNum; i++) {
            if (!alg.equals("ALL")){
                byte[] msgBytes = message.getBytes();
                try {
                    MessageDigest md = MessageDigest.getInstance(alg, "BC");
                    System.out.println(alg + " provider: " + md.getProvider());
                    result = doHash(md, msgBytes);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }else {
                for (String whichAlg:ALGS) {
                    byte[] msgBytes = message.getBytes();
                    try {
                        MessageDigest md = MessageDigest.getInstance(whichAlg, "BC");
                        System.out.println(whichAlg + " provider: " + md.getProvider());
                        result = doHash(md, msgBytes);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }
        }
        return result;
    }
    private String doHash(MessageDigest md, byte[] msgBytes) {
        md.update(msgBytes);
        byte byteBuffer[] = md.digest();
        return bytesToHex(byteBuffer);
    }

    public static void main(String[] args) {
        APPDigest appDigest = new APPDigest();
        appDigest.run();
    }
}
