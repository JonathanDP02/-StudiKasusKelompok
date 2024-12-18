import java.util.Scanner;

public class UAS1F07 {

    static int jml07 = 5;
    static String [] namaTim07 = new String[jml07];
    static int [][] jmlSkor07 = new int[jml07][3];
    static int idx07 = 0;
    public static void main(String[] args) {
        Scanner sc07 = new Scanner(System.in);
        int pilih07;

        do{
        System.out.println("===== Menu Utama =====");
        System.out.println("1. Input data Skor Tim");
        System.out.println("2. Tampilkan Tabel Skor");
        System.out.println("3. Tentukan Juara");
        System.out.println("4. Keluar");
        System.out.print("Pilih menu (1-4): ");
        pilih07 = sc07.nextInt();

        switch (pilih07) {
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
        }while (pilih07 != 4);
            
        
    }

    public static void input(){
        Scanner sc07 = new Scanner(System.in);
        int totalSkor07 = 0;
        int skor207 = 0;

        for(int i = 0; i < jml07; i++){
            System.out.print("Masukkan nama tim ke-" + (i+1) + " : ");
            String tim07 = sc07.nextLine();
            System.out.printf("Masukkan sekor %s untuk level 1 :", tim07);
            int skor07 = sc07.nextInt();

            if (skor07 >= 35 || skor07 <= 0) {
                System.out.printf("Masukkan sekor %s untuk level 2 :", tim07);
                skor207 = sc07.nextInt();
            }else{
                System.out.println("!!! Input Skor Tidak Valid !!!");
                skor07 = 0;
                break;
            }

            totalSkor07 = skor07 + skor207;
            jmlSkor07[idx07][0] = skor07;
            jmlSkor07[idx07][1] = skor207;
            jmlSkor07[idx07][2] = totalSkor07;
            
            System.out.println();
            sc07.nextLine();
            namaTim07[idx07] = tim07;
            idx07++;
        }
    }

    public static void tampilan(){

        System.out.println("========== TABEL SKOR TURNAMEN ==========");
        System.out.println("Nama tim\tLevel 1\tlevel 2\tTotal Skor");
        
            
            for(int i = 0; i < namaTim07.length; i++){
                System.out.print(namaTim07[i]+"\t\t");
                for(int j = 0; j < jmlSkor07[i].length; j++){
                    System.out.print(jmlSkor07[i][j] + "\t");
                }
                System.out.println();
            }
    }

    public static void tertinggi(){
        int skor07 = 0;
        int tertinggi07 = 0;

        for(int i = 0; i < jmlSkor07.length; i++){
            skor07 = jmlSkor07[idx07][2];
            if (skor07 > skor07) {
                tertinggi07 = skor07;
            }
        }

        System.out.println("Selamat kepada Tim " );

        
    }
}
