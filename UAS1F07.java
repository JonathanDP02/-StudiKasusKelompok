import java.util.Scanner;

public class UAS1F07 {

    static int jml = 5;
    static String [] namaTim = new String[jml];
    static int [][] jmlSkor = new int[jml][3];
    static int idx = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilih;

        do{
        System.out.println("===== Menu Utama =====");
        System.out.println("1. Input data Skor Tim");
        System.out.println("2. Tampilkan Tabel Skor");
        System.out.println("3. Tentukan Juara");
        System.out.println("4. Keluar");
        System.out.print("Pilih menu (1-4): ");
        pilih = sc.nextInt();

        switch (pilih) {
            case 1:
                input();
                break;
            
            case 2:
                tampilan();
                break;

            case 3:
                tertinggi();
                break;

            case 4:
                System.out.println("terima kasih");
                break;
            default:
                System.out.println("!!! INPUT TIDAK VALID !!!");
                break;
            }
        }while (pilih != 4);
            
        
    }

    public static void input(){
        Scanner sc = new Scanner(System.in);
        int totalSkor = 0;
        int skor2 = 0;

        for(int i = 0; i < jml; i++){
            System.out.print("Masukkan nama tim ke-" + (i+1) + " : ");
            String tim = sc.nextLine();
            System.out.printf("Masukkan sekor %s untuk level 1 :", tim);
            int skor = sc.nextInt();

            if (skor >= 35 || skor <= 0) {
                System.out.printf("Masukkan sekor %s untuk level 2 :", tim);
                skor2 = sc.nextInt();
            }else{
                System.out.println("!!! Input Skor Tidak Valid !!!");
                skor = 0;
                break;
            }

            totalSkor = skor + skor2;
            jmlSkor[idx][0] = skor;
            jmlSkor[idx][1] = skor2;
            jmlSkor[idx][2] = totalSkor;
            
            System.out.println();
            sc.nextLine();
            namaTim[idx] = tim;
            idx++;
        }
    }

    public static void tampilan(){

        System.out.println("========== TABEL SKOR TURNAMEN ==========");
        System.out.println("Nama tim\tLevel 1\tlevel 2\tTotal Skor");
        
            
            for(int i = 0; i < namaTim.length; i++){
                System.out.print(namaTim[i]+"\t\t");
                for(int j = 0; j < jmlSkor[i].length; j++){
                    System.out.print(jmlSkor[i][j] + "\t");
                }
                System.out.println();
            }
    }

    public static void tertinggi(){
        int skor = 0;
        int tertinggi = 0;

        for(int i = 0; i < jmlSkor.length; i++){
            skor = jmlSkor[idx][2];
            if (skor > skor) {
                tertinggi = skor;
            }
        }

        System.out.println("Selamat kepada Tim " );

        
    }
}
