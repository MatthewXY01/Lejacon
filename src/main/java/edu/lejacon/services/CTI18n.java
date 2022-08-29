package edu.lejacon.services;

import org.bouncycastle.i18n.filter.test.HTMLFilterTest;
import org.bouncycastle.i18n.filter.test.SQLFilterTest;

public class CTI18n {
    static int involvedTestClassNum = 2;
    static int serviceFuncNum = 2;
    static HTMLFilterTest htmlFilterTest = new HTMLFilterTest();
    static SQLFilterTest sqlFilterTest = new SQLFilterTest();

    public int getServiceFuncNum(){return serviceFuncNum;}
    public void run(){
        System.out.println("run ct-i18n.");
        htmlFilterTest.testDoFilter();
        sqlFilterTest.testDoFilter();
        System.out.println("finish ct-i18n.");
    }

    public static void main(String[] args) {
        CTI18n cti18n = new CTI18n();
        cti18n.run();
    }
}
