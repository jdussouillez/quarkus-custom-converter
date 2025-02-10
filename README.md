# quarkus-custom-converter

Project to reproduce a problem with custom converters in Quarkus v3.18.

Issue: https://github.com/quarkusio/quarkus/issues/46170

```sh
./mvnw quarkus:dev # Using v3.18.2
```

Fails with:

```
ERROR [io.qua.run.Quarkus] (Quarkus Main Thread) Error running Quarkus: java.lang.ExceptionInInitializerError
	at io.quarkus.runner.ApplicationImpl.<clinit>(Unknown Source)
	at java.base/jdk.internal.misc.Unsafe.allocateInstance(Native Method)
	at java.base/java.lang.invoke.DirectMethodHandle.allocateInstance(DirectMethodHandle.java:501)
	at io.quarkus.runtime.Quarkus.run(Quarkus.java:76)
	at io.quarkus.runtime.Quarkus.run(Quarkus.java:48)
	at io.quarkus.runtime.Quarkus.run(Quarkus.java:137)
	at io.quarkus.runner.GeneratedMain.main(Unknown Source)
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
	at java.base/java.lang.reflect.Method.invoke(Method.java:580)
	at io.quarkus.runner.bootstrap.StartupActionImpl$1.run(StartupActionImpl.java:116)
	at java.base/java.lang.Thread.run(Thread.java:1583)
Caused by: java.lang.RuntimeException: java.lang.ClassNotFoundException: [B
	at io.quarkus.runtime.configuration.AbstractConfigBuilder.withConverter(AbstractConfigBuilder.java:30)
	at io.quarkus.runtime.generated.StaticInitConfigCustomizer.configBuilder(Unknown Source)
	at io.smallrye.config.SmallRyeConfigBuilder.build(SmallRyeConfigBuilder.java:770)
	at io.quarkus.runtime.generated.Config.<clinit>(Unknown Source)
	... 11 more
Caused by: java.lang.ClassNotFoundException: [B
	at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:641)
	at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:188)
	at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:526)
	at io.quarkus.bootstrap.classloading.QuarkusClassLoader.loadClass(QuarkusClassLoader.java:569)
	at io.quarkus.bootstrap.classloading.QuarkusClassLoader.loadClass(QuarkusClassLoader.java:517)
	at io.quarkus.bootstrap.classloading.QuarkusClassLoader.loadClass(QuarkusClassLoader.java:569)
	at io.quarkus.bootstrap.classloading.QuarkusClassLoader.loadClass(QuarkusClassLoader.java:517)
	at io.quarkus.runtime.configuration.AbstractConfigBuilder.withConverter(AbstractConfigBuilder.java:28)
	... 14 more
```

```sh
./mvnw quarkus:dev -Dquarkus.platform.version=3.17.8 # Works
```
