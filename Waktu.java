import java.util.Date;
import java.text.*;
class Waktu {
  public static void main(String[] args){
    // Buat waktu baru
    Date date = new Date();
    
    System.out.println(date.toString()); // Sun Sep 22 19:22:16 WIB 2019
    System.out.println(date.getTime()); // 1569154976146 waktu dalam milisecond  sejak 1 januari 1970
    
    SimpleDateFormat ft = new SimpleDateFormat ("dd-MM-yyyy hh:mm:ss"); // buat object baru yang menampung format waktu
    System.out.println(ft.format(date)); // 22-09-2019 07:22:16
    // ft.parse("22-09-2019 07:22:16"); parsing waktu dari string sesuai dengan format simple date format
    
    System.out.println(String.format("Format waktu pakai string: %tdd-MM-yyyy", date));
    
    // Thread.sleep(5*60*10);  menghentikan proses eksekusi selama 3 detik atau 3000 ms
  }
}
