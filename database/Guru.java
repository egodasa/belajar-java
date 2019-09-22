package Model;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class Guru extends Db{
    public String kode_guru;	
    public String nip;
    public String nama_guru;
    public String kelamin;
    public String alamat;
    public String no_telepon;	
    public String kode_pelajaran;
    public String status_aktif;
    private String table = "guru";
    private String view;
    private String primary_key = "kode_guru";
    public String getKode_guru() {
        return kode_guru;
    }

    public void setKodeGuru(String kode_guru) {
        this.kode_guru = kode_guru;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNamaGuru() {
        return nama_guru;
    }

    public void setNamaGuru(String nama_guru) {
        this.nama_guru = nama_guru;
    }

    public String getKelamin() {
        return kelamin;
    }

    public void setKelamin(String kelamin) {
        this.kelamin = kelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoTelepon() {
        return no_telepon;
    }

    public void setNoTelepon(String no_telepon) {
        this.no_telepon = no_telepon;
    }

    public String getKodePelajaran() {
        return kode_pelajaran;
    }

    public void setKodePelajaran(String kode_pelajaran) {
        this.kode_pelajaran = kode_pelajaran;
    }

    public String getStatusAktif() {
        return status_aktif;
    }

    public void setStatusAktif(String status_aktif) {
        this.status_aktif = status_aktif;
    }
    
    /*
     *  getGuru()
     *  Hasil return : array of Guru objects
     *  Kegunaan : untuk mengambil data guru dari database dan memasukkannya kedalam array list
     */
    public ArrayList<Guru> getGuru(){
        ArrayList<Guru> data = new ArrayList<>();
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM " + table;
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                Guru data_tmp = new Guru();
                data_tmp.setKodeGuru(rs.getString("kode_guru"));
                data_tmp.setNip(rs.getString("nip"));
                data_tmp.setNamaGuru(rs.getString("nama_guru"));
                data_tmp.setKelamin(rs.getString("kelamin"));
                data_tmp.setAlamat(rs.getString("alamat"));
                data_tmp.setNoTelepon(rs.getString("no_telepon"));
                data_tmp.setKodePelajaran(rs.getString("kode_pelajaran"));
                data_tmp.setStatusAktif(rs.getString("status_aktif"));
                data.add(data_tmp);
            }
            stmt.close();
            conn.close();
        }catch (ClassNotFoundException | SQLException ex){
            System.out.println("Error" + ex);
        }
        return data;
    }
    
    /*
     * 
     * getGuruById(String id)
     * Param :
     * id = string, merupakan id daripada guru
     * 
     * Hasil return : Object guru 
     * 
     * Keterangan : mengambil data guru berdasarkan id
     */
    public Guru getGuruById(String id){
        Guru data_guru = new Guru();
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pass);
            
            stmt = conn.createStatement();
            String sql = "SELECT * FROM " + table + " WHERE " + primary_key + " = " + id;
            rs = stmt.executeQuery(sql);
                data_guru.setKodeGuru(rs.getString("kode_guru"));
                data_guru.setNip(rs.getString("nip"));
                data_guru.setNamaGuru(rs.getString("nama_guru"));
                data_guru.setKelamin(rs.getString("kelamin"));
                data_guru.setAlamat(rs.getString("alamat"));
                data_guru.setNoTelepon(rs.getString("no_telepon"));
                data_guru.setKodePelajaran(rs.getString("kode_pelajaran"));
                data_guru.setStatusAktif(rs.getString("status_aktif"));
            stmt.close();
            conn.close();
        }catch (ClassNotFoundException | SQLException ex){
            System.out.println("Error" + ex);
        }
        return data_guru;
    }
    
    /*
     * addGuru()
     * Hasil return : boolean, true jika proses berhasil dilakukan, false jika ada error
     * Keterangan : melakukan penambahan data guru, atur terlebih dahulu semua properti guru menggunakan setter sebelum menjalankan method ini
     */
    public boolean addGuru(){
        boolean hasil = false;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pass);
            
            // buat objek statement
            stmt = conn.createStatement();
            
            // buat query ke database
            String sql = "INSERT INTO " + table + " (kode_guru, nip, nama_guru, kelamin, alamat, no_telepon, kode_pelajaran, status_aktif)";
            sql += " VALUES('" + getKode_guru() + "', '" + getNip() + "', '" + getNamaGuru() + "', '" + getKelamin() + "', '" + getAlamat() + "', '" + getNoTelepon()+ "', '" + getKodePelajaran()+ "', '" + getStatusAktif()+ "')";
            hasil = stmt.execute(sql);
            stmt.close();
            conn.close();
        }catch (ClassNotFoundException | SQLException ex){
            System.out.println("Error" + ex);
        }
        return hasil;
    }
    
    /*
     * editGuru(String id)
     * Parameter: 
     * id = string, id dari guru yang akan diedit
     * Hasil return : boolean, true jika proses berhasil dilakukan, false jika ada error
     * Keterangan : melakukan pengeditan data guru, atur terlebih dahulu semua properti guru menggunakan setter sebelum menjalankan method ini
     */
    public boolean editGuru(String id){
        boolean hasil = false;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pass);
            
            // buat objek statement
            stmt = conn.createStatement();
            
            // buat query ke database
            String sql = "UPDATE " + table + " SET nama_guru = '" + getNamaGuru() + "', kelamin = '" + getKelamin() + "', alamat = '" + getAlamat() + "', no_telepon = '" + getNoTelepon() + "', kode_pelajaran = '" + getKodePelajaran() + "', status_aktif = '" + getStatusAktif() + "' WHERE " + primary_key + " = " + id;
            hasil = stmt.execute(sql);
            stmt.close();
            conn.close();
        }catch (ClassNotFoundException | SQLException ex){
            System.out.println("Error" + ex);
        }
        return hasil;
    }
    
    /*
     * deleteGuru(String id)
     * Parameter :
     * id = id dari guru yang akan dihapus
     * Hasil return : boolean, true jika proses berhasil dilakukan, false jika ada error
     * Keterangan : melakukan penghapusan data guru berdasarkan primary key atau id
     */
    public boolean deleteGuru(String id){
        boolean hasil = false;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pass);
            
            // buat objek statement
            stmt = conn.createStatement();
            
            // buat query ke database
            String sql = "DELETE FROM " + table + " WHERE " + primary_key + " = " + id;
            hasil = stmt.execute(sql);
            stmt.close();
            conn.close();
        }catch (ClassNotFoundException | SQLException ex){
            System.out.println("Error" + ex);
        }
        return hasil;
    }
}
