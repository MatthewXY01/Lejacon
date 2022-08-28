package edu.lejacon.services;
public class APPPrint {
    static int serviceFuncNum = 1;
    public void run(){
        System.out.println("run app-print.");
        sayHello();
        System.out.println("finish app-print.");
    }
    public int getServiceFuncNum(){return serviceFuncNum;}
    public void sayHello(){
        System.out.println("Welcome to the enclave!");
        System.out.println("Try other applications~");
    }

    public static void main(String[] args) {
        APPPrint appPrint = new APPPrint();
        appPrint.run();
    }
}
