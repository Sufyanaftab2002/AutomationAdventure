package utils;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

@Slf4j
public class ConfigUtil {
    public static Properties getConfig(String filename) {
        Properties properties = new Properties();
        try {
            File configExternalFile = new File(
                    System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator
                            + "java" + File.separator + "config" + File.separator + filename + ".properties");
            if (configExternalFile.exists()) {
                properties.load(new FileInputStream(configExternalFile));
            } else {
                log.info("File Not found " + filename);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }
}
