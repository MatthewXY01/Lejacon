package edu.lejacon.services;

import org.bouncycastle.crypto.test.GCMReorderTest;
import org.bouncycastle.crypto.test.RegressionTest;
import org.bouncycastle.util.test.SimpleTestResult;

import static junit.framework.TestCase.fail;

public class CTCrypto {
    static int involvedTestClassNum=164;
    static int serviceFuncNum = 168;
    static String[] involvedTestClassList = {
            "org.bouncycastle.crypto.test.AESTest",
            "org.bouncycastle.crypto.test.AESLightTest",
            "org.bouncycastle.crypto.test.AESFastTest",
            "org.bouncycastle.crypto.test.AESWrapTest",
            "org.bouncycastle.crypto.test.AESWrapPadTest",
            "org.bouncycastle.crypto.test.ARIATest",
            "org.bouncycastle.crypto.test.DESTest",
            "org.bouncycastle.crypto.test.DESedeTest",
            "org.bouncycastle.crypto.test.ModeTest",
            "org.bouncycastle.crypto.test.PaddingTest",
            "org.bouncycastle.crypto.test.DHTest",
            "org.bouncycastle.crypto.test.ElGamalTest",
            "org.bouncycastle.crypto.test.DSATest",
            "org.bouncycastle.crypto.test.ECTest",
            "org.bouncycastle.crypto.test.DeterministicDSATest",
            "org.bouncycastle.crypto.test.ECGOST3410Test",
            "org.bouncycastle.crypto.test.ECIESTest",
            "org.bouncycastle.crypto.test.ECNRTest",
            "org.bouncycastle.crypto.test.MacTest",
            "org.bouncycastle.crypto.test.GOST28147MacTest",
            "org.bouncycastle.crypto.test.RC2Test",
            "org.bouncycastle.crypto.test.RC2WrapTest",
            "org.bouncycastle.crypto.test.RC4Test",
            "org.bouncycastle.crypto.test.RC5Test",
            "org.bouncycastle.crypto.test.RC6Test",
            "org.bouncycastle.crypto.test.RijndaelTest",
            "org.bouncycastle.crypto.test.SerpentTest",
            "org.bouncycastle.crypto.test.TnepresTest",
            "org.bouncycastle.crypto.test.CamelliaTest",
            "org.bouncycastle.crypto.test.CamelliaLightTest",
            "org.bouncycastle.crypto.test.DigestRandomNumberTest",
            "org.bouncycastle.crypto.test.SkipjackTest",
            "org.bouncycastle.crypto.test.BlowfishTest",
            "org.bouncycastle.crypto.test.TwofishTest",
            "org.bouncycastle.crypto.test.Threefish256Test",
            "org.bouncycastle.crypto.test.Threefish512Test",
            "org.bouncycastle.crypto.test.Threefish1024Test",
            "org.bouncycastle.crypto.test.SkeinDigestTest",
            "org.bouncycastle.crypto.test.SkeinMacTest",
            "org.bouncycastle.crypto.test.CAST5Test",
            "org.bouncycastle.crypto.test.CAST6Test",
            "org.bouncycastle.crypto.test.GOST28147Test",
            "org.bouncycastle.crypto.test.IDEATest",
            "org.bouncycastle.crypto.test.RSABlindedTest",
            "org.bouncycastle.crypto.test.RSADigestSignerTest",
            "org.bouncycastle.crypto.test.PSSBlindTest",
            "org.bouncycastle.crypto.test.ISO9796Test",
            "org.bouncycastle.crypto.test.ISO9797Alg3MacTest",
            "org.bouncycastle.crypto.test.MD2DigestTest",
            "org.bouncycastle.crypto.test.MD4DigestTest",
            "org.bouncycastle.crypto.test.MD5DigestTest",
            "org.bouncycastle.crypto.test.SHA1DigestTest",
            "org.bouncycastle.crypto.test.SHA224DigestTest",
            "org.bouncycastle.crypto.test.SHA256DigestTest",
            "org.bouncycastle.crypto.test.SHA384DigestTest",
            "org.bouncycastle.crypto.test.SHA512DigestTest",
            "org.bouncycastle.crypto.test.SHA512t224DigestTest",
            "org.bouncycastle.crypto.test.SHA512t256DigestTest",
            "org.bouncycastle.crypto.test.SHA3DigestTest",
            "org.bouncycastle.crypto.test.RIPEMD128DigestTest",
            "org.bouncycastle.crypto.test.RIPEMD160DigestTest",
            "org.bouncycastle.crypto.test.RIPEMD256DigestTest",
            "org.bouncycastle.crypto.test.RIPEMD320DigestTest",
            "org.bouncycastle.crypto.test.TigerDigestTest",
            "org.bouncycastle.crypto.test.GOST3411DigestTest",
            "org.bouncycastle.crypto.test.GOST3411_2012_256DigestTest",
            "org.bouncycastle.crypto.test.GOST3411_2012_512DigestTest",
            "org.bouncycastle.crypto.test.WhirlpoolDigestTest",
            "org.bouncycastle.crypto.test.MD5HMacTest",
            "org.bouncycastle.crypto.test.SHA1HMacTest",
            "org.bouncycastle.crypto.test.SHA224HMacTest",
            "org.bouncycastle.crypto.test.SHA256HMacTest",
            "org.bouncycastle.crypto.test.SHA384HMacTest",
            "org.bouncycastle.crypto.test.SHA512HMacTest",
            "org.bouncycastle.crypto.test.RIPEMD128HMacTest",
            "org.bouncycastle.crypto.test.RIPEMD160HMacTest",
            "org.bouncycastle.crypto.test.OAEPTest",
            "org.bouncycastle.crypto.test.PSSTest",
            "org.bouncycastle.crypto.test.CTSTest",
            "org.bouncycastle.crypto.test.NISTCTSTest",
            "org.bouncycastle.crypto.test.NISTECCTest",
            "org.bouncycastle.crypto.test.CCMTest",
            "org.bouncycastle.crypto.test.PKCS5Test",
            "org.bouncycastle.crypto.test.PKCS12Test",
            "org.bouncycastle.crypto.test.KDF1GeneratorTest",
            "org.bouncycastle.crypto.test.KDF2GeneratorTest",
            "org.bouncycastle.crypto.test.MGF1GeneratorTest",
            "org.bouncycastle.crypto.test.HKDFGeneratorTest",
            "org.bouncycastle.crypto.test.DHKEKGeneratorTest",
            "org.bouncycastle.crypto.test.ECDHKEKGeneratorTest",
            "org.bouncycastle.crypto.test.ShortenedDigestTest",
            "org.bouncycastle.crypto.test.EqualsHashCodeTest",
            "org.bouncycastle.crypto.test.TEATest",
            "org.bouncycastle.crypto.test.XTEATest",
            "org.bouncycastle.crypto.test.RFC3211WrapTest",
            "org.bouncycastle.crypto.test.SEEDTest",
            "org.bouncycastle.crypto.test.Salsa20Test",
            "org.bouncycastle.crypto.test.XSalsa20Test",
            "org.bouncycastle.crypto.test.ChaChaTest",
            "org.bouncycastle.crypto.test.ChaCha20Poly1305Test",
            "org.bouncycastle.crypto.test.CMacTest",
            "org.bouncycastle.crypto.test.EAXTest",
            "org.bouncycastle.crypto.test.GCMTest",
            "org.bouncycastle.crypto.test.GMacTest",
            "org.bouncycastle.crypto.test.HCFamilyTest",
            "org.bouncycastle.crypto.test.HCFamilyVecTest",
            "org.bouncycastle.crypto.test.ISAACTest",
            "org.bouncycastle.crypto.test.NoekeonTest",
            "org.bouncycastle.crypto.test.VMPCKSA3Test",
            "org.bouncycastle.crypto.test.VMPCMacTest",
            "org.bouncycastle.crypto.test.VMPCTest",
            "org.bouncycastle.crypto.test.Grainv1Test",
            "org.bouncycastle.crypto.test.Grain128Test",
            "org.bouncycastle.crypto.test.SCryptTest",
            "org.bouncycastle.crypto.test.ResetTest",
            "org.bouncycastle.crypto.test.NullTest",
            "org.bouncycastle.crypto.test.DSTU4145Test",
            "org.bouncycastle.crypto.test.SipHashTest",
            "org.bouncycastle.crypto.test.Poly1305Test",
            "org.bouncycastle.crypto.test.OCBTest",
            "org.bouncycastle.crypto.test.NonMemoableDigestTest",
            "org.bouncycastle.crypto.test.RSAKeyEncapsulationTest",
            "org.bouncycastle.crypto.test.ECIESKeyEncapsulationTest",
            "org.bouncycastle.crypto.test.HashCommitmentTest",
            "org.bouncycastle.crypto.test.CipherStreamTest",
            "org.bouncycastle.crypto.test.BlockCipherResetTest",
            "org.bouncycastle.crypto.test.StreamCipherResetTest",
            "org.bouncycastle.crypto.test.SM3DigestTest",
            "org.bouncycastle.crypto.test.Shacal2Test",
            "org.bouncycastle.crypto.test.BCryptTest",
            "org.bouncycastle.crypto.test.X931SignerTest",
            "org.bouncycastle.crypto.test.Blake2bDigestTest",
            "org.bouncycastle.crypto.test.Blake2sDigestTest",
            "org.bouncycastle.crypto.test.Blake2xsDigestTest",
            "org.bouncycastle.crypto.test.KeccakDigestTest",
            "org.bouncycastle.crypto.test.SHAKEDigestTest",
            "org.bouncycastle.crypto.test.SM2EngineTest",
            "org.bouncycastle.crypto.test.SM2KeyExchangeTest",
            "org.bouncycastle.crypto.test.SM2SignerTest",
            "org.bouncycastle.crypto.test.SM4Test",
            "org.bouncycastle.crypto.test.DSTU7624Test",
            "org.bouncycastle.crypto.test.DSTU7564Test",
            "org.bouncycastle.crypto.test.IsoTrailerTest",
            "org.bouncycastle.crypto.test.GOST3412Test",
            "org.bouncycastle.crypto.test.GOST3412MacTest",
            "org.bouncycastle.crypto.test.GSKKDFTest",
            "org.bouncycastle.crypto.test.X25519Test",
            "org.bouncycastle.crypto.test.X448Test",
            "org.bouncycastle.crypto.test.Ed25519Test",
            "org.bouncycastle.crypto.test.Ed448Test",
            "org.bouncycastle.crypto.test.OpenSSHKeyParsingTests",
            "org.bouncycastle.crypto.test.EthereumIESTest",
            "org.bouncycastle.crypto.test.BigIntegersTest",
            "org.bouncycastle.crypto.test.ZucTest",
            "org.bouncycastle.crypto.test.Haraka256DigestTest",
            "org.bouncycastle.crypto.test.Haraka512DigestTest",
            "org.bouncycastle.crypto.test.SipHash128Test",
            "org.bouncycastle.crypto.test.GCMSIVTest",
            "org.bouncycastle.crypto.test.Blake3Test",
            "org.bouncycastle.crypto.test.KangarooTest",
            "org.bouncycastle.crypto.test.SP80038GTest",
            "org.bouncycastle.crypto.test.TupleHashTest",
            "org.bouncycastle.crypto.test.ParallelHashTest",
            "org.bouncycastle.crypto.test.GCMReorderTest"
    };

    static org.bouncycastle.util.test.Test[] tests = RegressionTest.tests;

    static GCMReorderTest gcmReorderTest = new GCMReorderTest();

    public int getServiceFuncNum() {
        return serviceFuncNum;
    }

    public void run() {
        System.out.println("run ct-crypto.");
        for (org.bouncycastle.util.test.Test test:tests) {
            SimpleTestResult result = (SimpleTestResult) test.perform();
            if (!result.isSuccessful()) {
                if (result.getException() != null) {
                    result.getException().printStackTrace();
                }
                fail(result.toString());
            }
        }
        try {
            gcmReorderTest.testCombine();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            gcmReorderTest.testConcatAuth();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            gcmReorderTest.testConcatCrypt();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            gcmReorderTest.testExp();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            gcmReorderTest.testMultiply();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("finish ct-crypto.");
    }

    public static void main(String[] args) {
        CTCrypto ctCrypto = new CTCrypto();
        ctCrypto.run();
    }
}
