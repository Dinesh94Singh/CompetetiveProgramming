package com.company.codingscales.java.concepts.oAuth.example;


import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Collectors;

public class PropertiesClient {
    public static final String CONSUMER_KEY = "consumer_key";
    public static final String PRIVATE_KEY = "private_key";
    public static final String REQUEST_TOKEN = "request_token";
    public static final String ACCESS_TOKEN = "access_token";
    public static final String SECRET = "secret";
    public static final String JIRA_HOME = "jira_home";


    private final static Map<String, String> DEFAULT_PROPERTY_VALUES = ImmutableMap.<String, String>builder()
            .put(JIRA_HOME, "http://localhost:8090/jira")
            .put(CONSUMER_KEY, "OauthKey")
            .put(PRIVATE_KEY, "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDFkPMZQaTqsSXI+bSI65rSVaDzic6WFA3WCZMVMi7lYXJAUdkXo4DgdfvEBO21Bno3bXIoxqS411G8S53I39yhSp7z2vcB76uQQifi0LEaklZfbTnFUXcKCyfwgKPp0tQVA+JZei6hnscbSw8qEItdc69ReZ6SK+3LHhvFUUP1nLhJDsgdPHRXSllgZzqvWAXQupGYZVANpBJuK+KAfiaVXCgA71N9xx/5XTSFi5K+e1T4HVnKAzDasAUt7Mmad+1PE+56Gpa73FLk1Ww+xaAEvss6LehjyWHM5iNswoNYzrNS2k6ZYkDnZxUlbrPDELETbz/n3YgBHGUlyrXi2PBjAgMBAAECggEAAtMctqq6meRofuQbEa4Uq5cv0uuQeZLV086VPMNX6k2nXYYODYl36T2mmNndMC5khvBYpn6Ykk/5yjBmlB2nQOMZPLFPwMZVdJ2Nhm+naJLZC0o7fje49PrN2mFsdoZeI+LHVLIrgoILpLdBAz/zTiW+RvLvMnXQU4wdp4eO6i8J/Jwh0AY8rWsAGkk1mdZDwklPZZiwR3z+DDsDwPxFs8z6cE5rWJd2c/fhAQrHwOXyrQPsGyLHTOqS3BkjtEZrKRUlfdgV76VlThwrE5pAWuO0GPyfK/XCklwcNS1a5XxCOq3uUogWRhCsqUX6pYfAVS6xzX56MGDndQVlp7U5uQKBgQDyTDwhsNTWlmr++FyYrc6liSF9NEMBNDubrfLJH1kaOp590bE8fu3BG0UlkVcueUr05e33Kx1DMSFW72lR4dht1jruWsbFp6LlT3SUtyW2kcSet3fC8gySs2r6NncsZ2XFPoxTkalKpQ1atGoBe3XIKeT8RDZtgoLztQy7/7yANQKBgQDQvSHEKS5SttoFFf4YkUh2QmNX5m7XaDlTLB/3xjnlz8NWOweK1aVysb4t2Tct/SR4ZZ/qZDBlaaj4X9h9nlxxIMoXEyX6Ilc4tyCWBXxn6HFMSa/Rrq662Vzz228cPvW2XGOQWdj7IqwKO9cXgJkI5W84YtMtYrTPLDSjhfpxNwKBgGVCoPq/iSOpN0wZhbE1KiCaP8mwlrQhHSxBtS6CkF1a1DPm97g9n6VNfUdnB1Vf0YipsxrSBOe416MaaRyUUzwMBRLqExo1pelJnIIuTG+RWeeu6zkoqUKCAxpQuttu1uRo8IJYZLTSZ9NZhNfbveyKPa2D4G9B1PJ+3rSO+ztlAoGAZNRHQEMILkpHLBfAgsuC7iUJacdUmVauAiAZXQ1yoDDo0Xl4HjcvUSTMkccQIXXbLREh2w4EVqhgR4G8yIk7bCYDmHvWZ2o5KZtD8VO7EVI1kD0z4Zx4qKcggGbp2AINnMYqDetopX7NDbB0KNUklyiEvf72tUCtyDk5QBgSrqcCgYEAnlg3ByRd/qTFz/darZi9ehT68Cq0CS7/B9YvfnF7YKTAv6J2Hd/i9jGKcc27x6IMi0vf7zrqCyTMq56omiLdu941oWfsOnwffWRBInvrUWTj6yGHOYUtg2z4xESUoFYDeWwe/vX6TugL3oXSX3Sy3KWGlJhn/OmsN2fgajHRip0=")
            .build();

    private final String fileUrl;
    private final String propFileName = "config.properties";

    public PropertiesClient() throws Exception {
        fileUrl = "./" + propFileName;
    }

    public Map<String, String> getPropertiesOrDefaults() {
        try {
            Map<String, String> map = toMap(tryGetProperties());
            map.putAll(Maps.difference(map, DEFAULT_PROPERTY_VALUES).entriesOnlyOnRight());
            return map;
        } catch (FileNotFoundException e) {
            tryCreateDefaultFile();
            return new HashMap<>(DEFAULT_PROPERTY_VALUES);
        } catch (IOException e) {
            return new HashMap<>(DEFAULT_PROPERTY_VALUES);
        }
    }

    private Map<String, String> toMap(Properties properties) {
        return properties.entrySet().stream()
                .filter(entry -> entry.getValue() != null)
                .collect(Collectors.toMap(o -> o.getKey().toString(), t -> t.getValue().toString()));
    }

    private Properties toProperties(Map<String, String> propertiesMap) {
        Properties properties = new Properties();
        propertiesMap.entrySet()
                .stream()
                .forEach(entry -> properties.put(entry.getKey(), entry.getValue()));
        return properties;
    }

    private Properties tryGetProperties() throws IOException {
        InputStream inputStream = new FileInputStream(new File(fileUrl));
        Properties prop = new Properties();
        prop.load(inputStream);
        return prop;
    }

    public void savePropertiesToFile(Map<String, String> properties) {
        OutputStream outputStream = null;
        File file = new File(fileUrl);

        try {
            outputStream = new FileOutputStream(file);
            Properties p = toProperties(properties);
            p.store(outputStream, null);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            closeQuietly(outputStream);
        }
    }

    public void tryCreateDefaultFile() {
        System.out.println("Creating default properties file: " + propFileName);
        tryCreateFile().ifPresent(file -> savePropertiesToFile(DEFAULT_PROPERTY_VALUES));
    }

    private Optional<File> tryCreateFile() {
        try {
            File file = new File(fileUrl);
            file.createNewFile();
            return Optional.of(file);
        } catch (IOException e) {
            return Optional.empty();
        }
    }

    private void closeQuietly(Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (IOException e) {
            // ignored
        }
    }
}
