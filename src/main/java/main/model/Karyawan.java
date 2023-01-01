package main.model;

import java.util.ArrayList;

public class Karyawan {

    private int id;
    private String nama;

    public Karyawan(int id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public ArrayList<String> getKaryawan() {
        ArrayList<String> data = new ArrayList<>();
        data.add(String.valueOf(id));
        data.add(nama);
        return data;
    }

}
