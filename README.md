# Lejacon
This repository contains the dataset used in the evaluation of Lejacon.

## Introduction
<div  align="center">    
<img src="docs/images/arch_overview.png" width="40%" height="40%" alt="architecture_overview" />
</div>

[//]: # (![]&#40;docs/images/arch_overview.png&#41;)
Intel SGX is a promising confidential computing technique and popular in the development of confidential cloud services.
As numerous cloud applications are written in Java, which is not inherently supported by the SGX enclave,
state-of-the-art approaches deploy JVMs in enclaves to support Java confidential computing.
This workaround suffers from limitations such as large TCB size and heavy overheads of running JVMs in enclaves.

We propose Lejacon that provides a lightweight and efficient approach to Java confidential computing on SGX:
given a Java application, Lejacon
(1) separately compiles its confidential computing tasks into a bundle of Native Confidential Computing (NCC) services;
(2) runs the NCC services in enclaves on the Trusted Execution Environment (TEE) side, and meanwhile run the non-confidential code on a JVM on the Rich Execution Environment (REE) side.
The two sides interact with each other, protecting confidential computing tasks and as well keeping the Trusted Computing Base (TCB) size small.


## Dataset
The dataset contains 4 mini applications (app): `app-print`, `app-digest`, `app-rsa` and `app-sqlparser`.
It also contains 6 BouncyCastle core-test (ct) benchmarks: `ct-asn1`, `ct-i18n`, `ct-util`, `ct-math`, `ct-pqc`, and `ct-crypto`.

The dependencies of applications/programs can be checked in the [pom](pom.xml) file.
Specifically, the ct benchmarks are synthesized from 254 core tests in the BouncyCastle cryptography library; a subset of the 
BouncyCastle APIs is included and packaged into [bouncycastle-core-ut-4lejacon-1.0.jar](bouncycastle-core-ut-4lejacon-1.0.jar).

### Service Functionality
Each application/program in the dataset provides 1~168 starting confidential methods that are called in the form of service requests.
Each program in [this directory](src/main/java/edu/lejacon/services)
summarizes the confidential method(s) of the corresponding benchmark into a `run` method, to display the functionalities of the service more intuitively.

### Service Example
An example of Hash service using BouncyCastle APIs.
#### HashService.java (in TEE)
```java
package edu.lejacon.example.enclave;
import edu.lejacon.enclave.annotations.EnclaveService;

@EnclaveService
public interface HashService {
    String getHashValue(String alg, String message);
}
```
#### HashServiceImpl.java (in TEE)

```java
package edu.lejacon.example.enclave;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;

public class HashServiceImpl implements HashService {
    private final Provider PROVIDER;

    public HashServiceImpl() {
        Provider provider = Security.getProvider("BC");
        PROVIDER = provider != null ? provider : new BouncyCastleProvider();
        Security.addProvider(PROVIDER);
    }

    @Override
    public String getHashValue(String alg, String message) {
        String result;
        if (message == null) return "Null message!";
        byte[] msgBytes = message.getBytes();
        try {
            MessageDigest md = MessageDigest.getInstance(alg, "BC");
            System.out.println(alg + " provider: " + md.getProvider());
            result = doHash(md, msgBytes);
        } catch (Exception e) {
            System.out.println(e);
            result = "Unsupported hash algorithms!";
        }
        return result;
    }

    private String doHash(MessageDigest md, byte[] msgBytes) {
        md.update(msgBytes);
        return bytesToHex(md.digest());
    }

    private String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
```
#### App.java (in REE)
```java
package edu.lejacon.example.host;

import java.util.Iterator;
import java.io.IOException;
import java.nio.file.*;
import edu.lejacon.example.enclave.HashService;
import edu.lejacon.enclave.Enclave;
import edu.lejacon.enclave.EnclaveFactory;

public class App {
    private static String readUsingFiles(String fileName) {
        try {
            return new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args) throws Exception {
        String fpath = args[1];
        String alg = args[0];
        String message = readUsingFiles(fpath);
        Enclave enclave = EnclaveFactory.create();
        Iterator<HashService> services = enclave.load(HashService.class);
        while (services.hasNext()) {
            HashService service = services.next();
            System.out.println("request service: " + alg);
            String result = service.getHashValue(alg, message);
            System.out.println(result);
        }
        enclave.destroy();
    }
}
```
In this example, `HashService` is compiled into the Native Confidential Computing (NCC) service.
The `getHashValue` method is a starting confidential method that can be called through ECall.
`getHashValue` is executed in the TEE side, as well as the call chain inside such as [`doHash` &rarr; `bytesToHex`].  

#### Demo
A demo of running the above Hash service on OcclumJ (_left_) and Lejacon (_right_).

<center class="half">

<img src="docs/images/demo_hash_occlumj.gif" width="48%" height="48%"/> <img src="docs/images/demo_hash_lejacon.gif" width="48%" height="48%"/>

</center>

## Experiment Result
The table below lists the execution times for each benchmark on the baseline (BaseJ), OcclumJ and Lejacon.

<table border="0" cellpadding="0" cellspacing="0" id="sheet0" class="sheet0 gridlines">
    <col class="col0">
    <col class="col1">
    <col class="col2">
    <col class="col3">
    <col class="col4">
    <col class="col5">
    <col class="col6">
    <col class="col7">
    <col class="col8">
    <col class="col9">
    <tbody>
      <tr class="row0">
        <td class="column0 style20 s style21" rowspan="2">Benchmark</td>
        <td class="column1 style18 s" style="text-align:center">BaseJ</td>
        <td class="column2 style13 s style17" colspan="4" style="text-align:center">OcclumJ</td>
        <td class="column6 style22 s style24" colspan="4" style="text-align:center">Lejacon</td>
      </tr>
      <tr class="row1">
        <td class="column1 style2 s">ET (ms)</td>
        <td class="column2 style1 s">ET (ms)</td>
        <td class="column3 style1 s">ET_0 (ms)</td>
        <td class="column4 style1 s">ET_1 (ms)</td>
        <td class="column5 style2 s">ET_2 (ms)</td>
        <td class="column6 style1 s">ET (ms)</td>
        <td class="column7 style1 s">ET_0 (ms)</td>
        <td class="column8 style1 s">ET_1 (ms)</td>
        <td class="column9 style2 s">ET_2 (ms)</td>
      </tr>
      <tr class="row2">
        <td class="column0 style19 s">app-print</td>
        <td class="column1 style3 s">&lt;0.05</td>
        <td class="column2 style4 n">6158.2</td>
        <td class="column3 style4 s">&lt;0.05</td>
        <td class="column4 style4 n">14.2</td>
        <td class="column5 style3 n">6143.2</td>
        <td class="column6 style4 n">384.7</td>
        <td class="column7 style4 s">&lt;0.05</td>
        <td class="column8 style4 s">&lt;0.05</td>
        <td class="column9 style3 n">383.4</td>
      </tr>
      <tr class="row3">
        <td class="column0 style5 s">app-digest</td>
        <td class="column1 style6 n">171.1</td>
        <td class="column2 style7 n">8902.5</td>
        <td class="column3 style7 n">382.2</td>
        <td class="column4 style7 n">160.8</td>
        <td class="column5 style8 n">8352.2</td>
        <td class="column6 style7 n">984</td>
        <td class="column7 style7 n">105.7</td>
        <td class="column8 style7 n">80.5</td>
        <td class="column9 style8 n">777.9</td>
      </tr>
      <tr class="row4">
        <td class="column0 style5 s">app-rsa</td>
        <td class="column1 style6 n">345.4</td>
        <td class="column2 style7 n">6779.6</td>
        <td class="column3 style7 n">629.2</td>
        <td class="column4 style7 n">30</td>
        <td class="column5 style8 n">6119.3</td>
        <td class="column6 style7 n">1146.6</td>
        <td class="column7 style7 n">574.4</td>
        <td class="column8 style7 n">2.2</td>
        <td class="column9 style8 n">568.9</td>
      </tr>
      <tr class="row5">
        <td class="column0 style5 s">app-sqlparser</td>
        <td class="column1 style6 n">230.6</td>
        <td class="column2 style7 n">6466.8</td>
        <td class="column3 style7 n">327.4</td>
        <td class="column4 style7 n">28.1</td>
        <td class="column5 style8 n">6110.5</td>
        <td class="column6 style7 n">452.9</td>
        <td class="column7 style7 n">3.3</td>
        <td class="column8 style7 n">0.7</td>
        <td class="column9 style8 n">447.9</td>
      </tr>
      <tr class="row6">
        <td class="column0 style5 s">ct-asn1</td>
        <td class="column1 style6 n">749.5</td>
        <td class="column2 style7 n">7746.3</td>
        <td class="column3 style7 n">1493</td>
        <td class="column4 style7 n">65.7</td>
        <td class="column5 style8 n">6170.7</td>
        <td class="column6 style7 n">612.9</td>
        <td class="column7 style7 n">99</td>
        <td class="column8 style7 n">11.7</td>
        <td class="column9 style8 n">499.7</td>
      </tr>
      <tr class="row7">
        <td class="column0 style5 s">ct-i18n</td>
        <td class="column1 style6 s">&lt;0.05</td>
        <td class="column2 style7 n">6191.3</td>
        <td class="column3 style7 n">1.1</td>
        <td class="column4 style7 n">14</td>
        <td class="column5 style8 n">6152.6</td>
        <td class="column6 style7 n">500.3</td>
        <td class="column7 style7 s">&lt;0.05</td>
        <td class="column8 style7 n">0.2</td>
        <td class="column9 style8 n">497.3</td>
      </tr>
      <tr class="row8">
        <td class="column0 style5 s">ct-util</td>
        <td class="column1 style6 n">2.4</td>
        <td class="column2 style7 n">6154.6</td>
        <td class="column3 style7 n">6.1</td>
        <td class="column4 style7 n">17.1</td>
        <td class="column5 style8 n">6113.2</td>
        <td class="column6 style7 n">491.6</td>
        <td class="column7 style7 n">0.3</td>
        <td class="column8 style7 n">1.7</td>
        <td class="column9 style8 n">487.7</td>
      </tr>
      <tr class="row9">
        <td class="column0 style5 s">ct-math</td>
        <td class="column1 style14 n">4259</td>
        <td class="column2 style7 n">14537.5</td>
        <td class="column3 style7 n">7362.1</td>
        <td class="column4 style7 n">52.7</td>
        <td class="column5 style8 n">7098.7</td>
        <td class="column6 style7 n">8713.9</td>
        <td class="column7 style7 n">7037.7</td>
        <td class="column8 style7 n">9.2</td>
        <td class="column9 style8 n">1664.2</td>
      </tr>
      <tr class="row10">
        <td class="column0 style5 s">ct-pqc</td>
        <td class="column1 style6 n">10491</td>
        <td class="column2 style15 n">20856.4</td>
        <td class="column3 style7 n">13563.7</td>
        <td class="column4 style7 n">128.4</td>
        <td class="column5 style8 n">7144.8</td>
        <td class="column6 style7 n">15617.6</td>
        <td class="column7 style7 n">13929.9</td>
        <td class="column8 style7 n">32.6</td>
        <td class="column9 style16 n">1652.9</td>
      </tr>
      <tr class="row11">
        <td class="column0 style9 s">ct-crypto</td>
        <td class="column1 style10 n">12460</td>
        <td class="column2 style11 n">27563.4</td>
        <td class="column3 style11 n">20047.8</td>
        <td class="column4 style11 n">170</td>
        <td class="column5 style12 n">7328.3</td>
        <td class="column6 style11 n">25776.3</td>
        <td class="column7 style11 n">24013</td>
        <td class="column8 style11 n">45</td>
        <td class="column9 style12 n">1715.9</td>
      </tr>
    </tbody>
</table>