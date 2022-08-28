package edu.lejacon.services;

import org.bouncycastle.util.utiltest.ArraysTest;
import org.bouncycastle.util.utiltest.BigIntegersTest;
import org.bouncycastle.util.utiltest.IPTest;

public class CTUtil {
    static int serviceFuncNum = 5;
    static IPTest ipTest = new IPTest();
    static BigIntegersTest bigIntegersTest = new BigIntegersTest();
    static ArraysTest arraysTest = new ArraysTest();

    public void run() {
        System.out.println("run ct-util.");
        ipTest.testIPv4();
        ipTest.testIPv6();
        bigIntegersTest.testAsUnsignedByteArray();
        bigIntegersTest.testFixedLengthUnsignedByteArray();
        arraysTest.testConcatenate();
        System.out.println("finish ct-util.");
    }
    public int getServiceFuncNum() {
        return serviceFuncNum;
    }

    public static void main(String[] args) {
        CTUtil ctUtil = new CTUtil();
        ctUtil.run();
    }
}
