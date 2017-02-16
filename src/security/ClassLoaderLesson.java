package security;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by max on 2/15/17.
 */
public class ClassLoaderLesson {
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException {
        URL url = new URL("file://home/max/Downloads/BumperSticker.jar");
        URLClassLoader pluginLoader = new URLClassLoader(new URL[] { url });
        Class<?> cl = pluginLoader.loadClass("bumpersticker.BumperSticker");

        Thread t = Thread.currentThread();
        ClassLoader loader = t.getContextClassLoader();
    }
}

class MyLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(Paths.get("fileName"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Class<?> cl = defineClass(name, bytes, 0,
                bytes.length);
        return cl;
    }
}
