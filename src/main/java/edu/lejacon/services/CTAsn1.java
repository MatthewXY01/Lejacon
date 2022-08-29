package edu.lejacon.services;

import org.bouncycastle.asn1.test.RegressionTest;
import org.bouncycastle.util.test.SimpleTestResult;

import static junit.framework.TestCase.fail;

public class CTAsn1 {
    static int involvedTestClassNum = 48;
    static int serviceFuncNum = 48;
    static org.bouncycastle.util.test.Test[] simpleTests = RegressionTest.tests;
    static String[] involvedTestClassList = {
            "org.bouncycastle.asn1.test.InputStreamTest",
            "org.bouncycastle.asn1.test.EqualsAndHashCodeTest",
            "org.bouncycastle.asn1.test.TagTest",
            "org.bouncycastle.asn1.test.SetTest",
            "org.bouncycastle.asn1.test.ASN1IntegerTest",
            "org.bouncycastle.asn1.test.DERUTF8StringTest",
            "org.bouncycastle.asn1.test.CertificateTest",
            "org.bouncycastle.asn1.test.GenerationTest",
            "org.bouncycastle.asn1.test.OCSPTest",
            "org.bouncycastle.asn1.test.OIDTest",
            "org.bouncycastle.asn1.test.PKCS10Test",
            "org.bouncycastle.asn1.test.PKCS12Test",
            "org.bouncycastle.asn1.test.X509NameTest",
            "org.bouncycastle.asn1.test.X500NameTest",
            "org.bouncycastle.asn1.test.X509ExtensionsTest",
            "org.bouncycastle.asn1.test.GeneralizedTimeTest",
            "org.bouncycastle.asn1.test.BitStringTest",
            "org.bouncycastle.asn1.test.MiscTest",
            "org.bouncycastle.asn1.test.X9Test",
            "org.bouncycastle.asn1.test.MonetaryValueUnitTest",
            "org.bouncycastle.asn1.test.BiometricDataUnitTest",
            "org.bouncycastle.asn1.test.Iso4217CurrencyCodeUnitTest",
            "org.bouncycastle.asn1.test.SemanticsInformationUnitTest",
            "org.bouncycastle.asn1.test.QCStatementUnitTest",
            "org.bouncycastle.asn1.test.TypeOfBiometricDataUnitTest",
            "org.bouncycastle.asn1.test.EncryptedPrivateKeyInfoTest",
            "org.bouncycastle.asn1.test.ReasonFlagsTest",
            "org.bouncycastle.asn1.test.NetscapeCertTypeTest",
            "org.bouncycastle.asn1.test.KeyUsageTest",
            "org.bouncycastle.asn1.test.StringTest",
            "org.bouncycastle.asn1.test.UTCTimeTest",
            "org.bouncycastle.asn1.test.NameOrPseudonymUnitTest",
            "org.bouncycastle.asn1.test.PersonalDataUnitTest",
            "org.bouncycastle.asn1.test.DERApplicationSpecificTest",
            "org.bouncycastle.asn1.test.IssuingDistributionPointUnitTest",
            "org.bouncycastle.asn1.test.TargetInformationTest",
            "org.bouncycastle.asn1.test.SubjectKeyIdentifierTest",
            "org.bouncycastle.asn1.test.ParsingTest",
            "org.bouncycastle.asn1.test.GeneralNameTest",
            "org.bouncycastle.asn1.test.ObjectIdentifierTest",
            "org.bouncycastle.asn1.test.RFC4519Test",
            "org.bouncycastle.asn1.test.PolicyConstraintsTest",
            "org.bouncycastle.asn1.test.PrivateKeyInfoTest",
            "org.bouncycastle.asn1.test.LocaleTest",
            "org.bouncycastle.asn1.test.LinkedCertificateTest",
            "org.bouncycastle.asn1.test.DLExternalTest",
            "org.bouncycastle.asn1.test.KMACParamsTest",
            "org.bouncycastle.asn1.test.DERPrivateTest",
    };

    public void run() {
        System.out.println("run ct-asn1.");
        for (org.bouncycastle.util.test.Test test:simpleTests) {
            System.out.println("do " + test.getName());
            SimpleTestResult result = (SimpleTestResult) test.perform();
            if (!result.isSuccessful()) {
                if (result.getException() != null) {
                    result.getException().printStackTrace();
                }
                fail(result.toString());
            }
        }
        System.out.println("finish ct-asn1.");
    }

    public int getServiceFuncNum() {return serviceFuncNum;}

    public static void main(String[] args) {
        CTAsn1 ctAsn1 = new CTAsn1();
        ctAsn1.run();
    }
}
