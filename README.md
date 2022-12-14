# DynamoDbVersionAttribute-test

Sample project to reproduce error while using `@DynamoDBVersionAttribute` with `quarkus-amazon-dynamodb-enhanced` extension in native mode.

https://github.com/quarkiverse/quarkus-amazon-services/issues/416

Non-native:

```
./mvnw install
[INFO] Scanning for projects...
[INFO]
[INFO] ----------------< org.acme:amazon-dynamodb-quickstart >-----------------
[INFO] Building amazon-dynamodb-quickstart 1.0.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ amazon-dynamodb-quickstart ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 3 resources
[INFO]
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ amazon-dynamodb-quickstart ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ amazon-dynamodb-quickstart ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /Users/martin.grammelspacher/idea/DynamoDbVersionAttribute-test/src/test/resources
[INFO]
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ amazon-dynamodb-quickstart ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-surefire-plugin:3.0.0-M7:test (default-test) @ amazon-dynamodb-quickstart ---
[INFO] Using auto detected provider org.apache.maven.surefire.junitplatform.JUnitPlatformProvider
[INFO]
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running org.acme.dynamodb.DynamodbResourcesTest
2022-12-13 22:05:15,035 INFO  [org.tes.doc.DockerClientProviderStrategy] (build-35) Loaded org.testcontainers.dockerclient.UnixSocketClientProviderStrategy from ~/.testcontainers.properties, will try it first
2022-12-13 22:05:15,631 INFO  [org.tes.doc.DockerClientProviderStrategy] (build-35) Found Docker environment with local Unix socket (unix:///var/run/docker.sock)
2022-12-13 22:05:15,634 INFO  [org.tes.DockerClientFactory] (build-35) Docker host IP address is localhost
2022-12-13 22:05:15,668 INFO  [org.tes.DockerClientFactory] (build-35) Connected to docker:
  Server Version: 20.10.13
  API Version: 1.41
  Operating System: Docker Desktop
  Total Memory: 4933 MB
2022-12-13 22:05:15,676 INFO  [org.tes.uti.ImageNameSubstitutor] (build-35) Image name substitution will be performed by: DefaultImageNameSubstitutor (composite of 'ConfigurationFileImageNameSubstitutor' and 'PrefixingImageNameSubstitutor')
2022-12-13 22:05:15,679 INFO  [org.tes.DockerClientFactory] (build-35) Checking the system...
2022-12-13 22:05:15,680 INFO  [org.tes.DockerClientFactory] (build-35) ✔︎ Docker server version should be at least 1.6.0
2022-12-13 22:05:15,871 INFO  [org.tes.doc.DockerClientProviderStrategy] (pool-3-thread-1) Loaded org.testcontainers.dockerclient.UnixSocketClientProviderStrategy from ~/.testcontainers.properties, will try it first
2022-12-13 22:05:16,308 INFO  [org.tes.doc.DockerClientProviderStrategy] (pool-3-thread-1) Found Docker environment with local Unix socket (unix:///var/run/docker.sock)
2022-12-13 22:05:16,315 INFO  [org.tes.DockerClientFactory] (pool-3-thread-1) Docker host IP address is localhost
2022-12-13 22:05:16,347 INFO  [org.tes.DockerClientFactory] (pool-3-thread-1) Connected to docker:
  Server Version: 20.10.13
  API Version: 1.41
  Operating System: Docker Desktop
  Total Memory: 4933 MB
2022-12-13 22:05:16,356 INFO  [org.tes.uti.ImageNameSubstitutor] (pool-3-thread-1) Image name substitution will be performed by: DefaultImageNameSubstitutor (composite of 'ConfigurationFileImageNameSubstitutor' and 'PrefixingImageNameSubstitutor')
2022-12-13 22:05:16,413 INFO  [🐳 .3.4]] (pool-3-thread-1) Creating container for image: testcontainers/ryuk:0.3.4
2022-12-13 22:05:16,567 INFO  [org.tes.uti.RegistryAuthLocator] (pool-3-thread-1) Credential helper/store (docker-credential-desktop) does not have credentials for https://index.docker.io/v1/
2022-12-13 22:05:16,724 INFO  [🐳 .3.4]] (pool-3-thread-1) Container testcontainers/ryuk:0.3.4 is starting: 23a164f7773aa3f0b173061f384fc5c13100a05a11e3aa7ede0fb19c1290eac0
2022-12-13 22:05:17,346 INFO  [🐳 .3.4]] (pool-3-thread-1) Container testcontainers/ryuk:0.3.4 started in PT0.985104S
2022-12-13 22:05:17,364 INFO  [org.tes.uti.RyukResourceReaper] (pool-3-thread-1) Ryuk started - will monitor and terminate Testcontainers containers on JVM exit
2022-12-13 22:05:17,364 INFO  [org.tes.DockerClientFactory] (pool-3-thread-1) Checking the system...
2022-12-13 22:05:17,365 INFO  [org.tes.DockerClientFactory] (pool-3-thread-1) ✔︎ Docker server version should be at least 1.6.0
2022-12-13 22:05:17,369 INFO  [🐳 .2.0]] (pool-3-thread-1) HOSTNAME_EXTERNAL environment variable set to localhost (to match host-routable address for container)
2022-12-13 22:05:17,370 INFO  [🐳 .2.0]] (pool-3-thread-1) Creating container for image: localstack/localstack:1.2.0
2022-12-13 22:05:18,915 INFO  [🐳 .2.0]] (pool-3-thread-1) Container localstack/localstack:1.2.0 is starting: 19b33482cb9195212bf6e7f8e6dd071b48748eaa8e3fc06e41baecf493a56a5d
2022-12-13 22:05:22,864 INFO  [🐳 .2.0]] (pool-3-thread-1) Container localstack/localstack:1.2.0 started in PT5.494068S
2022-12-13 22:05:22,925 WARN  [sof.ama.aws.pro.int.ProfileFileReader] (pool-3-thread-1) Ignoring profile 'saml' on line 1 because it did not start with 'profile ' and it was not 'default'.
2022-12-13 22:05:26,384 INFO  [io.quarkus] (main) amazon-dynamodb-quickstart 1.0.0-SNAPSHOT on JVM (powered by Quarkus 2.14.3.Final) started in 12.946s. Listening on: http://localhost:8081
2022-12-13 22:05:26,385 INFO  [io.quarkus] (main) Profile test activated.
2022-12-13 22:05:26,385 INFO  [io.quarkus] (main) Installed features: [amazon-dynamodb, amazon-dynamodb-enhanced, cdi, resteasy-reactive, resteasy-reactive-jackson, smallrye-context-propagation, vertx]
2022-12-13 22:05:27,088 WARN  [sof.ama.aws.pro.int.ProfileFileReader] (executor-thread-0) Ignoring profile 'saml' on line 1 because it did not start with 'profile ' and it was not 'default'.
2022-12-13 22:05:27,098 WARN  [sof.ama.aws.pro.int.ProfileFileReader] (executor-thread-0) Ignoring profile 'saml' on line 1 because it did not start with 'profile ' and it was not 'default'.
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 16.015 s - in org.acme.dynamodb.DynamodbResourcesTest
2022-12-13 22:05:30,791 INFO  [io.quarkus] (main) amazon-dynamodb-quickstart stopped in 2.121s
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO]
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ amazon-dynamodb-quickstart ---
[INFO]
[INFO] --- quarkus-maven-plugin:2.14.3.Final:build (default) @ amazon-dynamodb-quickstart ---
[INFO] [io.quarkus.deployment.QuarkusAugmentor] Quarkus augmentation completed in 1743ms
[INFO]
[INFO] --- maven-install-plugin:2.4:install (default-install) @ amazon-dynamodb-quickstart ---
[INFO] Installing /Users/martin.grammelspacher/idea/DynamoDbVersionAttribute-test/target/amazon-dynamodb-quickstart-1.0.0-SNAPSHOT.jar to /Users/martin.grammelspacher/.m2/repository/org/acme/amazon-dynamodb-quickstart/1.0.0-SNAPSHOT/amazon-dynamodb-quickstart-1.0.0-SNAPSHOT.jar
[INFO] Installing /Users/martin.grammelspacher/idea/DynamoDbVersionAttribute-test/pom.xml to /Users/martin.grammelspacher/.m2/repository/org/acme/amazon-dynamodb-quickstart/1.0.0-SNAPSHOT/amazon-dynamodb-quickstart-1.0.0-SNAPSHOT.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  22.959 s
[INFO] Finished at: 2022-12-13T22:05:33+01:00
[INFO] ------------------------------------------------------------------------
```

