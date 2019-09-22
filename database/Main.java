import Model.Guru;
import java.util.ArrayList;
/**
 *
 * @author mandan
 */
public class Main {
    public static void main(String[] args){
      ArrayList<Guru> data = data_guru.getGuru();
      Guru data_guru = new Guru();
      
      // Test tampilkan data guru
      int banyak_guru = data.size();
      for(int x = 0; x < banyak_guru; x++){
          System.out.println(data.get(x).getNip()); // menampilkan nip
          System.out.println(data.get(x).getNamaGuru()); // menampilkan nama guru
      }
      
      // Test tampilkan guru berdasarkan primary key
      Guru detail_guru = data_guru.getGuruById("G0013"); // ambil data guru berdasarkan primary key
      System.out.println(detail_guru.getKode_guru()); // menampilkan kode guru
      System.out.println(detail_guru.getNamaGuru()); // menampilkan nama guru
      
      // Tes delete guru
      System.out.println(data_guru.deleteGuru("12341")); // hapus data guru berdasarkan primary key
      
      // Tes add data guru
      data_guru.setAlamat("Alamat gundulmu");
      data_guru.setKelamin("Jantan");
      data_guru.setKodeGuru("12341");
      data_guru.setKodePelajaran("Pk121");
      data_guru.setNamaGuru("Guru mu");
      data_guru.setNip("9198281");
      data_guru.setNoTelepon("0928003223");
      data_guru.setStatusAktif("Aktif");
      // true jika berhasil insert, false sebaliknya
      System.out.println(data_guru.addGuru());
      
      // tes update guru
      data_guru.setAlamat("Edited");
      data_guru.setKelamin("Edited");
      data_guru.setKodePelajaran("Edited");
      data_guru.setNamaGuru("Edited");
      data_guru.setNoTelepon("Edited");
      data_guru.setStatusAktif("Aktif");
      System.out.println(data_guru.editGuru("12341"));
      
      
    }
}
