package jamusehat.app;

import jamusehat.model.Admin;
import jamusehat.model.Jamu;
import jamusehat.model.Pelanggan;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    ArrayList<Jamu> daftarJamu = new ArrayList<>();
    ArrayList<Pelanggan> daftarPelanggan = new ArrayList<>();
    ArrayList<Admin> daftarAdmin = new ArrayList<>();

    ArrayList<String> idPesananList = new ArrayList<>();
    ArrayList<String> idPelangganPesan = new ArrayList<>();
    ArrayList<String> namaJamuPesan = new ArrayList<>();
    ArrayList<Integer> jumlahPesan = new ArrayList<>();
    ArrayList<Double> totalHargaPesan = new ArrayList<>();

    ArrayList<String> idPembayaranList = new ArrayList<>();
    ArrayList<String> idPesananBayar = new ArrayList<>();
    ArrayList<String> namaJamuBayar = new ArrayList<>();
    ArrayList<Integer> jumlahBayar = new ArrayList<>();
    ArrayList<Double> totalBayar = new ArrayList<>();
    ArrayList<String> metodeBayar = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);
    int counterJamu = 4;
    int counterPesanan = 1;
    int counterBayar = 1;

    void main() {
        jalankan();
    }

    protected void jalankan() {
        daftarJamu.add(new Jamu("J1", "Jamu Kunyit Asam", "Menjaga daya tahan tubuh", 35000, 70));
        daftarJamu.add(new Jamu("J2", "Jamu Beras Kencur", "Menghilangkan pegal linu", 25000, 55));
        daftarJamu.add(new Jamu("J3", "Jamu Temulawak", "Menjaga kesehatan hati", 34000, 60));
        daftarJamu.add(new Jamu("J4", "Jamu Pahitan", "Detoksifikasi Tubuh", 25000, 40));
        daftarJamu.add(new Jamu("J5", "Jamu Brotowali", "Meningkatkan Daya Tahan Tubuh", 30000, 30));

        daftarPelanggan.add(new Pelanggan("P001", "Sari Tuti", "sari", "sari123"));
        daftarPelanggan.add(new Pelanggan("P002", "Malvin Rey", "malvin", "malvin123"));

        daftarAdmin.add(new Admin("A001", "Eca Syasya", "eca", "eca123"));

        boolean appJalan = true;
        while (appJalan) {
            System.out.println("\n================================");
            System.out.println("   TOKO JAMU SEHAT   ");
            System.out.println("================================");
            System.out.println("1. Login Pelanggan");
            System.out.println("2. Login Admin");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            if (pilihan == 1) loginPelanggan();
            else if (pilihan == 2) loginAdmin();
            else if (pilihan == 0) appJalan = false;
        }
    }

    void loginPelanggan() {
        System.out.println("\n--- LOGIN PELANGGAN ---");
        System.out.print("Username : ");
        String uname = scanner.nextLine();
        System.out.print("Password : ");
        String pass = scanner.nextLine();
        for (Pelanggan p : daftarPelanggan) {
            if (p.getUsername().equals(uname) && p.cekPassword(pass)) {
                p.sapa();
                menuPelanggan(p);
                return;
            }
        }
        System.out.println("Login Gagal!");
    }

    void loginAdmin() {
        System.out.println("\n--- LOGIN ADMIN ---");
        System.out.print("Username : ");
        String uname = scanner.nextLine();
        System.out.print("Password : ");
        String pass = scanner.nextLine();
        for (Admin a : daftarAdmin) {
            if (a.getUsername().equals(uname) && a.cekPassword(pass)) {
                a.sapa();
                menuAdmin(a);
                return;
            }
        }
        System.out.println("Login Gagal!");
    }

    void menuPelanggan(Pelanggan p) {
        boolean jalan = true;
        while (jalan) {
            System.out.println("\nMenu: " + p.getNama());
            System.out.println("1. Lihat Produk\n2. Pesan Jamu\n3. Pembayaran\n0. Logout");
            System.out.print("Pilih: ");
            int pil = scanner.nextInt();
            scanner.nextLine();
            if (pil == 1) lihatProdukJamu();
            else if (pil == 2) pesanJamu(p);
            else if (pil == 3) pembayaran(p);
            else if (pil == 0) jalan = false;
        }
    }

    void menuAdmin(Admin a) {
        boolean jalan = true;
        while (jalan) {
            System.out.println("\nAdmin: " + a.getNama());
            System.out.println("1. Lihat Produk\n2. Tambah Produk\n3. Update Produk\n4. Hapus Produk\n5. Lihat Pembayaran\n0. Logout");
            System.out.print("Pilih: ");
            int pil = scanner.nextInt();
            scanner.nextLine();
            if (pil == 1) lihatProdukJamu();
            else if (pil == 2) tambahProdukJamu();
            else if (pil == 3) updateProdukJamu();
            else if (pil == 4) hapusProdukJamu();
            else if (pil == 5) lihatPembayaran();
            else if (pil == 0) jalan = false;
        }
    }

    void lihatProdukJamu() {
        for (Jamu j : daftarJamu) j.tampilInfo();
    }

    void pesanJamu(Pelanggan p) {
        lihatProdukJamu();
        System.out.print("ID Jamu: ");
        String id = scanner.nextLine();
        for (Jamu j : daftarJamu) {
            if (j.getIdJamu().equals(id)) {
                System.out.print("Jumlah: ");
                int qty = scanner.nextInt();
                scanner.nextLine();
                if (qty <= j.getStok()) {
                    idPesananList.add("ORD" + counterPesanan++);
                    idPelangganPesan.add(p.getId());
                    namaJamuPesan.add(j.getNamaJamu());
                    jumlahPesan.add(qty);
                    totalHargaPesan.add(qty * j.getHarga());
                    j.kurangiStok(qty);
                    System.out.println("Pesanan dibuat!");
                }
                return;
            }
        }
    }

    void pembayaran(Pelanggan p) {
        for (int i = 0; i < idPesananList.size(); i++) {
            if (idPelangganPesan.get(i).equals(p.getId())) {
                System.out.println(idPesananList.get(i) + " | " + namaJamuPesan.get(i));
            }
        }
        System.out.print("ID Pesanan: ");
        String id = scanner.nextLine();
        for (int i = 0; i < idPesananList.size(); i++) {
            if (idPesananList.get(i).equals(id)) {
                idPembayaranList.add("PAY" + counterBayar++);
                idPesananBayar.add(id);
                namaJamuBayar.add(namaJamuPesan.get(i));
                totalBayar.add(totalHargaPesan.get(i));
                metodeBayar.add("Transfer");
                System.out.println("Pembayaran Berhasil!");
                return;
            }
        }
    }

    void tambahProdukJamu() {
        String id = "J" + counterJamu++;
        System.out.print("Nama: ");
        String n = scanner.nextLine();
        System.out.print("Khasiat: ");
        String k = scanner.nextLine();
        System.out.print("Harga: ");
        double h = scanner.nextDouble();
        System.out.print("Stok: ");
        int s = scanner.nextInt();
        scanner.nextLine();
        daftarJamu.add(new Jamu(id, n, k, h, s));
    }

    void updateProdukJamu() {
        System.out.print("ID Jamu: ");
        String id = scanner.nextLine();
        for (Jamu j : daftarJamu) {
            if (j.getIdJamu().equals(id)) {
                System.out.print("Nama Baru: ");
                j.setNamaJamu(scanner.nextLine());
                System.out.print("Harga Baru: ");
                j.setHarga(scanner.nextDouble());
                System.out.print("Stok Baru: ");
                j.setStok(scanner.nextInt());
                scanner.nextLine();
                return;
            }
        }
    }

    void hapusProdukJamu() {
        System.out.print("ID Jamu: ");
        String id = scanner.nextLine();
        daftarJamu.removeIf(j -> j.getIdJamu().equals(id));
    }

    void lihatPembayaran() {
        for (int i = 0; i < idPembayaranList.size(); i++) {
            System.out.println(idPembayaranList.get(i) + " | Rp " + totalBayar.get(i));
        }
    }
}