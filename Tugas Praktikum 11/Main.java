import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoubleLinkedList list = new DoubleLinkedList();
        int choice;

        do {
            System.out.println("\n==================");
            System.out.println("DATA FILM LAYAR LEBAR");
            System.out.println("==================");
            System.out.println("1. Tambah Data Awal");
            System.out.println("2. Tambah Data Akhir");
            System.out.println("3. Tambah Data Index Tertentu");
            System.out.println("4. Hapus Data Pertama");
            System.out.println("5. Hapus Data Terakhir");
            System.out.println("6. Hapus Data Tertentu");
            System.out.println("7. Cetak");
            System.out.println("8. Cari ID Film");
            System.out.println("9. Urut Data Rating Film-DESC");
            System.out.println("10. Keluar");
            System.out.println("==================");
            System.out.print("Pilih menu: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("ID Film: ");
                    int idAwal = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Judul Film: ");
                    String titleAwal = scanner.nextLine();
                    System.out.print("Rating Film: ");
                    double ratingAwal = scanner.nextDouble();
                    list.addFirst(new Film(idAwal, titleAwal, ratingAwal));
                    break;
                case 2:
                    System.out.print("ID Film: ");
                    int idAkhir = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Judul Film: ");
                    String titleAkhir = scanner.nextLine();
                    System.out.print("Rating Film: ");
                    double ratingAkhir = scanner.nextDouble();
                    list.addLast(new Film(idAkhir, titleAkhir, ratingAkhir));
                    break;
                case 3:
                    System.out.print("ID Film: ");
                    int idTengah = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Judul Film: ");
                    String titleTengah = scanner.nextLine();
                    System.out.print("Rating Film: ");
                    double ratingTengah = scanner.nextDouble();
                    System.out.print("Urutan ke-: ");
                    int index = scanner.nextInt();
                    try {
                        list.add(new Film(idTengah, titleTengah, ratingTengah), index);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        list.removeFirst();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        list.removeLast();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.print("Urutan ke-: ");
                    int indexHapus = scanner.nextInt();
                    try {
                        list.remove(indexHapus);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    list.print();
                    break;
                case 8:
                    System.out.print("Masukkan ID Film yang dicari: ");
                    int idCari = scanner.nextInt();
                    list.searchById(idCari);
                    break;
                case 9:
                    list.sortDescendingByRating();
                    System.out.println("Data telah diurutkan berdasarkan rating secara descending.");
                    break;
                case 10:
                    System.out.println("Terima kasih telah menggunakan program ini.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (choice != 10);

        scanner.close();
    }
}
