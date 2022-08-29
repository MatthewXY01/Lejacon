Each program in the dataset runs as a service request in the experiment.  
Some applications/programs depend on some open sources libraries, which can be checked in the pom file.  
The attached `bouncycastle-core-ut-4lejacon-1.0.jar`
 is packaged based on the [bouncycastle v1.7.0](https://github.com/bcgit/bc-java/tree/r1rv70)
, on which the _ct-{asn1, i18n, util, math, pqc, crypto}_ benchmarks rely.