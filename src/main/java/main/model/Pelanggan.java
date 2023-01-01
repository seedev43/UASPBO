package main.model;

import java.util.ArrayList;

public class Pelanggan {

    private int id;
    private String nama, alamat, noHp;

    public Pelanggan(int id, String nama, String alamat, String noHp) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.noHp = noHp;
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

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getNoHp() {
        return noHp;
    }

    public ArrayList<String> getPelanggan() {
        ArrayList<String> data = new ArrayList<>();
        data.add(String.valueOf(id));
        data.add(nama);
        data.add(alamat);
        data.add(noHp);
        return data;
    }

}
