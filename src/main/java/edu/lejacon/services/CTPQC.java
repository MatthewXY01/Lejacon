package edu.lejacon.services;

import org.bouncycastle.pqc.crypto.lms.LMSKeyGenTests;
import org.bouncycastle.pqc.crypto.lms.LMSTests;
import org.bouncycastle.pqc.crypto.lms.TypeTests;
import org.bouncycastle.pqc.crypto.test.*;
import org.bouncycastle.pqc.math.ntru.euclid.test.BigIntEuclideanTest;
import org.bouncycastle.pqc.math.ntru.euclid.test.IntEuclideanTest;
import org.bouncycastle.pqc.math.ntru.polynomial.test.*;
import org.bouncycastle.pqc.math.ntru.util.test.ArrayEncoderTest;


public class CTPQC {
    static int serviceFuncNum = 98;
    static String[] involvedTestClassList = {
            "org.bouncycastle.pqc.crypto.lms.LMSKeyGenTests",
            "org.bouncycastle.pqc.crypto.lms.LMSTests",
            "org.bouncycastle.pqc.crypto.lms.TypeTests",
            "org.bouncycastle.pqc.math.ntru.euclid.test.BigIntEuclideanTest",
            "org.bouncycastle.pqc.math.ntru.euclid.test.IntEuclideanTest",
            "org.bouncycastle.pqc.math.ntru.polynomial.test.BigDecimalPolynomialTest",
            "org.bouncycastle.pqc.math.ntru.polynomial.test.BigIntPolynomialTest",
            "org.bouncycastle.pqc.math.ntru.polynomial.test.IntegerPolynomialTest",
            "org.bouncycastle.pqc.math.ntru.polynomial.test.LongPolynomial2Test",
            "org.bouncycastle.pqc.math.ntru.polynomial.test.LongPolynomial5Test",
            "org.bouncycastle.pqc.math.ntru.polynomial.test.ProductFormPolynomialTest",
            "org.bouncycastle.pqc.math.ntru.polynomial.test.SparseTernaryPolynomialTest",
            "org.bouncycastle.pqc.math.ntru.util.test.ArrayEncoderTest",
            "org.bouncycastle.pqc.crypto.test.BitStringTest",
            "org.bouncycastle.pqc.crypto.test.EncryptionKeyTest",
            "org.bouncycastle.pqc.crypto.test.NTRUEncryptionParametersTest",
            "org.bouncycastle.pqc.crypto.test.NTRUEncryptTest",
            "org.bouncycastle.pqc.crypto.test.NTRUSignatureParametersTest",
            "org.bouncycastle.pqc.crypto.test.NTRUSigningParametersTest",
            "org.bouncycastle.pqc.crypto.test.QTESLATest",
            "org.bouncycastle.pqc.crypto.test.XMSSMTPrivateKeyTest",
            "org.bouncycastle.pqc.crypto.test.XMSSMTPublicKeyTest",
            "org.bouncycastle.pqc.crypto.test.XMSSMTSignatureTest",
            "org.bouncycastle.pqc.crypto.test.XMSSMTTest",
            "org.bouncycastle.pqc.crypto.test.XMSSOidTest",
            "org.bouncycastle.pqc.crypto.test.XMSSPrivateKeyTest",
            "org.bouncycastle.pqc.crypto.test.XMSSPublicKeyTest",
            "org.bouncycastle.pqc.crypto.test.XMSSReducedSignatureTest",
            "org.bouncycastle.pqc.crypto.test.XMSSSignatureTest",
            "org.bouncycastle.pqc.crypto.test.XMSSTest",
            "org.bouncycastle.pqc.crypto.test.XMSSUtilTest",
            "org.bouncycastle.pqc.crypto.test.BitStringTest",
    };

