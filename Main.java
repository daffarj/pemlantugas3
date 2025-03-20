import java.io.*;
import java.util.*;

public class Main {
    int count = 0;
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        Buku[] bookdata = new Buku[200];
        int i = 0;

        System.out.println("=======================");
        System.out.println("System manajemen buku!!");

        do {
            System.out.println("==== Menu ====");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Tampilkan daftar buku");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");
            i = input.nextInt();
            input.nextLine(); 

            switch (i) {
                case 1:
                    System.out.print("Berapa jumlah buku yang ingin ditambahkan? ");
                    int jumlah = input.nextInt();
                    input.nextLine();
                    if (jumlah <= 0) {
                        System.out.println("Mohon maaf angka tidak valid ");
                        continue;
                    }
                    for (int j = 0; j < jumlah; j++) {
                        System.out.print("Masukkan judul buku: ");
                        String judul = input.nextLine();
                        System.out.print("Masukkan nama penulis: ");
                        String penulis = input.nextLine();
                        System.out.print("Masukkan tahun terbit: ");
                        int tahun = input.nextInt();
                        input.nextLine();

                        Buku newbook = new Buku(judul, penulis, tahun);
                        bookdata[Buku.getjumlahbuku() - 1] = newbook;

                        try (BufferedWriter writer = new BufferedWriter(new FileWriter("dataBuku.txt", true))) {
                            writer.write(newbook.getJudulBuku() + " oleh " + newbook.getPenulis() + " (" + newbook.getTahunTerbit() + ")\n");
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        System.out.println("Buku berhasil ditambahkan!");
                    }
                    break;

                case 2:
                    System.out.println("Display informasi data buku");
                    System.out.println("1. Info Lengkap");
                    System.out.println("2. Info Singkat");
                    System.out.println("3. Keluar");
                    System.out.print("Pilih menu: ");
                    int pilihan = input.nextInt();

                    switch (pilihan) {
                        case 1:
                            Buku.displaybuku("dataBuku.txt");
                            break;
                        case 2:
                            Buku.displaybuku();
                            break;
                        case 3:
                            System.out.println("Terima Kasih");
                            break;
                        default:
                            System.out.println("Menu tidak tersedia");
                            break;
                    }
                    break;

                case 3:
                    System.out.println("Terima kasih telah menggunakan sistem manajemen buku.");
                    break;

                default:
                    System.out.println("Menu tidak tersedia, coba lagi.");
                    break;
            }
        } while (i != 3);
        input.close();
    }
}
