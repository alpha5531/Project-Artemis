package com.counterhost.ConfigOperator;

import java.io.FileInputStream;
import java.util.Properties;
public class PropertiesRead {
    private String appVersion;
    private String srodowisko;
    private String dataWydania;
    private String sciezkaLogow;
    private String adresBazyDanych;
    private String loginBazyDanych;
    private String hasloBazyDanych;
    private String pulaPolaczenMax;
    private String pulaPolaczenMin;
    private String czasZyciaPolaczenia;
    private String czasOczekiwaniaNaPolaczenie;
    private String logowaniePlikiBaza;
    private String logowanieAdresBazy;
    private String logowanieLoginBazy;
    private String logowanieHasloBazy;
    private String CzasOdswiezania;
    public PropertiesRead() {
        try {
            String appConfigPath = "src/main/java/com/counterhost/ConfigOperator/app.properties";
            Properties appProps = new Properties();
            appProps.load(new FileInputStream(appConfigPath));
            this.appVersion = appProps.getProperty("appVersion");
            this.srodowisko = appProps.getProperty("srodowisko");
            this.dataWydania = appProps.getProperty("dataWydania");
            this.sciezkaLogow = appProps.getProperty("sciezkaLogow");
            this.adresBazyDanych = appProps.getProperty("adresBazyDanych");
            this.loginBazyDanych = appProps.getProperty("loginBazyDanych");
            this.hasloBazyDanych = appProps.getProperty("hasloBazyDanych");
            this.pulaPolaczenMax = appProps.getProperty("pulaPolaczenMax");
            this.pulaPolaczenMin = appProps.getProperty("pulaPolaczenMin");
            this.czasZyciaPolaczenia = appProps.getProperty("czasZyciaPolaczenia");
            this.czasOczekiwaniaNaPolaczenie = appProps.getProperty("czasOczekiwaniaNaPolaczenie");
            this.logowaniePlikiBaza = appProps.getProperty("logowaniePlikiBaza");
            this.logowanieAdresBazy = appProps.getProperty("logowanieAdresBazy");
            this.logowanieLoginBazy = appProps.getProperty("logowanieLoginBazy");
            this.logowanieHasloBazy = appProps.getProperty("logowanieHasloBazy");
            this.CzasOdswiezania = appProps.getProperty("CzasOdswiezania");

        }catch(Throwable ex) {
            System.out.println(System.currentTimeMillis() + "Błąd w Properties!" + ex);
        }
    }

    public String getAppVersion() {
        return appVersion;
    }

    public String getSrodowisko() {
//        if(srodowisko.equals("DEV")){
//            srodowisko = "DEV - Wydanie: " + getAppVersion() + " Ścieżka logów: " + getSciezkaLogow();
//        }
        return srodowisko;
    }

    public String getDataWydania() {
        return dataWydania;
    }

    public String getSciezkaLogow() {
        return sciezkaLogow;
    }

    public String getAdresBazyDanych() {
        return adresBazyDanych;
    }

    public String getLoginBazyDanych() {
        return loginBazyDanych;
    }

    public String getHasloBazyDanych() {
        return hasloBazyDanych;
    }

    public int getPulaPolaczenMax() {
        return Integer.parseInt(pulaPolaczenMax);
    }

    public int getPulaPolaczenMin() {
        return Integer.parseInt(pulaPolaczenMin);
    }

    public int getCzasZyciaPolaczenia() {
        return Integer.parseInt(czasZyciaPolaczenia);
    }

    public int getCzasOczekiwaniaNaPolaczenie() {
        return Integer.parseInt(czasOczekiwaniaNaPolaczenie);
    }

    public String getLogowaniePlikiBaza() {
        return logowaniePlikiBaza;
    }

    public String getLogowanieAdresBazy() {
        return logowanieAdresBazy;
    }

    public String getLogowanieLoginBazy() {
        return logowanieLoginBazy;
    }

    public String getLogowanieHasloBazy() {
        return logowanieHasloBazy;
    }
    public String getCzasOdswiezania() {
        return CzasOdswiezania;
    }

}