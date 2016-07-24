package net.sokontokoro_factory.yoshinani.file.config;

import net.sokontokoro_factory.yoshinani.exception.FileIOException;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class PropertiesTest {
    @Test
    public void test_getString_valueをString型として取得する() throws Exception {
        String actualKey = "testkey";
        String actulaValue = "testvalue";

        Properties targetFile = new Properties("test.properties");
        assertThat(targetFile.getString(actualKey), is(actulaValue));
    }

    @Test
    public void test_getString_存在しないkeyの場合nullを返却する() throws Exception {
        String notExistKey = "not.exist.key";

        Properties targetFile = new Properties("test.properties");
        assertNull(targetFile.getString(notExistKey));
    }

    @Test
    public void test_getInt_valueをint型として取得する() throws Exception {
        String actualKey = "testkey.int";
        int actulaValue = 25252;

        Properties targetFile = new Properties("test.properties");
        assertThat(targetFile.getInt(actualKey), is(actulaValue));
    }

    @Test
    public void test_getInt_存在しないkeyの場合例外が発生する() throws Exception {
        String notExistKey = "not.exist.key";

        Properties targetFile = new Properties("test.properties");
        try{
            targetFile.getInt(notExistKey);
            fail();
        }catch (NumberFormatException ok){

        }
    }

    @Test
    public void test_getString_読み込むファイルが存在しない場合例外が発生する() throws Exception {
        String actualKey = "testkey";

        Properties targetFile = new Properties("noexist.properties");
        try{
            assertNull(targetFile.getInt(actualKey));
            fail();
        } catch (NullPointerException ok){

        }
    }

    @Test
    public void test_getString_IOExceptionが発生した場合FileIOExceptionをthrowする() throws Exception {
        /* setup */
        Properties targetClass = new Properties("test.properties");
        String actualKey = "testkey";

        /* mock */
        Properties mockClass = spy(targetClass);
        when(mockClass.loadFile()).thenThrow(new IOException());

        try{
            mockClass.getString(actualKey);
            fail();
        } catch (FileIOException ok){

        }
    }
}