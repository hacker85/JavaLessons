gcc -fPIC -I /usr/lib/jvm/java-8-oracle/include -I /usr/lib/jvm/java-8-oracle/include/linux -shared -o libHelloNative.so HelloNative.c
java -Djava.library.path=. HelloNativeTest