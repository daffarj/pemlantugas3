import java.io.*;

public class Buku{
    private String judulBuku;
    private String penulis;
    private int tahunTerbit;
    private static int jumlahbuku = 0;

    // membuat constructor class Buku dengan parameter
    public Buku(String judulBuku, String penulis, int tahunTerbit){
        this.judulBuku = judulBuku;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
        jumlahbuku++;
    }
    // constructor class Buku tanpa parameter (overloading) 
    public Buku(){}

    // getter method
    public String getJudulBuku(){
        return judulBuku;
    }

    public String getPenulis(){
        return penulis;
    }

    public int getTahunTerbit(){
        return tahunTerbit;
    }

    public static int getjumlahbuku(){
        return jumlahbuku;
    }

    // menambahkan data buku baru
    public String displaybuku(Buku buku){
        String datanya = "-" + buku.getJudulBuku() + "oleh" + buku.getPenulis() + "(" + buku.getTahunTerbit() + ")" ;
        return datanya;
    }

    // method untuk menampilkan data buku
    public static void displaybuku(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader("./databuku.txt"));
            String line;
            System.out.println("====Daftar Buku Singkat====");
            while ((line = reader.readLine()) != null) {
                // dipisahkan berdasarkan kata oleh
                int end = line.indexOf("oleh");
                // apabila ditemukan
                if (end > 0) {
                    // mengambil hanya judulnya saja
                    String judulbuku = line.substring(0, end);
                    System.out.println("-" + judulbuku);
                } else {
                    // jika format tidak sesuai maka cetak keseluruhan
                    System.out.println(" - " + line);
                }
                
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca file !");
            e.printStackTrace();
        }
    
    }

    public static void displaybuku(String filename){
        System.out.println("==== Daftar Buku Lengkap ====");
        try(BufferedReader reader = new BufferedReader(new FileReader("./databuku.txt"))){
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        }catch(IOException e){
            System.out.println("Terjadi Eror : " + e.getMessage());
        }
    }
}
