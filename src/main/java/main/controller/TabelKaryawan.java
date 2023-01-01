package main.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.model.database.DBConnection;
import main.model.Karyawan;

public class TabelKaryawan {

    private ArrayList<Karyawan> kr;

    public TabelKaryawan() {
        kr = new ArrayList<>();
    }

    public void insert(Karyawan kr) {
        try {
            String sql = "INSERT INTO karyawan (id, nama) VALUES (?, ?)";
            PreparedStatement stat = DBConnection.getConnection().prepareStatement(sql);

            stat.setInt(1, kr.getId());
            stat.setString(2, kr.getNama());

            stat.executeUpdate();
            stat.close();

        } catch (SQLException e) {
            Logger.getLogger(TabelKaryawan.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void update(Karyawan kr) {
        int indeks = -1;
        for (int i = 0; i < getBanyakKaryawan(); i++) {
            if (this.kr.get(i).getId() == kr.getId()) {
                indeks = i;
                break;
            }
        }
        if (indeks >= 0) {
            this.kr.set(indeks, kr);
        }
    }

    public void delete(Karyawan kr) {
        this.kr.remove(kr);
    }

    public boolean isExist(int id) {
        try {
            String sql = "SELECT * FROM karyawan WHERE id = ?";
            PreparedStatement stat = DBConnection.getConnection().prepareStatement(sql);
            stat.setInt(1, id);
            ResultSet res = stat.executeQuery();
            return res.next() && res.getInt(1) > 0;

        } catch (SQLException e) {
            Logger.getLogger(TabelKaryawan.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }

    }

    public Karyawan getKaryawan(int id) {
        int indeks = -1;
        for (int i = 0; i < getBanyakKaryawan(); i++) {
            if (kr.get(i).getId() == id) {
                indeks = i;
                break;
            }
        }
        return (indeks >= 0) ? kr.get(indeks) : null;
    }

    public int getBanyakKaryawan() {
        return kr.size();
    }

    public ArrayList<Karyawan> getSemuaKaryawan() {
        return kr;
    }
}
