package net.sokontokoro_factory.yoshinani.file.config;

import java.io.IOException;

public interface Config {
    String getFileName();
    String getString(String key) throws IOException;
    int getInt(String key) throws IOException;
}
