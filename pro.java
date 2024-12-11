import java.util.Scanner;

public class pro {

    static String dataMhs [][]= new String[100][4];
    static int idx = 0;
    static int nilaiSKS [] = new int[100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilih;

        do{
            System.out.println("=== Sistem Pemantauan KRS Mahasiswa ===");
            System.out.println("1. Tambah data KRS");
            System.out.println("2. Tampilkan daftar KRS Mahasiswa");
            System.out.println("3. Analis data KRS");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
                pilih = sc.nextInt();
                sc.nextLine();

                switch (pilih) {
                    case 1:
                        tambahData();
                        break;

                    case 2:
                        tampilanKRS();
                        break;

                    case 3:
                        analisKRS();
                        break;

                    case 4:
                        System.out.println("Terima Kasih");
                        break;
                
                    default:
                        System.out.println("Pilihan tidak valid. mohon input dengan benar");
       }
    }while (pilih != 4);

    }

    public static void tambahData(){
        Scanner sc = new Scanner(System.in);
        System.out.println("==== Tambah Data KRS ====");
        System.out.print("Masukkkan nama Mahasiswa: ");
        String nama = sc.nextLine();
        System.out.print("Masukkan NIM Mahasiswa: ");
        String nim = sc.nextLine();

        String lanjut = "";
        do {
            System.out.print("Masukkan kode Matkul: ");
            String kodeMatkul = sc.nextLine();
            System.out.print("Masukkan nama Matkul: ");
            String namaMatkul = sc.nextLine();
            System.out.print("Masukkan jumlah SKS (1-3): ");
            int sks = sc.nextInt();
            sc.nextLine();

            if (sks < 1 || sks > 3) {
                System.out.println("INPUT SKS TIDAK VALID MOHON ULANGI LAGI!!!");
                continue;
            } 

            dataMhs [idx][0]=nama;
            dataMhs [idx][1]=nim;
            dataMhs [idx][2]=kodeMatkul;
            dataMhs [idx][3]=namaMatkul;
            nilaiSKS [idx] = sks;
            idx++;

            System.out.println("== DATA BERHASIL DITAMBAHKAN ==");
            System.out.print("Apakah ingin memasukan Matkul lain (y/n): ");
            lanjut = sc.nextLine();
            
        }while (lanjut.equalsIgnoreCase("y"));
    }

    public static void tampilanKRS(){
        Scanner sc = new Scanner(System.in);
        String nimLogin;

        System.out.println("==== Tampilkan Daftar KRS Mahasiswa ====");
        System.out.print("Masukkan NIM Mahasiswa: ");
        nimLogin = sc.nextLine();

        boolean nemu = false;
        int totalSKS = 0;

       

        for(int i = 0; i < idx; i++){

            System.out.println("Daftar KRS");
            System.out.println("NIM\tNAMA\tKode MK\tNama Mata Kuliah\tSKS");

            if (dataMhs[i][1].equals(nimLogin)) {
                System.out.println(dataMhs[i][1] + "\t" + dataMhs[i][0] + "\t" + dataMhs[i][2] + "\t" + dataMhs[i][3] + "\t\t" + nilaiSKS[i]);
                totalSKS += nilaiSKS[i];
                nemu = true;
            }
            
        }

        if (nemu) {
            System.out.println("Total SKS: " + totalSKS);
        }

        if (!nemu) {
            System.out.println("Data Mahasiswa dengan NIM " + nimLogin + " tidak ditemukan!!!");
            return;
        }
    }

    public static void analisKRS() {
        int mhsKurang = 0; 
    
        for (int i = 0; i < idx; i++) {
            String currentNIM = dataMhs[i][1]; 
            int totalSKS = 0; 
    
            for (int j = 0; j < idx; j++) {
                if (dataMhs[j][1].equals(currentNIM)) {
                    totalSKS += nilaiSKS[j]; 
                }
            }
    
            if (totalSKS < 20) {
                mhsKurang++;
            }
    
            while (i + 1 < idx && dataMhs[i][1].equals(dataMhs[i + 1][1])) {
                i++;
            }
        }
    
        System.out.println("Jumlah mahasiswa yang memiliki SKS kurang dari 20: " + mhsKurang);
    }
    
}