# Lejacon
This repository currently contains the dataset used in the evaluation of Lejacon.

## Dataset
The dataset contains 4 mini applications (app): `app-print`, `app-digest`, `app-rsa` and `app-sqlparser`.
It also contains 6 BouncyCastle core-test (ct) benchmarks: `ct-asn1`, `ct-i18n`, `ct-util`, `ct-math`, `ct-pqc`, and `ct-crypto`.

The dependencies of applications/programs can be checked in the _pom_ file.
Specifically, the ct benchmarks are synthesized from 254 core tests in the BouncyCastle cryptography library; a subset of the 
BouncyCastle APIs is included and packaged into [bouncycastle-core-ut-4lejacon-1.0.jar](bouncycastle-core-ut-4lejacon-1.0.jar)

### Service Functionality
Each application/program in the dataset provides 1~168 starting confidential methods that are called in the form of service requests.
Each program in [this directory](src/main/java/edu/lejacon/services)
summarizes the confidential method(s) of the corresponding benchmark into a `run` method, to display the functionalities of the service more intuitively. 