package DataUtils;

import java.io.InputStream;
import java.util.Properties;

public class SQLQueryLoader {
    private static Properties queries = new Properties();

    static {
        try (InputStream input = SQLQueryLoader.class.getClassLoader()
                .getResourceAsStream("queries.properties")) {
            queries.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getQuery(String key) {
        return queries.getProperty(key);
    }
}
