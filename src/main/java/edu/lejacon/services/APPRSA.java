package edu.lejacon.services;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.engines.RSAEngine;
import org.bouncycastle.crypto.generators.RSAKeyPairGenerator;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.RSAKeyGenerationParameters;
import org.bouncycastle.crypto.util.PrivateKeyFactory;
import org.bouncycastle.crypto.util.PrivateKeyInfoFactory;
import org.bouncycastle.crypto.util.PublicKeyFactory;
import org.bouncycastle.crypto.util.SubjectPublicKeyInfoFactory;

import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
public class APPRSA {
    static int serviceFuncNum = 5;
    private RSAKeyGenerationParameters parameters;
    private final Base64.Decoder decoder64 = Base64.getDecoder();
    private final Base64.Encoder encoder64 = Base64.getEncoder();
    private String publicKey;
    private String privateKey;

    public static String readUsingFiles(String fileName) {
        try {
            return new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void run(){
        System.out.println("run app-rsa.");
        String plainText = readUsingFiles("/Users/mxinyuan/workspace/JavaSpace/LejaconService/src/main/resources/rsaInput.txt");
        try{
            generateRSAKeyPair();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String pubKey = getPublicKey();
        String privKey = getPrivateKey();
        System.out.println("Plaint text: " + plainText);
        String cipherText = encode(plainText, pubKey);
        System.out.println("Encoded text: " + cipherText);
        byte[] result = decode(cipherText, privKey);
        String decodedText = new String(result);
        System.out.println("Decoded text:" + decodedText);
        System.out.println("finish app-rsa.");
    }

    public int getServiceFuncNum(){return serviceFuncNum;}

    public void generateRSAKeyPair() throws Exception {
        parameters = new RSAKeyGenerationParameters(BigInteger.valueOf(0x10001),
                CryptoServicesRegistrar.getSecureRandom(), 2048, 80);
        final RSAKeyPairGenerator kpg = new RSAKeyPairGenerator();
        kpg.init(parameters);

        AsymmetricCipherKeyPair pair = kpg.generateKeyPair();
        AsymmetricKeyParameter pub = pair.getPublic();
        AsymmetricKeyParameter priv = pair.getPrivate();

        SubjectPublicKeyInfo subjectPublicKeyInfo = SubjectPublicKeyInfoFactory.createSubjectPublicKeyInfo(pub);
        PrivateKeyInfo privateKeyInfo = PrivateKeyInfoFactory.createPrivateKeyInfo(priv);

        ASN1Object asn1ObjectPublic = subjectPublicKeyInfo.toASN1Primitive();
        byte[] publicInfoByte = asn1ObjectPublic.getEncoded();
        this.publicKey = encoder64.encodeToString(publicInfoByte);
        ASN1Object asn1ObjectPrivate = privateKeyInfo.toASN1Primitive();
        byte[] privateInfoByte = asn1ObjectPrivate.getEncoded();
        this.privateKey = encoder64.encodeToString(privateInfoByte);
    }

    public String getPublicKey() {
        return this.publicKey;
    }

    public String getPrivateKey() {
        return this.privateKey;
    }

    public String encode(String plainText, String publicKey) {
        long beforeComp = System.nanoTime();
        try {
            byte[] publicInfoBytes=decoder64.decode(publicKey);
            AsymmetricKeyParameter pub = PublicKeyFactory.createKey(publicInfoBytes);
            AsymmetricBlockCipher cipher = new RSAEngine();
            cipher.init(true, pub);
            String result = encoder64.encodeToString(cipher.processBlock(plainText.getBytes("utf-8"), 0, plainText.getBytes("utf-8").length));
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public byte[] decode (String cipherText, String privateKey) {
        try {
            byte[] privateInfoBytes = decoder64.decode(privateKey);
            byte[] cipherTextBytes = decoder64.decode(cipherText);
            AsymmetricKeyParameter priv = PrivateKeyFactory.createKey(privateInfoBytes);
            AsymmetricBlockCipher cipher = new RSAEngine();
            cipher.init(false, priv);
            byte[] result = cipher.processBlock(cipherTextBytes, 0, cipherTextBytes.length);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        APPRSA appRSA = new APPRSA();
        appRSA.run();
    }
}
