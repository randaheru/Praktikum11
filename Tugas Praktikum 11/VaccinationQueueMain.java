import java.util.Scanner;

public class VaccinationQueueMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue queue = new Queue();
        int choice;

        do {
            System.out.println("\nPENGANTRI VAKSIN EXTRAVAGANZA\n");
            System.out.println("1. Tambah Data Penerima Vaksin");
            System.out.println("2. Hapus Data Pengantri Vaksin");
            System.out.println("3. Daftar Penerima Vaksin");
            System.out.println("4. Keluar");
            System.out.print("\nPilih menu: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nMasukkan Data Penerima Vaksin");
                    System.out.print("Nomor Antrian: ");
                    int nomorAntrian = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Nama Penerima: ");
                    String namaPenerima = scanner.nextLine();
                    queue.enqueue(nomorAntrian, namaPenerima);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.displayQueue();
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan layanan kami.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
