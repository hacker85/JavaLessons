package io;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.PosixFileAttributes;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FilesPathLesson {
    public static void main(String[] args) throws IOException {
        File file = new File("temp.txt");
        Path path = Paths.get("temp.txt");//file.toPath().toAbsolutePath();
        Files files;

        file.exists();
        file.createNewFile();
        file.delete();

        System.out.println(path.getFileName());
        System.out.println(path.getFileSystem());
        System.out.println(path.getRoot());
        System.out.println(path.getParent());
        System.out.println(path.getName(0));
        System.out.println(path.isAbsolute());
        System.out.println(path.getNameCount());
        File f = path.toFile();

        byte[] bytes = Files.readAllBytes(Paths.get("temp.txt"));
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }
        String str = new String(bytes);
        System.out.println(str);
        List<String> list = Files.readAllLines(Paths.get("temp.txt"));
        Files.write(path, "bla\nhaha".getBytes());
        Files.write(path, "bla\nhaha".getBytes(), StandardOpenOption.APPEND);
        List<String> list1 = new ArrayList<String>();
        list1.add("new");
        Files.write(path, list1);
        InputStream inputStream = Files.newInputStream(path);
        OutputStream outputStream = Files.newOutputStream(path);
        Reader reader = Files.newBufferedReader(path);
        Writer writer = Files.newBufferedWriter(path);

        Files.createDirectories(path);
        Files.createFile(path);
        Path tmpPth = Files.createTempFile("max", "txt");
        Path tmpPth2 = Files.createTempDirectory("temp");
        System.out.println(tmpPth);
        System.out.println(tmpPth2);

        try(DirectoryStream<Path> entries = Files.newDirectoryStream(Paths.get("."))) {
            for(Path path1 : entries) {
                System.out.println(path1.getFileName());
            }
        }

        Files.isSameFile(path, path);
        Files.isDirectory(path);
        Files.isReadable(path);
        Files.isExecutable(path);
        Files.isWritable(path);
        System.out.println(Files.getAttribute(path, "size", LinkOption.NOFOLLOW_LINKS));
        Files.size(path);
        BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
        PosixFileAttributes posix = Files.readAttributes(path, PosixFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
        attributes.creationTime();

        Path path2 = Paths.get("new.txt");
        Files.copy(path, path2, StandardCopyOption.REPLACE_EXISTING);
        Files.move(path2, Paths.get("old.txt"), StandardCopyOption.REPLACE_EXISTING);
        Files.delete(Paths.get("old.txt"));
        Files.deleteIfExists(Paths.get("old.txt"));
        Files.walkFileTree(Paths.get("."), new HashSet<FileVisitOption>(), 1, new MyFileVisitor());
    }
}
class MyFileVisitor extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println(file.getFileName());
        return FileVisitResult.CONTINUE;
    }
}