    public CTPQC() {
        productFormPolynomialTest.setUp();
    }
    static LMSKeyGenTests lmsKeyGenTests = new LMSKeyGenTests();
    static LMSTests lmsTests = new LMSTests();
    static TypeTests typeTests = new TypeTests();
    static BigIntEuclideanTest bigIntEuclideanTest = new BigIntEuclideanTest();
    static IntEuclideanTest intEuclideanTest = new IntEuclideanTest();
    static BigDecimalPolynomialTest bigDecimalPolynomialTest = new BigDecimalPolynomialTest();
    static BigIntPolynomialTest bigIntPolynomialTest = new BigIntPolynomialTest();
    static IntegerPolynomialTest integerPolynomialTest = new IntegerPolynomialTest();
    static LongPolynomial2Test longPolynomial2Test = new LongPolynomial2Test();
    static LongPolynomial5Test longPolynomial5Test = new LongPolynomial5Test();
    static ProductFormPolynomialTest productFormPolynomialTest = new ProductFormPolynomialTest();
    static SparseTernaryPolynomialTest sparseTernaryPolynomialTest = new SparseTernaryPolynomialTest();
    static ArrayEncoderTest arrayEncoderTest = new ArrayEncoderTest();
    static BitStringTest bitStringTest = new BitStringTest();
    static EncryptionKeyTest encryptionKeyTest = new EncryptionKeyTest();
    static NTRUEncryptionParametersTest ntruEncryptionParametersTest = new NTRUEncryptionParametersTest();
    static NTRUEncryptTest ntruEncryptTest = new NTRUEncryptTest();
    static NTRUSignatureParametersTest ntruSignatureParametersTest = new NTRUSignatureParametersTest();
    static NTRUSignerTest ntruSignerTest = new NTRUSignerTest();
    static NTRUSigningParametersTest ntruSigningParametersTest = new NTRUSigningParametersTest();
    static QTESLATest qteslaTest = new QTESLATest();
    static XMSSMTPrivateKeyTest xmssmtPrivateKeyTest = new XMSSMTPrivateKeyTest();
    static XMSSMTPublicKeyTest xmssmtPublicKeyTest = new XMSSMTPublicKeyTest();
    static XMSSMTSignatureTest xmssmtSignatureTest = new XMSSMTSignatureTest();
    static XMSSMTTest xmssmtTest = new XMSSMTTest();
    static XMSSOidTest xmssOidTest = new XMSSOidTest();
    static XMSSPrivateKeyTest xmssPrivateKeyTest = new XMSSPrivateKeyTest();
    static XMSSPublicKeyTest xmssPublicKeyTest = new XMSSPublicKeyTest();
    static XMSSReducedSignatureTest xmssReducedSignatureTest = new XMSSReducedSignatureTest();
    static XMSSSignatureTest xmssSignatureTest = new XMSSSignatureTest();
    static XMSSTest xmssTest = new XMSSTest();
    static XMSSUtilTest xmssUtilTest = new XMSSUtilTest();

