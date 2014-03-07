package il.peterlaker.path.spi.tar;

import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Formatter;

public class TarFileAttributes implements BasicFileAttributes

{
    private final TarEntry e;

    TarFileAttributes(TarEntry e) {
        this.e = e;
    }

    ///////// basic attributes ///////////
    @Override
    public FileTime creationTime() {
        return null;
    }

    @Override
    public boolean isDirectory() {
        return e.isDirectory();
    }

    @Override
    public boolean isOther() {
        return false;
    }

    @Override
    public boolean isRegularFile() {
        return !e.isDirectory();
    }

    @Override
    public FileTime lastAccessTime() {
        return null;
    }

    @Override
    public FileTime lastModifiedTime() {
        return FileTime.fromMillis(e.getModTime().getTime());
    }

    @Override
    public long size() {
        return e.getSize();
    }

    @Override
    public boolean isSymbolicLink() {
        return false;
    }

    @Override
    public Object fileKey() {
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(1024);
        Formatter fm = new Formatter(sb);
        fm.format("    lastModifiedTime: %tc%n", lastModifiedTime().toMillis());
        fm.format("    isDirectory     : %b%n", isDirectory());
        fm.format("    size            : %d%n", size());
        fm.close();
        return sb.toString();
    }
}
