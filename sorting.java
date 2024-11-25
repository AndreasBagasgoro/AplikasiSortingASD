import java.util.Scanner;

class Mahasiswa {
    String nama;
    double ipk;

    public Mahasiswa(String nama, double ipk) {
        this.nama = nama;
        this.ipk = ipk;
    }
}

public class sorting {

    // Selection Sort
    public static void selectionSort(Mahasiswa[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].ipk < arr[minIndex].ipk) {
                    minIndex = j;
                }
            }
            Mahasiswa temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Insertion Sort
    public static void insertionSort(Mahasiswa[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            Mahasiswa key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].ipk > key.ipk) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean repeat = true;
        System.out.print("Masukkan nama Anda: ");
        String user = scanner.nextLine();

        System.out.println("----------SELAMAT DATANG " + user + " DI APLIKASI SORTING");

        while (repeat) {
            System.out.print("Masukkan jumlah mahasiswa yang ingin diurutkan: ");
            int jumlah = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            Mahasiswa[] mahasiswa = new Mahasiswa[jumlah];

            // Input data mahasiswa
            for (int i = 0; i < jumlah; i++) {
                System.out.print("Masukkan nama mahasiswa ke-" + (i + 1) + ": ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan IPK mahasiswa ke-" + (i + 1) + ": ");
                double ipk = scanner.nextDouble();
                scanner.nextLine(); // Consume newline character
                mahasiswa[i] = new Mahasiswa(nama, ipk);
            }

            // Memilih jenis sorting
            System.out.println("Pilih metode sorting:");
            System.out.println("1. Selection Sort");
            System.out.println("2. Insertion Sort");
            System.out.print("Masukkan pilihan (1/2): ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            if (pilihan == 1) {
                selectionSort(mahasiswa);
            } else if (pilihan == 2) {
                insertionSort(mahasiswa);
            } else {
                System.out.println("Pilihan tidak valid.");
                continue;
            }

            // Menampilkan hasil sorting
            System.out.println("\nHasil sorting:");
            for (int i = 0; i < mahasiswa.length; i++) {
                System.out.println((i + 1) + ". " + mahasiswa[i].nama + " - IPK: " + mahasiswa[i].ipk);
            }

            // Menanyakan apakah ingin mengulang program
            System.out.print("\nApakah Anda ingin memulai program lagi? (ya/tidak): ");
            String ulang = scanner.nextLine();
            if (ulang.equalsIgnoreCase("tidak")) {
                repeat = false;
                System.out.println("Terima kasih telah menggunakan program ini!");
            }
        }

        scanner.close();
    }
}
