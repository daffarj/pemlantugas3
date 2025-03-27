# pemlantugas3
**code**
1. [Buku.java](Buku.java)
2. [Main.java](Main.java)
3. [datBuku.txt](dataBuku.txt)

## 1. Class Buku
### Constructor dan Overloadin class Buku
Dalam class `Buku.java` ada constructor dan Overloading agar memasukan data buku lebih fleksibel
```java
// membuat constructor class Buku dengan parameter
    public Buku(String judulBuku, String penulis, int tahunTerbit){
        this.judulBuku = judulBuku;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
        jumlahbuku++;
    }
    // constructor class Buku tanpa parameter (overloading) 
    public Buku(){}
```
### Method untuk menampilkan data buku dan membaca data buku dari file .txt
Method ini menggunakan Bufferreader untuk membaca file .txt yang dibuat untuk menyimpan data yang telah dimasukan
```java
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
```
## 2. Class Main
### Class Main berisikan deklarasi dan instansiasi objek class buku untuk dan juga inisialisasi data buku ke dalam data array
```java
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
```
### Looping do while dan Switch Case 
Digunakan untuk menentukan menu mana yang dipilih user
```java
do {
            System.out.println("==== Menu ====");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Tampilkan daftar buku");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");
            i = input.nextInt();
            input.nextLine(); 

            switch (i)
```
#### case 1
digunakan untuk menambahkan data buku
```java
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
```
#### case 2
digunakan untuk display informasi data buku yang dibaca di file .txt
```java
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
```
#### case 3 
digunakan untuk mengakhiri program
```java
                case 3:
                    System.out.println("Terima kasih telah menggunakan sistem manajemen buku.");
                    break;
```
### default dan While
default digunakan ketika user menginputkan data yang salah atau tidak sesuai, kemudian while digunakan untuk menentukan sampai kapan looping berjalan
```java
  default:
                    System.out.println("Menu tidak tersedia, coba lagi.");
                    break;
            }
        } while (i != 3);
```
## 3. Gambar ketika code berjalan

