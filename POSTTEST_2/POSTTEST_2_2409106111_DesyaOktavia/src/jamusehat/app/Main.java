package jamusehat.app;

import jamusehat.model.Admin;
import jamusehat.model.Jamu;
import jamusehat.model.Pelanggan;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    ArrayList<Jamu>      daftarJamu      = new ArrayList<>();
    ArrayList<Pelanggan> daftarPelanggan = new ArrayList<>();
    ArrayList<Admin>     daftarAdmin     = new ArrayList<>();

    ArrayList<String>  idPesananList    = new ArrayList<>();
    ArrayList<String>  idPelangganPesan = new ArrayList<>();
    ArrayList<String>  namaJamuPesan    = new ArrayList<>();
    ArrayList<Integer> jumlahPesan      = new ArrayList<>();
    ArrayList<Double>  totalHargaPesan  = new ArrayList<>();

    ArrayList<String>  idPembayaranList = new ArrayList<>();
    ArrayList<String>  idPesananBayar   = new ArrayList<>();
    ArrayList<String>  namaJamuBayar    = new ArrayList<>();
    ArrayList<Integer> jumlahBayar      = new ArrayList<>();
    ArrayList<Double>  totalBayar       = new ArrayList<>();
    ArrayList<String>  metodeBayar      = new ArrayList<>();

    Scanner scanner    = new Scanner(System.in);
    int counterJamu    = 4;
    int counterPesanan = 1;
    int counterBayar   = 1;

    void main() {
        jalankan();
    }

    protected void jalankan() {
        Jamu jamu1 = new Jamu();
        jamu1.setIdJamu("J1");
        jamu1.setNamaJamu("Jamu Kunyit Asam");
        jamu1.setKhasiat("Menjaga daya tahan tubuh");
        jamu1.setHarga(15000);
        jamu1.setStok(50);
        daftarJamu.add(jamu1);
        daftarJamu.add(new Jamu("J2", "Jamu Beras Kencur", "Menghilangkan pegal linu", 12000, 40));
        daftarJamu.add(new Jamu("J3", "Jamu Temulawak",    "Menjaga kesehatan hati",   18000, 30));

        Pelanggan p1 = new Pelanggan("P001", "sari", "sari123");
        p1.setNamaPelanggan("Sari Tuti");
        daftarPelanggan.add(p1);
        Pelanggan p2 = new Pelanggan("P002", "Malvin Rey", "malvin", "malvin123");
        p2.setIdPelanggan("P002");
        p2.setUsername("malvin");
        p2.setPassword("malvin123");
        daftarPelanggan.add(p2);

        Admin adminEca = new Admin("A001", "Eca", "eca", "eca123");
        adminEca.setIdAdmin("A001");
        adminEca.setNamaAdmin("Eca");
        adminEca.setUsername("eca");
        adminEca.setPassword("eca123");
        daftarAdmin.add(adminEca);

        boolean appJalan = true;
        while (appJalan) {
            System.out.println();
            System.out.println("================================");
            System.out.println("   TOKO JAMU    ");
            System.out.println("================================");
            System.out.println("1. Login Pelanggan");
            System.out.println("2. Login Admin");
            System.out.println("0. Keluar");
            System.out.println("================================");
            System.out.print("Pilih: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            if (pilihan == 1) {
                loginPelanggan();
            } else if (pilihan == 2) {
                loginAdmin();
            } else if (pilihan == 0) {
                System.out.println("Terima kasih, Sampai jumpa.");
                appJalan = false;
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        }
    }

    void loginPelanggan() {
        System.out.println("\n--- LOGIN PELANGGAN ---");
        int coba = 0;
        while (coba < 3) {
            System.out.print("Username : ");
            String username = scanner.nextLine();
            System.out.print("Password : ");
            String password = scanner.nextLine();
            boolean ketemu = false;
            for (Pelanggan p : daftarPelanggan) {
                if (p.getUsername().equals(username) && p.cekPassword(password)) {
                    p.sapa();
                    menuPelanggan(p);
                    ketemu = true;
                    break;
                }
            }

            if (ketemu) return;

            coba++;
            System.out.println("Username / password salah. Sisa percobaan: " + (3 - coba));
        }
        System.out.println("Percobaan habis. Kembali ke menu utama.");
    }

    void loginAdmin() {
        System.out.println("\n--- LOGIN ADMIN ---");
        int coba = 0;
        while (coba < 3) {
            System.out.print("Username : ");
            String username = scanner.nextLine();
            System.out.print("Password : ");
            String password = scanner.nextLine();
            boolean ketemu = false;
            for (Admin a : daftarAdmin) {
                if (a.getUsername().equals(username) && a.cekPassword(password)) {
                    a.sapa();
                    menuAdmin(a);
                    ketemu = true;
                    break;
                }
            }

            if (ketemu) return;

            coba++;
            System.out.println("Username / password salah. Sisa percobaan: " + (3 - coba));
        }
        System.out.println("Percobaan habis. Kembali ke menu utama.");
    }

    void menuPelanggan(Pelanggan pelanggan) {
        boolean jalan = true;
        while (jalan) {
            System.out.println();
            System.out.println("================================");
            System.out.println("  MENU  ");
            System.out.println("================================");
            System.out.println("1. Lihat Produk Jamu");
            System.out.println("2. Pesan Jamu");
            System.out.println("3. Pembayaran");
            System.out.println("0. Keluar");
            System.out.println("================================");
            System.out.print("Pilih: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            if (pilihan == 1) {
                lihatProdukJamu();
            } else if (pilihan == 2) {
                pesanJamu(pelanggan);
            } else if (pilihan == 3) {
                pembayaran(pelanggan);
            } else if (pilihan == 0) {
                System.out.println("Sampai jumpa, " + pelanggan.getNamaPelanggan());
                jalan = false;
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        }
    }

    void menuAdmin(Admin admin) {
        boolean jalan = true;
        while (jalan) {
            System.out.println();
            System.out.println("================================");
            System.out.println("  MENU ADMIN   ");
            System.out.println("================================");
            System.out.println("1. Lihat Produk Jamu");
            System.out.println("2. Tambah Produk Jamu");
            System.out.println("3. Update Produk Jamu");
            System.out.println("4. Hapus Produk Jamu");
            System.out.println("5. Lihat Pembayaran Pelanggan");
            System.out.println("0. Keluar");
            System.out.println("================================");
            System.out.print("Pilih: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            if (pilihan == 1) {
                lihatProdukJamu();
            } else if (pilihan == 2) {
                tambahProdukJamu();
            } else if (pilihan == 3) {
                updateProdukJamu();
            } else if (pilihan == 4) {
                hapusProdukJamu();
            } else if (pilihan == 5) {
                lihatPembayaran();
            } else if (pilihan == 0) {
                System.out.println("Sampai jumpa, " + admin.getNamaAdmin() + " (" + admin.getIdAdmin() + ")");
                jalan = false;
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        }
    }

    void lihatProdukJamu() {
        System.out.println("\n--- DAFTAR PRODUK JAMU ---");
        if (daftarJamu.isEmpty()) {
            System.out.println("Belum ada produk jamu.");
            return;
        }
        int nomor = 1;
        for (Jamu j : daftarJamu) {
            System.out.println("\nNo. " + nomor);
            j.tampilInfo();
            nomor++;
        }
        System.out.println("\nTotal: " + daftarJamu.size() + " produk.");
    }

    void pesanJamu(Pelanggan pelanggan) {
        System.out.println("\n--- PESAN JAMU ---");
        if (daftarJamu.isEmpty()) {
            System.out.println("Belum ada produk jamu.");
            return;
        }

        lihatProdukJamu();
        System.out.print("\nMasukkan ID Jamu: ");
        String idCari = scanner.nextLine();
        int indexJamu = -1;
        for (int i = 0; i < daftarJamu.size(); i++) {
            if (daftarJamu.get(i).getIdJamu().equals(idCari)) {
                indexJamu = i;
                break;
            }
        }

        if (indexJamu == -1) {
            System.out.println("[!] ID Jamu tidak ditemukan.");
            return;
        }

        Jamu jamu = daftarJamu.get(indexJamu);
        if (jamu.getStok() == 0) {
            System.out.println("[!] Stok habis.");
            return;
        }

        System.out.print("Jumlah pesan (botol): ");
        int jumlah = scanner.nextInt();
        scanner.nextLine();
        if (jumlah <= 0) {
            System.out.println("[!] Jumlah harus lebih dari 0.");
            return;
        }
        if (jumlah > jamu.getStok()) {
            System.out.println("[!] Stok tidak cukup. Stok tersedia: " + jamu.getStok());
            return;
        }

        double total     = jumlah * jamu.getHarga();
        String idPesanan = "ORD" + counterPesanan;
        idPesananList.add(idPesanan);
        idPelangganPesan.add(pelanggan.getIdPelanggan());
        namaJamuPesan.add(jamu.getNamaJamu());
        jumlahPesan.add(jumlah);
        totalHargaPesan.add(total);

        jamu.kurangiStok(jumlah);
        counterPesanan++;

        System.out.println("\n[OK] Pesanan berhasil dibuat!");
        System.out.println("ID Pesanan  : " + idPesanan);
        System.out.println("Jamu        : " + jamu.getNamaJamu());
        System.out.println("Jumlah      : " + jumlah + " botol");
        System.out.println("Total Harga : Rp " + total);
        System.out.println("Lanjut ke menu Pembayaran untuk menyelesaikan.");
    }

    void pembayaran(Pelanggan pelanggan) {
        System.out.println("\n--- PEMBAYARAN ---");
        boolean adaPesanan = false;
        for (int i = 0; i < idPesananList.size(); i++) {
            if (idPelangganPesan.get(i).equals(pelanggan.getIdPelanggan())) {
                boolean sudahBayar = false;
                for (String bayar : idPesananBayar) {
                    if (bayar.equals(idPesananList.get(i))) {
                        sudahBayar = true;
                        break;
                    }
                }

                if (!sudahBayar) {
                    System.out.println("\nID Pesanan  : " + idPesananList.get(i));
                    System.out.println("Jamu        : " + namaJamuPesan.get(i));
                    System.out.println("Jumlah      : " + jumlahPesan.get(i) + " botol");
                    System.out.println("Total Harga : Rp " + totalHargaPesan.get(i));
                    adaPesanan = true;
                }
            }
        }

        if (!adaPesanan) {
            System.out.println("[!] Tidak ada pesanan yang perlu dibayar.");
            return;
        }

        System.out.print("\nMasukkan ID Pesanan yang ingin dibayar: ");
        String idPilih = scanner.nextLine();
        int indexPilih = -1;
        for (int i = 0; i < idPesananList.size(); i++) {
            if (idPesananList.get(i).equals(idPilih)
                    && idPelangganPesan.get(i).equals(pelanggan.getIdPelanggan())) {

                boolean sudahBayar = false;
                for (String bayar : idPesananBayar) {
                    if (bayar.equals(idPilih)) {
                        sudahBayar = true;
                        break;
                    }
                }
                if (!sudahBayar) {
                    indexPilih = i;
                    break;
                }
            }
        }

        if (indexPilih == -1) {
            System.out.println("[!] ID Pesanan tidak ditemukan atau sudah dibayar.");
            return;
        }

        System.out.println("\nPilih metode pembayaran:");
        System.out.println("1. Transfer Bank");
        System.out.println("2. Dompet Digital");
        System.out.println("3. Bayar di Tempat (COD)");
        System.out.print("Pilihan: ");
        int pilihanMetode = scanner.nextInt();
        scanner.nextLine();

        String metode;
        if (pilihanMetode == 1) {
            metode = "Transfer Bank";
        } else if (pilihanMetode == 2) {
            metode = "Dompet Digital";
        } else if (pilihanMetode == 3) {
            metode = "Bayar di Tempat (COD)";
        } else {
            metode = "Tidak diketahui";
        }

        String idPembayaran = "PAY" + counterBayar;
        idPembayaranList.add(idPembayaran);
        idPesananBayar.add(idPesananList.get(indexPilih));
        namaJamuBayar.add(namaJamuPesan.get(indexPilih));
        jumlahBayar.add(jumlahPesan.get(indexPilih));
        totalBayar.add(totalHargaPesan.get(indexPilih));
        metodeBayar.add(metode);
        counterBayar++;

        System.out.println("\n====== STRUK PEMBAYARAN ======");
        System.out.println("ID Pembayaran : " + idPembayaran);
        System.out.println("ID Pesanan    : " + idPesananList.get(indexPilih));
        System.out.println("Jamu          : " + namaJamuPesan.get(indexPilih));
        System.out.println("Jumlah        : " + jumlahPesan.get(indexPilih) + " botol");
        System.out.println("Total         : Rp " + totalHargaPesan.get(indexPilih));
        System.out.println("Metode        : " + metode);
        System.out.println("==============================");
        System.out.println("Pembayaran berhasil! Terima kasih.");
    }

    void tambahProdukJamu() {
        System.out.println("\n--- TAMBAH PRODUK JAMU ---");
        String id = "J" + counterJamu;
        System.out.println("ID Jamu (otomatis): " + id);
        System.out.print("Nama Jamu : ");
        String nama = scanner.nextLine();
        System.out.print("Khasiat   : ");
        String khasiat = scanner.nextLine();
        System.out.print("Harga     : ");
        double harga = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Stok      : ");
        int stok = scanner.nextInt();
        scanner.nextLine();

        Jamu jamuBaru = new Jamu();
        jamuBaru.setIdJamu(id);
        jamuBaru.setNamaJamu(nama);
        jamuBaru.setKhasiat(khasiat);
        jamuBaru.setHarga(harga);
        jamuBaru.setStok(stok);
        daftarJamu.add(jamuBaru);
        counterJamu++;
        System.out.println("[OK] Produk " + jamuBaru.getNamaJamu() + " (Khasiat: " + jamuBaru.getKhasiat() + ") berhasil ditambahkan!");
    }

    void updateProdukJamu() {
        System.out.println("\n--- UPDATE PRODUK JAMU ---");
        lihatProdukJamu();
        if (daftarJamu.isEmpty()) return;
        System.out.print("\nMasukkan ID Jamu yang ingin diupdate: ");
        String idCari = scanner.nextLine();
        int index = -1;
        for (int i = 0; i < daftarJamu.size(); i++) {
            if (daftarJamu.get(i).getIdJamu().equals(idCari)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("[!] ID Jamu tidak ditemukan.");
            return;
        }

        Jamu j = daftarJamu.get(index);
        System.out.println("\nData lama:");
        j.tampilInfo();
        System.out.print("\nNama baru    (enter = tetap): ");
        String nama = scanner.nextLine();
        System.out.print("Khasiat baru (enter = tetap): ");
        String khasiat = scanner.nextLine();
        System.out.print("Harga baru   (0 = tetap)    : ");
        double harga = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Stok baru    (0 = tetap)    : ");
        int stok = scanner.nextInt();
        scanner.nextLine();

        if (!nama.isEmpty())    j.setNamaJamu(nama);
        if (!khasiat.isEmpty()) j.setKhasiat(khasiat);
        if (harga != 0)         j.setHarga(harga);
        if (stok != 0)          j.setStok(stok);
        System.out.println("[OK] Produk jamu berhasil diupdate!");
    }

    void hapusProdukJamu() {
        System.out.println("\n--- HAPUS PRODUK JAMU ---");
        lihatProdukJamu();
        if (daftarJamu.isEmpty()) return;
        System.out.print("\nMasukkan ID Jamu yang ingin dihapus: ");
        String idCari = scanner.nextLine();

        for (int i = 0; i < daftarJamu.size(); i++) {
            if (daftarJamu.get(i).getIdJamu().equals(idCari)) {
                String nama = daftarJamu.get(i).getNamaJamu();
                daftarJamu.remove(i);
                System.out.println("[OK] Produk " + nama + " berhasil dihapus!");
                return;
            }
        }
        System.out.println("[!] ID Jamu tidak ditemukan.");
    }

    void lihatPembayaran() {
        System.out.println("\n--- DATA PEMBAYARAN ---");
        if (idPembayaranList.isEmpty()) {
            System.out.println("[!] Belum ada data pembayaran.");
            return;
        }
        int nomor = 1;
        for (int i = 0; i < idPembayaranList.size(); i++) {
            System.out.println("\nNo. " + nomor);
            System.out.println("ID Pembayaran : " + idPembayaranList.get(i));
            System.out.println("ID Pesanan    : " + idPesananBayar.get(i));
            System.out.println("Jamu          : " + namaJamuBayar.get(i));
            System.out.println("Jumlah        : " + jumlahBayar.get(i) + " botol");
            System.out.println("Total         : Rp " + totalBayar.get(i));
            System.out.println("Metode        : " + metodeBayar.get(i));
            nomor++;
        }
        System.out.println("\nTotal: " + idPembayaranList.size() + " pembayaran.");
    }
}