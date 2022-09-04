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