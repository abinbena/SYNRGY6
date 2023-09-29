import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class ProgramPemesanan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] menu = {"Nasi Goreng", "Mie Goreng", "Ayam Goreng","Es Teh","Es Jeruk"};
        double[] harga = {10000, 8000, 22000, 4000, 5000 };
        int[] pesanan = new int[menu.length];

        int pilih;
        do {
            System.out.println("=============\nMenu Makanan:\n=============");
            for (int i = 0; i < menu.length; i++) {
                System.out.println((i + 1) + ". " + menu[i] + " | Rp" + harga[i]);
            }
            System.out.println("\n99. Bayar dan Beli");
            System.out.println("0. Keluar");
            System.out.println("\n=>");
            pilih = input.nextInt();
            input.nextLine();

            if (pilih > 0 && pilih <= menu.length) {
                int selectedMenuIndex = pilih - 1;

                System.out.print("Masukkan jumlah pesanan " + menu[selectedMenuIndex] + ": ");
                int quantity = input.nextInt();
                input.nextLine();

                pesanan[selectedMenuIndex] += quantity;
                System.out.println("Pesanan " + menu[selectedMenuIndex] + " sebanyak " + quantity + " telah ditambahkan.");
            }
            else if (pilih == 99) {
                double totalHarga = 0.0;
                System.out.println("Pesanan Anda:");

                for (int i = 0; i < menu.length; i++) {
                    if (pesanan[i] > 0) {
                        double subtotal = pesanan[i] * harga[i];
                        totalHarga += subtotal;
                        System.out.println(menu[i] + " - " + pesanan[i] + " x Rp" + harga[i] + " = Rp" + subtotal);
                    }
                }

                System.out.println("Total Harga: Rp" + totalHarga);

                System.out.println("Apakah Anda ingin konfirmasi dan membayar?");
                System.out.println("1. Konfirmasi dan Bayar\n2. Kembali ke menu utama\n3. Pesan ulang\n0. Keluar Aplikasi\n");
                System.out.println("=>");
                int konfirmasi = input.nextInt();

                if (konfirmasi == 1) {
                    simpanStruk(menu, pesanan, harga, totalHarga);
                    pilih = 0;
                } else if (konfirmasi == 2) {
                    continue;
                } else if (konfirmasi == 3) {
                    pesanan = new int[menu.length];
                } else pilih = 0;
            }
        } while (pilih != 0);

        System.out.println("Terima kasih telah menggunakan layanan kami!");
    }
    private static void simpanStruk(String[] menu, int[] pesanan, double[] harga, double totalHarga) {
        try {
            FileWriter fileWriter = new FileWriter("struk_pembayaran.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("Struk Pembayaran:");
            bufferedWriter.newLine();
            bufferedWriter.write("=================");
            bufferedWriter.newLine();

            for (int i = 0; i < menu.length; i++) {
                if (pesanan[i] > 0) {
                    double subtotal = pesanan[i] * harga[i];
                    bufferedWriter.write(menu[i] + " | " + pesanan[i] + " x Rp" + harga[i] + " = Rp" + subtotal);
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.write("=================+");
            bufferedWriter.newLine();
            bufferedWriter.write("Total Harga: Rp" + totalHarga);

            bufferedWriter.close();

            System.out.println("Struk pembayaran telah disimpan dalam file struk_pembayaran.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
