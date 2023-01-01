package main.model;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Barang {

    private int id;
    private String merek;
    private String tipe;
    private String warna;
    private int stock;
    private int harga;
    private Timestamp inTime;
    private Timestamp outTime;

    public Barang(int id, String merek, String tipe, String warna, int stock, int harga, Timestamp inTime) {
        this.id = id;
        this.merek = merek;
        this.tipe = tipe;
        this.warna = warna;
        this.stock = stock;
        this.harga = harga;
        this.inTime = inTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMerek() {
        return merek;
    }

    public void setMerek(String merek) {
        this.merek = merek;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public Timestamp getInTime() {
        return inTime;
    }

    public void setInTime(Timestamp inTime) {
        this.inTime = inTime;
    }

    public Timestamp getOutTime() {
        return outTime;
    }

    public void setOutTime(Timestamp outTime) {
        this.outTime = outTime;
    }

    public ArrayList<String> getBarang() {
        ArrayList<String> data = new ArrayList<>();
        data.add(String.valueOf(id));
        data.add(merek);
        data.add(tipe);
        data.add(warna);
        data.add(String.valueOf(stock));
        data.add(String.valueOf(harga));
        data.add(inTime.toString());
        data.add(outTime.toString());
        return data;
    }
}
