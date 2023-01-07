package main.controller;

import java.sql.Connection;
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

    }

    public void delete(Karyawan kr) {

    }

    public boolean isExist(int id) {
        try {
            String sql = "SELECT * FROM karyawan WHERE id = ?";
            Connection conn = DBConnection.getConnection();
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            ResultSet res = stat.executeQuery();
            boolean isExist = res.next() && res.getInt(1) > 0;

            res.close();
            stat.close();
            conn.close();

            return isExist;

        } catch (SQLException e) {
            Logger.getLogger(TabelKaryawan.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }

    }

    public Karyawan getKaryawan(int id) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stat = conn.prepareStatement("SELECT * FROM karyawan WHERE id = ?");
            stat.setInt(1, id);
            ResultSet res = stat.executeQuery();

            if (!res.next()) {
                return null;
            }

            Karyawan kr = new Karyawan(id, res.getString("nama"));

            res.close();
            stat.close();
            conn.close();

            return kr;

        } catch (SQLException ex) {
            Logger.getLogger(TabelKaryawan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

//    public int getBanyakKaryawan() {
//        return kr.size();
//    }
//
//    public ArrayList<Karyawan> getSemuaKaryawan() {
//        return kr;
//    }
}
