package edu.lejacon.services;

import org.bouncycastle.math.ec.test.ECAlgorithmsTest;
import org.bouncycastle.math.ec.test.ECPointTest;
import org.bouncycastle.math.ec.test.FixedPointTest;
import org.bouncycastle.math.raw.test.InterleaveTest;
import org.bouncycastle.math.test.PrimesTest;


public class CTMath {
    static int involvedTestClassNum=5;
    static int serviceFuncNum = 19;
    static String[] involvedTestClassList = {
            "org.bouncycastle.math.test.PrimesTest",
            "org.bouncycastle.math.ec.test.ECAlgorithmsTest",
            "org.bouncycastle.math.ec.test.ECPointTest",
            "org.bouncycastle.math.ec.test.FixedPointTest",
            "org.bouncycastle.math.raw.test.InterleaveTest"
    };
    static PrimesTest primesTest = new PrimesTest();

    static ECAlgorithmsTest ecAlgorithmsTest = new ECAlgorithmsTest();
    static ECPointTest ecPointTest = new ECPointTest();
    static FixedPointTest fixedPointTest = new FixedPointTest();

    static InterleaveTest interleaveTest = new InterleaveTest();

    public CTMath() {
        ecPointTest.setUp();
    }

    public void run() {
        System.out.println("run ct-math");
        primesTest.testHasAnySmallFactors();

        primesTest.testEnhancedMRProbablePrime();

        primesTest.testMRProbablePrime();

        primesTest.testMRProbablePrimeToBase();

        primesTest.testSTRandomPrime();

        ecAlgorithmsTest.testSumOfMultiplies();

        ecAlgorithmsTest.testSumOfTwoMultiplies();

        ecPointTest.testPointCreationConsistency();

        ecPointTest.testAdd();

        ecPointTest.testTwice();

        ecPointTest.testThreeTimes();

        ecPointTest.testAllPoints();

        ecPointTest.testAddSubtractMultiplySimple();

        try {
            ecPointTest.testExampleFpB0();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        fixedPointTest.testFixedPointMultiplier();

        interleaveTest.testExpand8To16();

        interleaveTest.testExpand16To32();

        interleaveTest.testExpand32To64();

        interleaveTest.testExpand64To128();
        System.out.println("finish ct-math.");

    }

    public int getServiceFuncNum() {
        return serviceFuncNum;
    }

    public static void main(String[] args) {
        CTMath ctMath = new CTMath();
        ctMath.run();
    }
}
