package com.biletaluygulamasi.bilet_al;

public class list_item {
    private String saat;
    private String fiyat;
    private String resim;

    public list_item(String saat, String fiyat, String resim) {
        this.saat = saat;
        this.fiyat = fiyat;
        this.resim = resim;
    }

    public String getSaat() {
        return saat;
    }

    public String getFiyat() {

            return fiyat;

}

    public String getResim() {
        return resim;
    }
}

