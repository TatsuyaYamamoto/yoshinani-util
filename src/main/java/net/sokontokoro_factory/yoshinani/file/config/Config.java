package net.sokontokoro_factory.yoshinani.file.config;

public interface Config {
    String getFileName();
    String getString(String key);
    int getInt(String key);
}