Native:

```
mvn install -Dnative
[INFO] Scanning for projects...
[INFO]
[INFO] ----------------< org.acme:amazon-dynamodb-quickstart >-----------------
[INFO] Building amazon-dynamodb-quickstart 1.0.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ amazon-dynamodb-quickstart ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 3 resources
[INFO]
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ amazon-dynamodb-quickstart ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ amazon-dynamodb-quickstart ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /Users/martin.grammelspacher/idea/DynamoDbVersionAttribute-test/src/test/resources
[INFO]
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ amazon-dynamodb-quickstart ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-surefire-plugin:3.0.0-M7:test (default-test) @ amazon-dynamodb-quickstart ---
[INFO] Using auto detected provider org.apache.maven.surefire.junitplatform.JUnitPlatformProvider
[INFO]
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running org.acme.dynamodb.DynamodbResourcesTest
2022-12-13 16:40:53,082 INFO  [org.tes.doc.DockerClientProviderStrategy] (build-77) Loaded org.testcontainers.dockerclient.UnixSocketClientProviderStrategy from ~/.testcontainers.properties, will try it first
2022-12-13 16:40:53,530 INFO  [org.tes.doc.DockerClientProviderStrategy] (build-77) Found Docker environment with local Unix socket (unix:///var/run/docker.sock)
2022-12-13 16:40:53,531 INFO  [org.tes.DockerClientFactory] (build-77) Docker host IP address is localhost
2022-12-13 16:40:53,548 INFO  [org.tes.DockerClientFactory] (build-77) Connected to docker:
  Server Version: 20.10.13
  API Version: 1.41
  Operating System: Docker Desktop
  Total Memory: 4933 MB
2022-12-13 16:40:53,555 INFO  [org.tes.uti.ImageNameSubstitutor] (build-77) Image name substitution will be performed by: DefaultImageNameSubstitutor (composite of 'ConfigurationFileImageNameSubstitutor' and 'PrefixingImageNameSubstitutor')
2022-12-13 16:40:53,557 INFO  [org.tes.DockerClientFactory] (build-77) Checking the system...
2022-12-13 16:40:53,557 INFO  [org.tes.DockerClientFactory] (build-77) ✔︎ Docker server version should be at least 1.6.0
2022-12-13 16:40:53,669 INFO  [org.tes.doc.DockerClientProviderStrategy] (pool-3-thread-1) Loaded org.testcontainers.dockerclient.UnixSocketClientProviderStrategy from ~/.testcontainers.properties, will try it first
2022-12-13 16:40:54,063 INFO  [org.tes.doc.DockerClientProviderStrategy] (pool-3-thread-1) Found Docker environment with local Unix socket (unix:///var/run/docker.sock)
2022-12-13 16:40:54,064 INFO  [org.tes.DockerClientFactory] (pool-3-thread-1) Docker host IP address is localhost
2022-12-13 16:40:54,080 INFO  [org.tes.DockerClientFactory] (pool-3-thread-1) Connected to docker:
  Server Version: 20.10.13
  API Version: 1.41
  Operating System: Docker Desktop
  Total Memory: 4933 MB
2022-12-13 16:40:54,088 INFO  [org.tes.uti.ImageNameSubstitutor] (pool-3-thread-1) Image name substitution will be performed by: DefaultImageNameSubstitutor (composite of 'ConfigurationFileImageNameSubstitutor' and 'PrefixingImageNameSubstitutor')
2022-12-13 16:40:54,134 INFO  [🐳 .3.4]] (pool-3-thread-1) Creating container for image: testcontainers/ryuk:0.3.4
2022-12-13 16:40:54,225 INFO  [org.tes.uti.RegistryAuthLocator] (pool-3-thread-1) Credential helper/store (docker-credential-desktop) does not have credentials for https://index.docker.io/v1/
2022-12-13 16:40:54,301 INFO  [🐳 .3.4]] (pool-3-thread-1) Container testcontainers/ryuk:0.3.4 is starting: efd56f153e08c7d49c7c7af6e93e5500b0f6757e0ca2d292fc6a58e9e646f761
2022-12-13 16:40:54,798 INFO  [🐳 .3.4]] (pool-3-thread-1) Container testcontainers/ryuk:0.3.4 started in PT0.691466S
2022-12-13 16:40:54,809 INFO  [org.tes.uti.RyukResourceReaper] (pool-3-thread-1) Ryuk started - will monitor and terminate Testcontainers containers on JVM exit
2022-12-13 16:40:54,809 INFO  [org.tes.DockerClientFactory] (pool-3-thread-1) Checking the system...
2022-12-13 16:40:54,809 INFO  [org.tes.DockerClientFactory] (pool-3-thread-1) ✔︎ Docker server version should be at least 1.6.0
2022-12-13 16:40:54,812 INFO  [🐳 .2.0]] (pool-3-thread-1) HOSTNAME_EXTERNAL environment variable set to localhost (to match host-routable address for container)
2022-12-13 16:40:54,813 INFO  [🐳 .2.0]] (pool-3-thread-1) Creating container for image: localstack/localstack:1.2.0
2022-12-13 16:40:55,434 INFO  [🐳 .2.0]] (pool-3-thread-1) Container localstack/localstack:1.2.0 is starting: fe226f7905b455a30bc5047bf8ab9f8ea6d0777ccaa7018ecc28ae552a50e3bc
2022-12-13 16:40:58,331 INFO  [🐳 .2.0]] (pool-3-thread-1) Container localstack/localstack:1.2.0 started in PT3.518144S
2022-12-13 16:40:58,402 WARN  [sof.ama.aws.pro.int.ProfileFileReader] (pool-3-thread-1) Ignoring profile 'saml' on line 1 because it did not start with 'profile ' and it was not 'default'.
2022-12-13 16:41:00,729 INFO  [io.quarkus] (main) amazon-dynamodb-quickstart 1.0.0-SNAPSHOT on JVM (powered by Quarkus 2.14.3.Final) started in 8.499s. Listening on: http://localhost:8081
2022-12-13 16:41:00,729 INFO  [io.quarkus] (main) Profile test activated.
2022-12-13 16:41:00,729 INFO  [io.quarkus] (main) Installed features: [amazon-dynamodb, amazon-dynamodb-enhanced, cdi, resteasy-reactive, resteasy-reactive-jackson, smallrye-context-propagation, vertx]
2022-12-13 16:41:01,441 WARN  [sof.ama.aws.pro.int.ProfileFileReader] (executor-thread-0) Ignoring profile 'saml' on line 1 because it did not start with 'profile ' and it was not 'default'.
2022-12-13 16:41:01,448 WARN  [sof.ama.aws.pro.int.ProfileFileReader] (executor-thread-0) Ignoring profile 'saml' on line 1 because it did not start with 'profile ' and it was not 'default'.
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 11.088 s - in org.acme.dynamodb.DynamodbResourcesTest
2022-12-13 16:41:05,062 INFO  [io.quarkus] (main) amazon-dynamodb-quickstart stopped in 2.101s
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO]
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ amazon-dynamodb-quickstart ---
[INFO]
[INFO] --- quarkus-maven-plugin:2.14.3.Final:build (default) @ amazon-dynamodb-quickstart ---
[INFO] [io.quarkus.deployment.pkg.steps.JarResultBuildStep] Building native image source jar: /Users/martin.grammelspacher/idea/DynamoDbVersionAttribute-test/target/amazon-dynamodb-quickstart-1.0.0-SNAPSHOT-native-image-source-jar/amazon-dynamodb-quickstart-1.0.0-SNAPSHOT-runner.jar
[INFO] [io.quarkus.deployment.pkg.steps.NativeImageBuildStep] Building native image from /Users/martin.grammelspacher/idea/DynamoDbVersionAttribute-test/target/amazon-dynamodb-quickstart-1.0.0-SNAPSHOT-native-image-source-jar/amazon-dynamodb-quickstart-1.0.0-SNAPSHOT-runner.jar
[INFO] [io.quarkus.deployment.pkg.steps.NativeImageBuildStep] Running Quarkus native-image plugin on GraalVM 22.3.0-dev Java 11 CE (Java Version 11.0.17+3-jvmci-22.3-b04)
[INFO] [io.quarkus.deployment.pkg.steps.NativeImageBuildRunner] /Library/Java/JavaVirtualMachines/graalvm-ce-java11-22.3.0-dev/Contents/Home/bin/native-image -J-Djava.util.logging.manager=org.jboss.logmanager.LogManager -J-Dsun.nio.ch.maxUpdateArraySize=100 -J-Dlogging.initial-configurator.min-level=500 -J-Dio.netty.leakDetection.level=DISABLED -J-Dio.netty.allocator.maxOrder=3 -J-Dvertx.logger-delegate-factory-class-name=io.quarkus.vertx.core.runtime.VertxLogDelegateFactory -J-Dvertx.disableDnsResolver=true -J-Duser.language=de -J-Duser.country=DE -J-Dfile.encoding=UTF-8 --features=io.quarkus.runner.Feature,io.quarkus.runtime.graal.ResourcesFeature,io.quarkus.runtime.graal.DisableLoggingFeature -J--add-exports=java.security.jgss/sun.security.krb5=ALL-UNNAMED -J--add-opens=java.base/java.text=ALL-UNNAMED -J--add-opens=java.base/java.io=ALL-UNNAMED -J--add-opens=java.base/java.lang.invoke=ALL-UNNAMED -J--add-opens=java.base/java.util=ALL-UNNAMED -H:+CollectImageBuildStatistics -H:ImageBuildStatisticsFile=amazon-dynamodb-quickstart-1.0.0-SNAPSHOT-runner-timing-stats.json -H:BuildOutputJSONFile=amazon-dynamodb-quickstart-1.0.0-SNAPSHOT-runner-build-output-stats.json -H:+AllowFoldMethods -J-Djava.awt.headless=true --no-fallback --link-at-build-time -H:+ReportExceptionStackTraces -H:-AddAllCharsets --enable-url-protocols=http,https -H:-UseServiceLoaderFeature -H:+StackTrace -J--add-exports=org.graalvm.sdk/org.graalvm.nativeimage.impl=ALL-UNNAMED -J--add-exports=org.graalvm.nativeimage.builder/com.oracle.svm.core.jdk=ALL-UNNAMED amazon-dynamodb-quickstart-1.0.0-SNAPSHOT-runner -jar amazon-dynamodb-quickstart-1.0.0-SNAPSHOT-runner.jar
Warning: Using a deprecated option --allow-incomplete-classpath from 'META-INF/native-image/software.amazon.awssdk/netty-nio-client/native-image.properties' in 'file:///Users/martin.grammelspacher/idea/DynamoDbVersionAttribute-test/target/amazon-dynamodb-quickstart-1.0.0-SNAPSHOT-native-image-source-jar/lib/software.amazon.awssdk.netty-nio-client-2.17.291.jar'. Allowing an incomplete classpath is now the default. Use --link-at-build-time to report linking errors at image build time for a class or package.
========================================================================================================================
GraalVM Native Image: Generating 'amazon-dynamodb-quickstart-1.0.0-SNAPSHOT-runner' (executable)...
========================================================================================================================
[1/7] Initializing...                                                                                   (11,3s @ 0,16GB)
 Version info: 'GraalVM 22.3.0-dev Java 11 CE'
 Java version info: '11.0.17+3-jvmci-22.3-b04'
 C compiler: cc (apple, arm64, 12.0.5)
 Garbage collector: Serial GC
 3 user-specific feature(s)
 - io.quarkus.runner.Feature: Auto-generated class by Quarkus from the existing extensions
 - io.quarkus.runtime.graal.DisableLoggingFeature: Disables INFO logging during the analysis phase for the [org.jboss.threads] categories
 - io.quarkus.runtime.graal.ResourcesFeature: Register each line in META-INF/quarkus-native-resources.txt as a resource on Substrate VM
[2/7] Performing analysis...  [WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by io.netty.util.internal.ReflectionUtil (file:/Users/martin.grammelspacher/idea/DynamoDbVersionAttribute-test/target/amazon-dynamodb-quickstart-1.0.0-SNAPSHOT-native-image-source-jar/lib/io.netty.netty-common-4.1.82.Final.jar) to constructor java.nio.DirectByteBuffer(long,int)
WARNING: Please consider reporting this to the maintainers of io.netty.util.internal.ReflectionUtil
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
*********]                                                               (58,0s @ 2,25GB)
  15.520 (90,69%) of 17.113 classes reachable
  22.287 (59,19%) of 37.655 fields reachable
  75.427 (58,41%) of 129.131 methods reachable
     472 classes,   615 fields, and 1.839 methods registered for reflection
      69 classes,    89 fields, and    55 methods registered for JNI access
       6 native libraries: -framework CoreServices, -framework Foundation, dl, pthread, stdc++, z
[3/7] Building universe...                                                                               (5,1s @ 4,85GB)
[4/7] Parsing methods...      [***]                                                                      (9,1s @ 1,17GB)
[5/7] Inlining methods...     [***]                                                                      (1,2s @ 3,11GB)
[6/7] Compiling methods...    [*****]                                                                   (24,0s @ 2,37GB)
[7/7] Creating image...                                                                                  (5,1s @ 4,56GB)
  27,16MB (36,49%) for code area:    47.248 compilation units
  46,27MB (62,15%) for image heap:  388.495 objects and 3.755 resources
   1,02MB ( 1,37%) for other data
  74,44MB in total
------------------------------------------------------------------------------------------------------------------------
Top 10 packages in code area:                               Top 10 object types in image heap:
   1,58MB sun.security.ssl                                    15,86MB byte[] for embedded resources
   1,08MB java.lang.invoke                                     5,93MB byte[] for code metadata
1000,55KB java.util                                            3,57MB java.lang.Class
 666,64KB com.sun.crypto.provider                              3,20MB java.lang.String
 479,63KB java.lang                                            3,05MB byte[] for java.lang.String
 477,36KB com.sun.org.apache.xerces.internal.impl              2,84MB byte[] for general heap data
 467,41KB io.netty.buffer                                      1,42MB com.oracle.svm.core.hub.DynamicHubCompanion
 466,27KB c.s.org.apache.xerces.internal.impl.xs.traversers  830,58KB java.util.HashMap$Node
 464,32KB sun.security.x509                                  740,65KB byte[] for reflection metadata
 446,63KB io.netty.handler.codec.http2                       720,15KB java.lang.Object[]
  19,87MB for 579 more packages                                7,47MB for 4222 more object types
------------------------------------------------------------------------------------------------------------------------
                       13,8s (11,6% of total time) in 36 GCs | Peak RSS: 4,02GB | CPU load: 3,22
------------------------------------------------------------------------------------------------------------------------
Produced artifacts:
 /Users/martin.grammelspacher/idea/DynamoDbVersionAttribute-test/target/amazon-dynamodb-quickstart-1.0.0-SNAPSHOT-native-image-source-jar/amazon-dynamodb-quickstart-1.0.0-SNAPSHOT-runner (executable)
 /Users/martin.grammelspacher/idea/DynamoDbVersionAttribute-test/target/amazon-dynamodb-quickstart-1.0.0-SNAPSHOT-native-image-source-jar/amazon-dynamodb-quickstart-1.0.0-SNAPSHOT-runner-build-output-stats.json (json)
 /Users/martin.grammelspacher/idea/DynamoDbVersionAttribute-test/target/amazon-dynamodb-quickstart-1.0.0-SNAPSHOT-native-image-source-jar/amazon-dynamodb-quickstart-1.0.0-SNAPSHOT-runner-timing-stats.json (raw)
 /Users/martin.grammelspacher/idea/DynamoDbVersionAttribute-test/target/amazon-dynamodb-quickstart-1.0.0-SNAPSHOT-native-image-source-jar/amazon-dynamodb-quickstart-1.0.0-SNAPSHOT-runner.build_artifacts.txt (txt)
========================================================================================================================
Finished generating 'amazon-dynamodb-quickstart-1.0.0-SNAPSHOT-runner' in 1m 58s.
[INFO] [io.quarkus.deployment.QuarkusAugmentor] Quarkus augmentation completed in 121608ms
[INFO]
[INFO] --- maven-failsafe-plugin:3.0.0-M7:integration-test (default) @ amazon-dynamodb-quickstart ---
[INFO] Using auto detected provider org.apache.maven.surefire.junitplatform.JUnitPlatformProvider
[INFO]
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running org.acme.dynamodb.DynamodbResourcesIT
2022-12-13 16:43:09,792 INFO  [org.tes.doc.DockerClientProviderStrategy] (build-10) Loaded org.testcontainers.dockerclient.UnixSocketClientProviderStrategy from ~/.testcontainers.properties, will try it first
2022-12-13 16:43:10,201 INFO  [org.tes.doc.DockerClientProviderStrategy] (build-10) Found Docker environment with local Unix socket (unix:///var/run/docker.sock)
2022-12-13 16:43:10,202 INFO  [org.tes.DockerClientFactory] (build-10) Docker host IP address is localhost
2022-12-13 16:43:10,221 INFO  [org.tes.DockerClientFactory] (build-10) Connected to docker:
  Server Version: 20.10.13
  API Version: 1.41
  Operating System: Docker Desktop
  Total Memory: 4933 MB
2022-12-13 16:43:10,228 INFO  [org.tes.uti.ImageNameSubstitutor] (build-10) Image name substitution will be performed by: DefaultImageNameSubstitutor (composite of 'ConfigurationFileImageNameSubstitutor' and 'PrefixingImageNameSubstitutor')
2022-12-13 16:43:10,230 INFO  [org.tes.DockerClientFactory] (build-10) Checking the system...
2022-12-13 16:43:10,230 INFO  [org.tes.DockerClientFactory] (build-10) ✔︎ Docker server version should be at least 1.6.0
2022-12-13 16:43:10,273 INFO  [org.tes.doc.DockerClientProviderStrategy] (pool-3-thread-1) Loaded org.testcontainers.dockerclient.UnixSocketClientProviderStrategy from ~/.testcontainers.properties, will try it first
2022-12-13 16:43:10,630 INFO  [org.tes.doc.DockerClientProviderStrategy] (pool-3-thread-1) Found Docker environment with local Unix socket (unix:///var/run/docker.sock)
2022-12-13 16:43:10,631 INFO  [org.tes.DockerClientFactory] (pool-3-thread-1) Docker host IP address is localhost
2022-12-13 16:43:10,646 INFO  [org.tes.DockerClientFactory] (pool-3-thread-1) Connected to docker:
  Server Version: 20.10.13
  API Version: 1.41
  Operating System: Docker Desktop
  Total Memory: 4933 MB
2022-12-13 16:43:10,656 INFO  [org.tes.uti.ImageNameSubstitutor] (pool-3-thread-1) Image name substitution will be performed by: DefaultImageNameSubstitutor (composite of 'ConfigurationFileImageNameSubstitutor' and 'PrefixingImageNameSubstitutor')
2022-12-13 16:43:10,701 INFO  [🐳 .3.4]] (pool-3-thread-1) Creating container for image: testcontainers/ryuk:0.3.4
2022-12-13 16:43:10,779 INFO  [org.tes.uti.RegistryAuthLocator] (pool-3-thread-1) Credential helper/store (docker-credential-desktop) does not have credentials for https://index.docker.io/v1/
2022-12-13 16:43:10,860 INFO  [🐳 .3.4]] (pool-3-thread-1) Container testcontainers/ryuk:0.3.4 is starting: 6f059b35101f82b6696553ae1db8d7f3ce178b4dd6383d4c404fbc346081cb57
2022-12-13 16:43:11,215 INFO  [🐳 .3.4]] (pool-3-thread-1) Container testcontainers/ryuk:0.3.4 started in PT0.556679S
2022-12-13 16:43:11,229 INFO  [org.tes.uti.RyukResourceReaper] (pool-3-thread-1) Ryuk started - will monitor and terminate Testcontainers containers on JVM exit
2022-12-13 16:43:11,229 INFO  [org.tes.DockerClientFactory] (pool-3-thread-1) Checking the system...
2022-12-13 16:43:11,230 INFO  [org.tes.DockerClientFactory] (pool-3-thread-1) ✔︎ Docker server version should be at least 1.6.0
2022-12-13 16:43:11,234 INFO  [🐳 .2.0]] (pool-3-thread-1) HOSTNAME_EXTERNAL environment variable set to localhost (to match host-routable address for container)
2022-12-13 16:43:11,235 INFO  [🐳 .2.0]] (pool-3-thread-1) Creating container for image: localstack/localstack:1.2.0
2022-12-13 16:43:11,814 INFO  [🐳 .2.0]] (pool-3-thread-1) Container localstack/localstack:1.2.0 is starting: 40ed704e219a66c8762cbab2db75c16d27d12885856a451cee3e1e1e3b17917c
2022-12-13 16:43:14,288 INFO  [🐳 .2.0]] (pool-3-thread-1) Container localstack/localstack:1.2.0 started in PT3.053206S
2022-12-13 16:43:14,372 WARN  [sof.ama.aws.pro.int.ProfileFileReader] (pool-3-thread-1) Ignoring profile 'saml' on line 1 because it did not start with 'profile ' and it was not 'default'.
Executing "/Users/martin.grammelspacher/idea/DynamoDbVersionAttribute-test/target/amazon-dynamodb-quickstart-1.0.0-SNAPSHOT-runner -Dquarkus.http.port=8081 -Dquarkus.http.ssl-port=8444 -Dtest.url=http://localhost:8081 -Dquarkus.log.file.path=/Users/martin.grammelspacher/idea/DynamoDbVersionAttribute-test/target/quarkus.log -Dquarkus.log.file.enable=true -Dquarkus.dynamodb.aws.credentials.static-provider.secret-access-key=secretKey -Dquarkus.dynamodb.aws.region=us-east-1 -Dquarkus.dynamodb.aws.credentials.static-provider.access-key-id=accessKey -Dquarkus.dynamodb.aws.credentials.type=static -Dquarkus.dynamodb.endpoint-override=http://127.0.0.1:60790"
__  ____  __  _____   ___  __ ____  ______
 --/ __ \/ / / / _ | / _ \/ //_/ / / / __/
 -/ /_/ / /_/ / __ |/ , _/ ,< / /_/ /\ \
--\___\_\____/_/ |_/_/|_/_/|_|\____/___/
2022-12-13 16:43:16,946 INFO  [io.quarkus] (main) amazon-dynamodb-quickstart 1.0.0-SNAPSHOT native (powered by Quarkus 2.14.3.Final) started in 0.044s. Listening on: http://0.0.0.0:8081
2022-12-13 16:43:16,947 INFO  [io.quarkus] (main) Profile prod activated.
2022-12-13 16:43:16,947 INFO  [io.quarkus] (main) Installed features: [amazon-dynamodb, amazon-dynamodb-enhanced, cdi, resteasy-reactive, resteasy-reactive-jackson, smallrye-context-propagation, vertx]
2022-12-13 16:43:17,797 WARN  [sof.ama.aws.pro.int.ProfileFileReader] (executor-thread-0) Ignoring profile 'saml' on line 1 because it did not start with 'profile ' and it was not 'default'.
2022-12-13 16:43:17,798 WARN  [sof.ama.aws.pro.int.ProfileFileReader] (executor-thread-0) Ignoring profile 'saml' on line 1 because it did not start with 'profile ' and it was not 'default'.
2022-12-13 16:43:18,622 ERROR [io.qua.ver.htt.run.QuarkusErrorHandler] (executor-thread-0) HTTP Request to /fruits failed, error id: 641e581d-abc1-4585-8ddb-bec115b262b3-1: software.amazon.awssdk.services.dynamodb.model.ConditionalCheckFailedException: The conditional request failed (Service: DynamoDb, Status Code: 400, Request ID: ODARM82TCOGF31YLKRI9QIU57OGW2SNPZ1DJTCVW9PFX3NY3D74C)
	at software.amazon.awssdk.core.internal.http.CombinedResponseHandler.handleErrorResponse(CombinedResponseHandler.java:125)
	at software.amazon.awssdk.core.internal.http.CombinedResponseHandler.handleResponse(CombinedResponseHandler.java:82)
	at software.amazon.awssdk.core.internal.http.CombinedResponseHandler.handle(CombinedResponseHandler.java:60)
	at software.amazon.awssdk.core.internal.http.CombinedResponseHandler.handle(CombinedResponseHandler.java:41)
	at software.amazon.awssdk.core.internal.http.pipeline.stages.HandleResponseStage.execute(HandleResponseStage.java:40)
	at software.amazon.awssdk.core.internal.http.pipeline.stages.HandleResponseStage.execute(HandleResponseStage.java:30)
	at software.amazon.awssdk.core.internal.http.pipeline.RequestPipelineBuilder$ComposingRequestPipelineStage.execute(RequestPipelineBuilder.java:206)
	at software.amazon.awssdk.core.internal.http.pipeline.stages.ApiCallAttemptTimeoutTrackingStage.execute(ApiCallAttemptTimeoutTrackingStage.java:73)
	at software.amazon.awssdk.core.internal.http.pipeline.stages.ApiCallAttemptTimeoutTrackingStage.execute(ApiCallAttemptTimeoutTrackingStage.java:42)
	at software.amazon.awssdk.core.internal.http.pipeline.stages.TimeoutExceptionHandlingStage.execute(TimeoutExceptionHandlingStage.java:78)
	at software.amazon.awssdk.core.internal.http.pipeline.stages.TimeoutExceptionHandlingStage.execute(TimeoutExceptionHandlingStage.java:40)
	at software.amazon.awssdk.core.internal.http.pipeline.stages.ApiCallAttemptMetricCollectionStage.execute(ApiCallAttemptMetricCollectionStage.java:50)
	at software.amazon.awssdk.core.internal.http.pipeline.stages.ApiCallAttemptMetricCollectionStage.execute(ApiCallAttemptMetricCollectionStage.java:36)
	at software.amazon.awssdk.core.internal.http.pipeline.stages.RetryableStage.execute(RetryableStage.java:81)
	at software.amazon.awssdk.core.internal.http.pipeline.stages.RetryableStage.execute(RetryableStage.java:36)
	at software.amazon.awssdk.core.internal.http.pipeline.RequestPipelineBuilder$ComposingRequestPipelineStage.execute(RequestPipelineBuilder.java:206)
	at software.amazon.awssdk.core.internal.http.StreamManagingStage.execute(StreamManagingStage.java:56)
	at software.amazon.awssdk.core.internal.http.StreamManagingStage.execute(StreamManagingStage.java:36)
	at software.amazon.awssdk.core.internal.http.pipeline.stages.ApiCallTimeoutTrackingStage.executeWithTimer(ApiCallTimeoutTrackingStage.java:80)
	at software.amazon.awssdk.core.internal.http.pipeline.stages.ApiCallTimeoutTrackingStage.execute(ApiCallTimeoutTrackingStage.java:60)
	at software.amazon.awssdk.core.internal.http.pipeline.stages.ApiCallTimeoutTrackingStage.execute(ApiCallTimeoutTrackingStage.java:42)
	at software.amazon.awssdk.core.internal.http.pipeline.stages.ApiCallMetricCollectionStage.execute(ApiCallMetricCollectionStage.java:48)
	at software.amazon.awssdk.core.internal.http.pipeline.stages.ApiCallMetricCollectionStage.execute(ApiCallMetricCollectionStage.java:31)
	at software.amazon.awssdk.core.internal.http.pipeline.RequestPipelineBuilder$ComposingRequestPipelineStage.execute(RequestPipelineBuilder.java:206)
	at software.amazon.awssdk.core.internal.http.pipeline.RequestPipelineBuilder$ComposingRequestPipelineStage.execute(RequestPipelineBuilder.java:206)
	at software.amazon.awssdk.core.internal.http.pipeline.stages.ExecutionFailureExceptionReportingStage.execute(ExecutionFailureExceptionReportingStage.java:37)
	at software.amazon.awssdk.core.internal.http.pipeline.stages.ExecutionFailureExceptionReportingStage.execute(ExecutionFailureExceptionReportingStage.java:26)
	at software.amazon.awssdk.core.internal.http.AmazonSyncHttpClient$RequestExecutionBuilderImpl.execute(AmazonSyncHttpClient.java:193)
	at software.amazon.awssdk.core.internal.handler.BaseSyncClientHandler.invoke(BaseSyncClientHandler.java:103)
	at software.amazon.awssdk.core.internal.handler.BaseSyncClientHandler.doExecute(BaseSyncClientHandler.java:171)
	at software.amazon.awssdk.core.internal.handler.BaseSyncClientHandler.lambda$execute$1(BaseSyncClientHandler.java:82)
	at software.amazon.awssdk.core.internal.handler.BaseSyncClientHandler.measureApiCallSuccess(BaseSyncClientHandler.java:179)
	at software.amazon.awssdk.core.internal.handler.BaseSyncClientHandler.execute(BaseSyncClientHandler.java:76)
	at software.amazon.awssdk.core.client.handler.SdkSyncClientHandler.execute(SdkSyncClientHandler.java:45)
	at software.amazon.awssdk.awscore.client.handler.AwsSyncClientHandler.execute(AwsSyncClientHandler.java:56)
	at software.amazon.awssdk.services.dynamodb.DefaultDynamoDbClient.putItem(DefaultDynamoDbClient.java:4200)
	at software.amazon.awssdk.services.dynamodb.DynamodbClientProducer_ProducerMethod_client_15a968126f29bfeefe628e806398394e57fc3411_ClientProxy.putItem(Unknown Source)
	at software.amazon.awssdk.enhanced.dynamodb.internal.operations.CommonOperation.execute(CommonOperation.java:114)
	at software.amazon.awssdk.enhanced.dynamodb.internal.operations.TableOperation.executeOnPrimaryIndex(TableOperation.java:59)
	at software.amazon.awssdk.enhanced.dynamodb.internal.client.DefaultDynamoDbTable.putItem(DefaultDynamoDbTable.java:201)
	at software.amazon.awssdk.enhanced.dynamodb.internal.client.DefaultDynamoDbTable.putItem(DefaultDynamoDbTable.java:209)
	at software.amazon.awssdk.enhanced.dynamodb.internal.client.DefaultDynamoDbTable.putItem(DefaultDynamoDbTable.java:214)
	at org.acme.dynamodb.FruitSyncService.add(FruitSyncService.java:38)
	at org.acme.dynamodb.FruitSyncService_ClientProxy.add(Unknown Source)
	at org.acme.dynamodb.FruitResource.add(FruitResource.java:34)
	at org.acme.dynamodb.FruitResource$quarkusrestinvoker$add_b19d92d7791318034186dbebb5891e7a9140fb83.invoke(Unknown Source)
	at org.jboss.resteasy.reactive.server.handlers.InvocationHandler.handle(InvocationHandler.java:29)
	at io.quarkus.resteasy.reactive.server.runtime.QuarkusResteasyReactiveRequestContext.invokeHandler(QuarkusResteasyReactiveRequestContext.java:114)
	at org.jboss.resteasy.reactive.common.core.AbstractResteasyReactiveContext.run(AbstractResteasyReactiveContext.java:145)
	at io.quarkus.vertx.core.runtime.VertxCoreRecorder$14.runWith(VertxCoreRecorder.java:576)
	at org.jboss.threads.EnhancedQueueExecutor$Task.run(EnhancedQueueExecutor.java:2449)
	at org.jboss.threads.EnhancedQueueExecutor$ThreadBody.run(EnhancedQueueExecutor.java:1478)
	at org.jboss.threads.DelegatingRunnable.run(DelegatingRunnable.java:29)
	at org.jboss.threads.ThreadLocalResettingRunnable.run(ThreadLocalResettingRunnable.java:29)
	at io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30)
	at java.base@11.0.17/java.lang.Thread.run(Thread.java:829)
	at org.graalvm.nativeimage.builder/com.oracle.svm.core.thread.PlatformThreads.threadStartRoutine(PlatformThreads.java:775)
	at org.graalvm.nativeimage.builder/com.oracle.svm.core.posix.thread.PosixPlatformThreads.pthreadStartRoutine(PosixPlatformThreads.java:203)

2022-12-13 16:43:18,623 ERROR [org.jbo.res.rea.com.cor.AbstractResteasyReactiveContext] (executor-thread-0) Request failed: software.amazon.awssdk.services.dynamodb.model.ConditionalCheckFailedException: The conditional request failed (Service: DynamoDb, Status Code: 400, Request ID: ODARM82TCOGF31YLKRI9QIU57OGW2SNPZ1DJTCVW9PFX3NY3D74C)
	at software.amazon.awssdk.core.internal.http.CombinedResponseHandler.handleErrorResponse(CombinedResponseHandler.java:125)
	at software.amazon.awssdk.core.internal.http.CombinedResponseHandler.handleResponse(CombinedResponseHandler.java:82)
	at software.amazon.awssdk.core.internal.http.CombinedResponseHandler.handle(CombinedResponseHandler.java:60)
	at software.amazon.awssdk.core.internal.http.CombinedResponseHandler.handle(CombinedResponseHandler.java:41)
	at software.amazon.awssdk.core.internal.http.pipeline.stages.HandleResponseStage.execute(HandleResponseStage.java:40)
	at software.amazon.awssdk.core.internal.http.pipeline.stages.HandleResponseStage.execute(HandleResponseStage.java:30)
	at software.amazon.awssdk.core.internal.http.pipeline.RequestPipelineBuilder$ComposingRequestPipelineStage.execute(RequestPipelineBuilder.java:206)
	at software.amazon.awssdk.core.internal.http.pipeline.stages.ApiCallAttemptTimeoutTrackingStage.execute(ApiCallAttemptTimeoutTrackingStage.java:73)
	at software.amazon.awssdk.core.internal.http.pipeline.stages.ApiCallAttemptTimeoutTrackingStage.execute(ApiCallAttemptTimeoutTrackingStage.java:42)
	at software.amazon.awssdk.core.internal.http.pipeline.stages.TimeoutExceptionHandlingStage.execute(TimeoutExceptionHandlingStage.java:78)
	at software.amazon.awssdk.core.internal.http.pipeline.stages.TimeoutExceptionHandlingStage.execute(TimeoutExceptionHandlingStage.java:40)
	at software.amazon.awssdk.core.internal.http.pipeline.stages.ApiCallAttemptMetricCollectionStage.execute(ApiCallAttemptMetricCollectionStage.java:50)
	at software.amazon.awssdk.core.internal.http.pipeline.stages.ApiCallAttemptMetricCollectionStage.execute(ApiCallAttemptMetricCollectionStage.java:36)
	at software.amazon.awssdk.core.internal.http.pipeline.stages.RetryableStage.execute(RetryableStage.java:81)
	at software.amazon.awssdk.core.internal.http.pipeline.stages.RetryableStage.execute(RetryableStage.java:36)
	at software.amazon.awssdk.core.internal.http.pipeline.RequestPipelineBuilder$ComposingRequestPipelineStage.execute(RequestPipelineBuilder.java:206)
	at software.amazon.awssdk.core.internal.http.StreamManagingStage.execute(StreamManagingStage.java:56)
	at software.amazon.awssdk.core.internal.http.StreamManagingStage.execute(StreamManagingStage.java:36)
	at software.amazon.awssdk.core.internal.http.pipeline.stages.ApiCallTimeoutTrackingStage.executeWithTimer(ApiCallTimeoutTrackingStage.java:80)
	at software.amazon.awssdk.core.internal.http.pipeline.stages.ApiCallTimeoutTrackingStage.execute(ApiCallTimeoutTrackingStage.java:60)
	at software.amazon.awssdk.core.internal.http.pipeline.stages.ApiCallTimeoutTrackingStage.execute(ApiCallTimeoutTrackingStage.java:42)
	at software.amazon.awssdk.core.internal.http.pipeline.stages.ApiCallMetricCollectionStage.execute(ApiCallMetricCollectionStage.java:48)
	at software.amazon.awssdk.core.internal.http.pipeline.stages.ApiCallMetricCollectionStage.execute(ApiCallMetricCollectionStage.java:31)
	at software.amazon.awssdk.core.internal.http.pipeline.RequestPipelineBuilder$ComposingRequestPipelineStage.execute(RequestPipelineBuilder.java:206)
	at software.amazon.awssdk.core.internal.http.pipeline.RequestPipelineBuilder$ComposingRequestPipelineStage.execute(RequestPipelineBuilder.java:206)
	at software.amazon.awssdk.core.internal.http.pipeline.stages.ExecutionFailureExceptionReportingStage.execute(ExecutionFailureExceptionReportingStage.java:37)
	at software.amazon.awssdk.core.internal.http.pipeline.stages.ExecutionFailureExceptionReportingStage.execute(ExecutionFailureExceptionReportingStage.java:26)
	at software.amazon.awssdk.core.internal.http.AmazonSyncHttpClient$RequestExecutionBuilderImpl.execute(AmazonSyncHttpClient.java:193)
	at software.amazon.awssdk.core.internal.handler.BaseSyncClientHandler.invoke(BaseSyncClientHandler.java:103)
	at software.amazon.awssdk.core.internal.handler.BaseSyncClientHandler.doExecute(BaseSyncClientHandler.java:171)
	at software.amazon.awssdk.core.internal.handler.BaseSyncClientHandler.lambda$execute$1(BaseSyncClientHandler.java:82)
	at software.amazon.awssdk.core.internal.handler.BaseSyncClientHandler.measureApiCallSuccess(BaseSyncClientHandler.java:179)
	at software.amazon.awssdk.core.internal.handler.BaseSyncClientHandler.execute(BaseSyncClientHandler.java:76)
	at software.amazon.awssdk.core.client.handler.SdkSyncClientHandler.execute(SdkSyncClientHandler.java:45)
	at software.amazon.awssdk.awscore.client.handler.AwsSyncClientHandler.execute(AwsSyncClientHandler.java:56)
	at software.amazon.awssdk.services.dynamodb.DefaultDynamoDbClient.putItem(DefaultDynamoDbClient.java:4200)
	at software.amazon.awssdk.services.dynamodb.DynamodbClientProducer_ProducerMethod_client_15a968126f29bfeefe628e806398394e57fc3411_ClientProxy.putItem(Unknown Source)
	at software.amazon.awssdk.enhanced.dynamodb.internal.operations.CommonOperation.execute(CommonOperation.java:114)
	at software.amazon.awssdk.enhanced.dynamodb.internal.operations.TableOperation.executeOnPrimaryIndex(TableOperation.java:59)
	at software.amazon.awssdk.enhanced.dynamodb.internal.client.DefaultDynamoDbTable.putItem(DefaultDynamoDbTable.java:201)
	at software.amazon.awssdk.enhanced.dynamodb.internal.client.DefaultDynamoDbTable.putItem(DefaultDynamoDbTable.java:209)
	at software.amazon.awssdk.enhanced.dynamodb.internal.client.DefaultDynamoDbTable.putItem(DefaultDynamoDbTable.java:214)
	at org.acme.dynamodb.FruitSyncService.add(FruitSyncService.java:38)
	at org.acme.dynamodb.FruitSyncService_ClientProxy.add(Unknown Source)
	at org.acme.dynamodb.FruitResource.add(FruitResource.java:34)
	at org.acme.dynamodb.FruitResource$quarkusrestinvoker$add_b19d92d7791318034186dbebb5891e7a9140fb83.invoke(Unknown Source)
	at org.jboss.resteasy.reactive.server.handlers.InvocationHandler.handle(InvocationHandler.java:29)
	at io.quarkus.resteasy.reactive.server.runtime.QuarkusResteasyReactiveRequestContext.invokeHandler(QuarkusResteasyReactiveRequestContext.java:114)
	at org.jboss.resteasy.reactive.common.core.AbstractResteasyReactiveContext.run(AbstractResteasyReactiveContext.java:145)
	at io.quarkus.vertx.core.runtime.VertxCoreRecorder$14.runWith(VertxCoreRecorder.java:576)
	at org.jboss.threads.EnhancedQueueExecutor$Task.run(EnhancedQueueExecutor.java:2449)
	at org.jboss.threads.EnhancedQueueExecutor$ThreadBody.run(EnhancedQueueExecutor.java:1478)
	at org.jboss.threads.DelegatingRunnable.run(DelegatingRunnable.java:29)
	at org.jboss.threads.ThreadLocalResettingRunnable.run(ThreadLocalResettingRunnable.java:29)
	at io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30)
	at java.base@11.0.17/java.lang.Thread.run(Thread.java:829)
	at org.graalvm.nativeimage.builder/com.oracle.svm.core.thread.PlatformThreads.threadStartRoutine(PlatformThreads.java:775)
	at org.graalvm.nativeimage.builder/com.oracle.svm.core.posix.thread.PosixPlatformThreads.pthreadStartRoutine(PosixPlatformThreads.java:203)

WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by org.codehaus.groovy.vmplugin.v9.Java9 (file:/Users/martin.grammelspacher/.m2/repository/org/codehaus/groovy/groovy/3.0.9/groovy-3.0.9.jar) to constructor java.lang.AssertionError(java.lang.String)
WARNING: Please consider reporting this to the maintainers of org.codehaus.groovy.vmplugin.v9.Java9
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
[ERROR] Tests run: 1, Failures: 1, Errors: 0, Skipped: 0, Time elapsed: 12.793 s <<< FAILURE! - in org.acme.dynamodb.DynamodbResourcesIT
[ERROR] org.acme.dynamodb.DynamodbResourcesIT.testResource(String)[1]  Time elapsed: 4.238 s  <<< FAILURE!
java.lang.AssertionError:
1 expectation failed.
Expected status code <200> but was <500>.

	at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
	at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
	at java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:490)
	at org.codehaus.groovy.reflection.CachedConstructor.invoke(CachedConstructor.java:72)
	at org.codehaus.groovy.reflection.CachedConstructor.doConstructorInvoke(CachedConstructor.java:59)
	at org.codehaus.groovy.runtime.callsite.ConstructorSite$ConstructorSiteNoUnwrap.callConstructor(ConstructorSite.java:84)
	at org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCallConstructor(CallSiteArray.java:59)
	at org.codehaus.groovy.runtime.callsite.AbstractCallSite.callConstructor(AbstractCallSite.java:263)
	at org.codehaus.groovy.runtime.callsite.AbstractCallSite.callConstructor(AbstractCallSite.java:277)
	at io.restassured.internal.ResponseSpecificationImpl$HamcrestAssertionClosure.validate(ResponseSpecificationImpl.groovy:499)
	at io.restassured.internal.ResponseSpecificationImpl$HamcrestAssertionClosure$validate$1.call(Unknown Source)
	at org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCall(CallSiteArray.java:47)
	at org.codehaus.groovy.runtime.callsite.AbstractCallSite.call(AbstractCallSite.java:125)
	at org.codehaus.groovy.runtime.callsite.AbstractCallSite.call(AbstractCallSite.java:139)
	at io.restassured.internal.ResponseSpecificationImpl.validateResponseIfRequired(ResponseSpecificationImpl.groovy:684)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:566)
	at org.codehaus.groovy.runtime.callsite.PlainObjectMetaMethodSite.doInvoke(PlainObjectMetaMethodSite.java:43)
	at org.codehaus.groovy.runtime.callsite.PogoMetaMethodSite$PogoCachedMethodSiteNoUnwrapNoCoerce.invoke(PogoMetaMethodSite.java:193)
	at org.codehaus.groovy.runtime.callsite.PogoMetaMethodSite.callCurrent(PogoMetaMethodSite.java:61)
	at org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCallCurrent(CallSiteArray.java:51)
	at org.codehaus.groovy.runtime.callsite.AbstractCallSite.callCurrent(AbstractCallSite.java:171)
	at org.codehaus.groovy.runtime.callsite.AbstractCallSite.callCurrent(AbstractCallSite.java:185)
	at io.restassured.internal.ResponseSpecificationImpl.statusCode(ResponseSpecificationImpl.groovy:127)
	at io.restassured.specification.ResponseSpecification$statusCode$0.callCurrent(Unknown Source)
	at org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCallCurrent(CallSiteArray.java:51)
	at org.codehaus.groovy.runtime.callsite.AbstractCallSite.callCurrent(AbstractCallSite.java:171)
	at org.codehaus.groovy.runtime.callsite.AbstractCallSite.callCurrent(AbstractCallSite.java:185)
	at io.restassured.internal.ResponseSpecificationImpl.statusCode(ResponseSpecificationImpl.groovy:135)
	at io.restassured.internal.ValidatableResponseOptionsImpl.statusCode(ValidatableResponseOptionsImpl.java:89)
	at io.restassured.internal.ValidatableResponseImpl.super$2$statusCode(ValidatableResponseImpl.groovy)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:566)
	at org.codehaus.groovy.reflection.CachedMethod.invoke(CachedMethod.java:107)
	at groovy.lang.MetaMethod.doMethodInvoke(MetaMethod.java:323)
	at groovy.lang.MetaClassImpl.invokeMethod(MetaClassImpl.java:1268)
	at org.codehaus.groovy.runtime.ScriptBytecodeAdapter.invokeMethodOnSuperN(ScriptBytecodeAdapter.java:144)
	at io.restassured.internal.ValidatableResponseImpl.statusCode(ValidatableResponseImpl.groovy:142)
	at io.restassured.internal.ValidatableResponseImpl.statusCode(ValidatableResponseImpl.groovy)
	at org.acme.dynamodb.DynamodbResourcesTest.lambda$testResource$1(DynamodbResourcesTest.java:38)
	at java.base/java.util.Arrays$ArrayList.forEach(Arrays.java:4390)
	at org.acme.dynamodb.DynamodbResourcesTest.testResource(DynamodbResourcesTest.java:30)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:566)
	at org.junit.platform.commons.util.ReflectionUtils.invokeMethod(ReflectionUtils.java:727)
	at org.junit.jupiter.engine.execution.MethodInvocation.proceed(MethodInvocation.java:60)
	at org.junit.jupiter.engine.execution.InvocationInterceptorChain$ValidatingInvocation.proceed(InvocationInterceptorChain.java:131)
	at io.quarkus.test.junit.QuarkusTestExtension.interceptTestTemplateMethod(QuarkusTestExtension.java:848)
	at org.junit.jupiter.engine.execution.InterceptingExecutableInvoker$ReflectiveInterceptorCall.lambda$ofVoidMethod$0(InterceptingExecutableInvoker.java:103)
	at org.junit.jupiter.engine.execution.InterceptingExecutableInvoker.lambda$invoke$0(InterceptingExecutableInvoker.java:93)
	at org.junit.jupiter.engine.execution.InvocationInterceptorChain$InterceptedInvocation.proceed(InvocationInterceptorChain.java:106)
	at org.junit.jupiter.engine.extension.TimeoutExtension.intercept(TimeoutExtension.java:156)
	at org.junit.jupiter.engine.extension.TimeoutExtension.interceptTestableMethod(TimeoutExtension.java:147)
	at org.junit.jupiter.engine.extension.TimeoutExtension.interceptTestTemplateMethod(TimeoutExtension.java:94)
	at org.junit.jupiter.engine.execution.InterceptingExecutableInvoker$ReflectiveInterceptorCall.lambda$ofVoidMethod$0(InterceptingExecutableInvoker.java:103)
	at org.junit.jupiter.engine.execution.InterceptingExecutableInvoker.lambda$invoke$0(InterceptingExecutableInvoker.java:93)
	at org.junit.jupiter.engine.execution.InvocationInterceptorChain$InterceptedInvocation.proceed(InvocationInterceptorChain.java:106)
	at org.junit.jupiter.engine.execution.InvocationInterceptorChain.proceed(InvocationInterceptorChain.java:64)
	at org.junit.jupiter.engine.execution.InvocationInterceptorChain.chainAndInvoke(InvocationInterceptorChain.java:45)
	at org.junit.jupiter.engine.execution.InvocationInterceptorChain.invoke(InvocationInterceptorChain.java:37)
	at org.junit.jupiter.engine.execution.InterceptingExecutableInvoker.invoke(InterceptingExecutableInvoker.java:92)
	at org.junit.jupiter.engine.execution.InterceptingExecutableInvoker.invoke(InterceptingExecutableInvoker.java:86)
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.lambda$invokeTestMethod$7(TestMethodTestDescriptor.java:217)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.invokeTestMethod(TestMethodTestDescriptor.java:213)
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.execute(TestMethodTestDescriptor.java:138)
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.execute(TestMethodTestDescriptor.java:68)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$6(NodeTestTask.java:151)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:141)
	at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:137)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$9(NodeTestTask.java:139)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:138)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:95)
	at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.submit(SameThreadHierarchicalTestExecutorService.java:35)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask$DefaultDynamicTestExecutor.execute(NodeTestTask.java:226)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask$DefaultDynamicTestExecutor.execute(NodeTestTask.java:204)
	at org.junit.jupiter.engine.descriptor.TestTemplateTestDescriptor.execute(TestTemplateTestDescriptor.java:142)
	at org.junit.jupiter.engine.descriptor.TestTemplateTestDescriptor.lambda$execute$2(TestTemplateTestDescriptor.java:110)
	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
	at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:195)
	at java.base/java.util.stream.ReferencePipeline$2$1.accept(ReferencePipeline.java:177)
	at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:195)
	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
	at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:195)
	at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:195)
	at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:195)
	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
	at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:195)
	at java.base/java.util.Spliterators$ArraySpliterator.forEachRemaining(Spliterators.java:948)
	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:484)
	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
	at java.base/java.util.stream.ReferencePipeline$7$1.accept(ReferencePipeline.java:274)
	at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:195)
	at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:195)
	at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:195)
	at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1655)
	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:484)
	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
	at java.base/java.util.stream.ReferencePipeline$7$1.accept(ReferencePipeline.java:274)
	at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1655)
	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:484)
	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
	at org.junit.jupiter.engine.descriptor.TestTemplateTestDescriptor.execute(TestTemplateTestDescriptor.java:110)
	at org.junit.jupiter.engine.descriptor.TestTemplateTestDescriptor.execute(TestTemplateTestDescriptor.java:44)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$6(NodeTestTask.java:151)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:141)
	at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:137)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$9(NodeTestTask.java:139)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:138)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:95)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
	at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.invokeAll(SameThreadHierarchicalTestExecutorService.java:41)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$6(NodeTestTask.java:155)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:141)
	at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:137)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$9(NodeTestTask.java:139)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:138)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:95)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
	at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.invokeAll(SameThreadHierarchicalTestExecutorService.java:41)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$6(NodeTestTask.java:155)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:141)
	at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:137)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$9(NodeTestTask.java:139)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:138)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:95)
	at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.submit(SameThreadHierarchicalTestExecutorService.java:35)
	at org.junit.platform.engine.support.hierarchical.HierarchicalTestExecutor.execute(HierarchicalTestExecutor.java:57)
	at org.junit.platform.engine.support.hierarchical.HierarchicalTestEngine.execute(HierarchicalTestEngine.java:54)
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.execute(EngineExecutionOrchestrator.java:147)
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.execute(EngineExecutionOrchestrator.java:127)
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.execute(EngineExecutionOrchestrator.java:90)
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.lambda$execute$0(EngineExecutionOrchestrator.java:55)
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.withInterceptedStreams(EngineExecutionOrchestrator.java:102)
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.execute(EngineExecutionOrchestrator.java:54)
	at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:114)
	at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:86)
	at org.junit.platform.launcher.core.DefaultLauncherSession$DelegatingLauncher.execute(DefaultLauncherSession.java:86)
	at org.apache.maven.surefire.junitplatform.LazyLauncher.execute(LazyLauncher.java:55)
	at org.apache.maven.surefire.junitplatform.JUnitPlatformProvider.execute(JUnitPlatformProvider.java:223)
	at org.apache.maven.surefire.junitplatform.JUnitPlatformProvider.invokeAllTests(JUnitPlatformProvider.java:175)
	at org.apache.maven.surefire.junitplatform.JUnitPlatformProvider.invoke(JUnitPlatformProvider.java:139)
	at org.apache.maven.surefire.booter.ForkedBooter.runSuitesInProcess(ForkedBooter.java:456)
	at org.apache.maven.surefire.booter.ForkedBooter.execute(ForkedBooter.java:169)
	at org.apache.maven.surefire.booter.ForkedBooter.run(ForkedBooter.java:595)
	at org.apache.maven.surefire.booter.ForkedBooter.main(ForkedBooter.java:581)

[INFO]
[INFO] Results:
[INFO]
[ERROR] Failures:
[ERROR]   DynamodbResourcesIT>DynamodbResourcesTest.testResource:30->DynamodbResourcesTest.lambda$testResource$1:38 1 expectation failed.
Expected status code <200> but was <500>.

[INFO]
[ERROR] Tests run: 1, Failures: 1, Errors: 0, Skipped: 0
[INFO]
[INFO]
[INFO] --- maven-failsafe-plugin:3.0.0-M7:verify (default) @ amazon-dynamodb-quickstart ---
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  02:31 min
[INFO] Finished at: 2022-12-13T16:43:21+01:00
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-failsafe-plugin:3.0.0-M7:verify (default) on project amazon-dynamodb-quickstart: There are test failures.
```
