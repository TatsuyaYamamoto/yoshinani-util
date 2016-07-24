package net.sokontokoro_factory.yoshinani.file.config;

import java.util.logging.Logger;

/**
 * クラスパスルートに設定された設定ファイルを読み込んだConfigオブジェクトを返却するクラス
 * 読み込むファイル名の初期値はconfig + 拡張子
 */
public class ConfigLoader {
    private static final String CLASS_NAME = ConfigLoader.class.getName();
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    private static final String DEFAULT_FILE_BASE_NAME = "config";

    /**
     * Propertiesオブジェクトを返却する
     *
     * @return
     */
    public static Config getProperties(){
        return getProperties(DEFAULT_FILE_BASE_NAME);
    }

    /**
     * 指定したファイル名のPropertiesオブジェクトを返却する
     *
     * @param fileBaseName 拡張子をの除いた、読み込む対象のファイル名
     * @return
     */
    public static Config getProperties(String fileBaseName){
        logger.entering(CLASS_NAME, "getProperties", fileBaseName);
        Properties prop = new Properties(fileBaseName + ".properties");
        logger.exiting(CLASS_NAME, "getProperties", prop);
        return prop;
    }
}