    public void run() {
        long begin = System.nanoTime();
        System.out.println("run ct-pqc.");
        try {
            lmsKeyGenTests.testGeneratePrivateKey();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
        try {
            lmsTests.testCoefFunc();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            lmsTests.testPrivateKeyRound();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            lmsTests.testLMS();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            lmsTests.testContextSingleUse();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            typeTests.testTypeForType();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            bigIntEuclideanTest.testCalculate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            intEuclideanTest.testCalculate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            bigDecimalPolynomialTest.testMult();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            bigIntPolynomialTest.testMult();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            integerPolynomialTest.testMult();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            integerPolynomialTest.testInvertFq();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            integerPolynomialTest.testInvertF3();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            integerPolynomialTest.testFromToBinary();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            integerPolynomialTest.testFromToBinary3Sves();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            integerPolynomialTest.testFromToBinary3Tight();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            integerPolynomialTest.testResultant();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            integerPolynomialTest.testResultantMod();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            longPolynomial2Test.testMult();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            longPolynomial2Test.testSubAnd();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            longPolynomial2Test.testMult2And();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            longPolynomial5Test.testMult();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            longPolynomial5Test.testToIntegerPolynomial();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            productFormPolynomialTest.testFromToBinary();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            productFormPolynomialTest.testMult();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            sparseTernaryPolynomialTest.testMult();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            sparseTernaryPolynomialTest.testFromToBinary();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            arrayEncoderTest.testEncodeDecodeModQ();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            arrayEncoderTest.testEncodeDecodeMod3Sves();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            arrayEncoderTest.testEncodeDecodeMod3Tight();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            bitStringTest.testAppendBitsByteArray();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            bitStringTest.testGetTrailing();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            bitStringTest.testGetLeadingAsInt();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            encryptionKeyTest.testEncode();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            ntruEncryptionParametersTest.testLoadSave();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            ntruEncryptionParametersTest.testEqualsHashCode();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            ntruEncryptionParametersTest.testClone();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            ntruEncryptTest.testEncryptDecrypt();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            ntruEncryptTest.testEncodedKeysSlow();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            ntruEncryptTest.testEncodedKeysFast();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            ntruSignatureParametersTest.testLoadSave();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            ntruSignatureParametersTest.testEqualsHashCode();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            ntruSignatureParametersTest.testClone();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            ntruSignerTest.testStub();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            ntruSigningParametersTest.testLoadSave();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            ntruSigningParametersTest.testEqualsHashCode();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            ntruSigningParametersTest.testClone();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            qteslaTest.testSignQ1p();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            qteslaTest.testSignQ3p();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            xmssmtPrivateKeyTest.testPrivateKeyParsingSHA256();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            xmssmtPublicKeyTest.testPublicKeyParsingSHA256();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            xmssmtPublicKeyTest.testConstructor();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            xmssmtSignatureTest.testSignatureParsingSHA256();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            xmssmtSignatureTest.testConstructor();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            xmssmtTest.testGenKeyPairSHA256();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            xmssmtTest.testGenKeyPairSHA512();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            xmssmtTest.testSignSHA256();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            xmssmtTest.testSignSHA256Complete1();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            xmssmtTest.testSignSHA256Complete2();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            xmssmtTest.testSignSHA512();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            xmssmtTest.testVerifySignatureSHA256();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            xmssmtTest.testVerifySignerSHA256();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            xmssmtTest.testVerifySignatureSHA512();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            xmssmtTest.testVerifySignerSHA512();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            xmssmtTest.testImportKeysSHA256();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            xmssmtTest.testImportKeysSHA512();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            xmssmtTest.testRandom();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            xmssmtTest.testPublicSeed();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            xmssmtTest.testBDSImport();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            xmssOidTest.testXMSSOidException1();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            xmssOidTest.testXMSSOidException2();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            xmssOidTest.testXMSSOidException3();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            xmssOidTest.testXMSSOid();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            xmssPrivateKeyTest.testPrivateKeyParsing();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            xmssPublicKeyTest.testPublicKeyParsingSHA256();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            xmssPublicKeyTest.testPublicKeyParsingSHA512();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            xmssPublicKeyTest.testConstructor();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            xmssReducedSignatureTest.testSignatureParsingSHA256();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            xmssReducedSignatureTest.testSignatureParsingSHA512();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            xmssReducedSignatureTest.testConstructor();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            xmssSignatureTest.testConstructor();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            xmssTest.testSignSHA256CompleteEvenHeight1();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            xmssTest.testVerifySignatureSHA256();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            xmssTest.testVerifySignatureSHA512();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            xmssTest.testImportStateSHA256();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            xmssTest.testImportKeysSHA512();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            xmssTest.testRandom();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            xmssTest.testBDSImport();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            xmssUtilTest.testLog2();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            xmssUtilTest.testIntToBytesBigEndian();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            xmssUtilTest.testLongToBytesBigEndian();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            xmssUtilTest.testLongToBytesBigEndianOffsetException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            xmssUtilTest.testLongToBytesBigEndianOffset();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            xmssUtilTest.testBytesToIntBigEndianException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            xmssUtilTest.testBytesToIntBigEndian();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            xmssUtilTest.testBytesToLongBigEndianException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            xmssUtilTest.testBytesToLongBigEndian();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            xmssUtilTest.testCalculateTau();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        long end = System.nanoTime();
        System.out.println("finish ct-pqc.");
    }

    public int getServiceFuncNum() {
        return serviceFuncNum;
    }

    public static void main(String[] args) {
        CTPQC ctPQC = new CTPQC();
        ctPQC.run();
    }

}
