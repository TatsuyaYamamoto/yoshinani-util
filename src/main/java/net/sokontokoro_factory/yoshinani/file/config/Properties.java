package net.sokontokoro_factory.yoshinani.file.config;

import net.sokontokoro_factory.yoshinani.exception.FileIOException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class Properties implements Config{
    private static final String CLASS_NAME = Properties.class.getName();
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    private String fileName;

    /**
     * コンストラクタ
     * 読み込むプロパティファイル名を指定する。
     *
     * @param fileName
     */
    protected Properties(String fileName){
        this.fileName = fileName;
    };

    /**
     * 読み込み対象のファイル名を取得する
     *
     * @return
     */
    public String getFileName(){
        return this.fileName;
    }

    /**
     * keyに対応するvalueをString型で返却する
     *
     * @param key
     * @return                      指定したkeyが存在しない場合、nullを返す
     * @throws FileIOException      ファイル読み込み時にIOExceptionが発生した
     * @throws NullPointerException propertiesファイルが存在しない
     */
    public String getString(String key) throws FileIOException, NullPointerException{
        logger.entering(CLASS_NAME, "getString", key);

        try {
            String value = loadFile().getProperty(key);
            logger.exiting(CLASS_NAME, "getString", value);
            return value;
        }catch(NullPointerException e){
            // propertiesファイルが見つからない場合
            logger.log(Level.WARNING, e.getMessage(), e);
            throw e;
        }catch(IOException e) {
            logger.log(Level.WARNING, e.getMessage(), e);
            throw new FileIOException(e.getMessage(), e);
        }
    }

    /**
     * keyに対応するvalueをint型で返却する
     *
     * @param key
     * @return
     * @throws FileIOException          ファイル読み込み時にIOExceptionが発生した
     * @throws NullPointerException     propertiesファイルが存在しない
     * @throws NumberFormatException    int型に変換できない、指定したkeyが存在しない
     */
    public int getInt(String key)throws FileIOException, NullPointerException, NumberFormatException {
        return Integer.parseInt(getString(key));
    }


    /************************************************
     * protected method
     */

    /**
     * Propertiesインスタンスを作成する。
     *
     * @return
     * @throws IOException
     * @throws NullPointerException
     */
    protected java.util.Properties loadFile() throws IOException, NullPointerException {

        java.util.Properties properties = new java.util.Properties();
        String filePath = Properties.class.getClassLoader().getResource(this.fileName).getPath();

        InputStream inputStream = new FileInputStream(filePath);
        properties.load(inputStream);
        inputStream.close();

        return properties;
    }
}