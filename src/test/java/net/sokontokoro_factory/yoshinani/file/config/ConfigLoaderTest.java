package net.sokontokoro_factory.yoshinani.file.config;

import net.sokontokoro_factory.yoshinani.PrivateField;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class ConfigLoaderTest {
    @Test
    public void test_getProperties_初期値のファイル名で独自Propertiesオブジェクトを取得できる() throws Exception {
        // 初期値にPropertiesファイルのextensionを付ける
        String defaultFileBaseName = (String) PrivateField.getPrivateField(new ConfigLoader(), "DEFAULT_FILE_BASE_NAME");
        String defaultFileName = defaultFileBaseName + ".properties";

        /* execute */
        Config properties = ConfigLoader.getProperties();

        // Properties型である
        if(!(properties instanceof Properties)){
            fail();
        }

        // 初期値のファイル名がセットされている
        assertThat(properties.getFileName(), is(defaultFileName));

    }

    @Test
    public void test_getProperties_指定したファイル名で独自Propertiesオブジェクトを取得できる() throws Exception {
        // 初期値にPropertiesファイルのextensionを付ける
        String testFileBaseName = "test";
        String expectedExtention = ".properties";

        /* execute */
        Config properties = ConfigLoader.getProperties(testFileBaseName);

        // Properties型である
        if(!(properties instanceof Properties)){
            fail();
        }

        // 初期値のファイル名がセットされている
        assertThat(properties.getFileName(), is(testFileBaseName + expectedExtention));

    }
}