import java.util.ArrayList;
import java.util.Scanner;

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
            Jamu jamu1 = new Jamu();
            jamu1.idJamu   = "J1";
            jamu1.namaJamu = "Jamu Kunyit Asam";
            jamu1.khasiat  = "Menjaga daya tahan tubuh";
            jamu1.harga    = 15000;
            jamu1.stok     = 50;
            daftarJamu.add(jamu1);
            daftarJamu.add(new Jamu("J2", "Jamu Beras Kencur", "Menghilangkan pegal linu", 12000, 40));
            daftarJamu.add(new Jamu("J3", "Jamu Temulawak",    "Menjaga kesehatan hati",   18000, 30));

            Pelanggan p1 = new Pelanggan("P001", "sari", "sari123");
            p1.namaPelanggan = "Sari Tuti";
            daftarPelanggan.add(p1);
            daftarPelanggan.add(new Pelanggan("P002", "Malvin Rey", "malvin", "malvin123"));

            Admin adminEca = new Admin("A001", "Eca", "eca", "eca123");
            daftarAdmin.add(adminEca);

            boolean appJalan = true;
            while (appJalan) {
                IO.println("");
                IO.println("================================");
                IO.println("   TOKO JAMU    ");
                IO.println("================================");
                IO.println("1. Login Pelanggan");
                IO.println("2. Login Admin");
                IO.println("0. Keluar");
                IO.println("================================");
                IO.print("Pilih: ");
                int pilihan = scanner.nextInt();
                scanner.nextLine();

                if (pilihan == 1) {
                    loginPelanggan();
                } else if (pilihan == 2) {
                    loginAdmin();
                } else if (pilihan == 0) {
                    IO.println("Terima kasih, Sampai jumpa.");
                    appJalan = false;
                } else {
                    IO.println("Pilihan tidak valid.");
                }
            }
        }

        void loginPelanggan() {
            IO.println("\n--- LOGIN PELANGGAN ---");
            int coba = 0;
            while (coba < 3) {
                IO.print("Username : ");
                String username = scanner.nextLine();
                IO.print("Password : ");
                String password = scanner.nextLine();

                boolean ketemu = false;
                for (Pelanggan p : daftarPelanggan) {
                    if (p.username.equals(username) && p.cekPassword(password)) {
                        p.sapa();
                        menuPelanggan(p);
                        ketemu = true;
                        break;
                    }
                }

                if (ketemu) return;

                coba++;
                IO.println("Username / password salah. Sisa percobaan: " + (3 - coba));
            }
            IO.println("Percobaan habis. Kembali ke menu utama.");
        }

        void loginAdmin() {
            IO.println("\n--- LOGIN ADMIN ---");
            int coba = 0;
            while (coba < 3) {
                IO.print("Username : ");
                String username = scanner.nextLine();
                IO.print("Password : ");
                String password = scanner.nextLine();

                boolean ketemu = false;
                for (Admin a : daftarAdmin) {
                    if (a.username.equals(username) && a.cekPassword(password)) {
                        a.sapa();
                        menuAdmin(a);
                        ketemu = true;
                        break;
                    }
                }

                if (ketemu) return;

                coba++;
                IO.println("Username / password salah. Sisa percobaan: " + (3 - coba));
            }
            IO.println("Percobaan habis. Kembali ke menu utama.");
        }

        void menuPelanggan(Pelanggan pelanggan) {
            boolean jalan = true;
            while (jalan) {
                IO.println("");
                IO.println("================================");
                IO.println("  MENU  ");
                IO.println("================================");
                IO.println("1. Lihat Produk Jamu");
                IO.println("2. Pesan Jamu");
                IO.println("3. Pembayaran");
                IO.println("0. Keluar");
                IO.println("================================");
                IO.print("Pilih: ");
                int pilihan = scanner.nextInt();
                scanner.nextLine();

                if (pilihan == 1) {
                    lihatProdukJamu();
                } else if (pilihan == 2) {
                    pesanJamu(pelanggan);
                } else if (pilihan == 3) {
                    pembayaran(pelanggan);
                } else if (pilihan == 0) {
                    IO.println("Sampai jumpa, " + pelanggan.namaPelanggan);
                    jalan = false;
                } else {
                    IO.println("Pilihan tidak valid.");
                }
            }
        }

        void menuAdmin(Admin admin) {
            boolean jalan = true;
            while (jalan) {
                IO.println("");
                IO.println("================================");
                IO.println("  MENU ADMIN   ");
                IO.println("================================");
                IO.println("1. Lihat Produk Jamu");
                IO.println("2. Tambah Produk Jamu");
                IO.println("3. Update Produk Jamu");
                IO.println("4. Hapus Produk Jamu");
                IO.println("5. Lihat Pembayaran Pelanggan");
                IO.println("0. Keluar");
                IO.println("================================");
                IO.print("Pilih: ");
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
                    IO.println("Sampai jumpa, " + admin.namaAdmin);
                    jalan = false;
                } else {
                    IO.println("Pilihan tidak valid.");
                }
            }
        }

        void lihatProdukJamu() {
            IO.println("\n--- DAFTAR PRODUK JAMU ---");
            if (daftarJamu.isEmpty()) {
                IO.println("Belum ada produk jamu.");
                return;
            }
            int nomor = 1;
            for (Jamu j : daftarJamu) {
                IO.println("\nNo. " + nomor);
                j.tampilInfo();
                nomor++;
            }
            IO.println("\nTotal: " + daftarJamu.size() + " produk.");
        }

        void pesanJamu(Pelanggan pelanggan) {
            IO.println("\n--- PESAN JAMU ---");

            if (daftarJamu.isEmpty()) {
                IO.println("Belum ada produk jamu.");
                return;
            }

            lihatProdukJamu();

            IO.print("\nMasukkan ID Jamu: ");
            String idCari = scanner.nextLine();

            int indexJamu = -1;
            for (int i = 0; i < daftarJamu.size(); i++) {
                if (daftarJamu.get(i).idJamu.equals(idCari)) {
                    indexJamu = i;
                    break;
                }
            }

            if (indexJamu == -1) {
                IO.println("[!] ID Jamu tidak ditemukan.");
                return;
            }

            Jamu jamu = daftarJamu.get(indexJamu);

            if (jamu.stok == 0) {
                IO.println("[!] Stok habis.");
                return;
            }

            IO.print("Jumlah pesan (botol): ");
            int jumlah = scanner.nextInt();
            scanner.nextLine();

            if (jumlah <= 0) {
                IO.println("[!] Jumlah harus lebih dari 0.");
                return;
            }
            if (jumlah > jamu.stok) {
                IO.println("[!] Stok tidak cukup. Stok tersedia: " + jamu.stok);
                return;
            }

            double total      = jumlah * jamu.harga;
            String idPesanan  = "ORD" + counterPesanan;

            idPesananList.add(idPesanan);
            idPelangganPesan.add(pelanggan.idPelanggan);
            namaJamuPesan.add(jamu.namaJamu);
            jumlahPesan.add(jumlah);
            totalHargaPesan.add(total);

            jamu.kurangiStok(jumlah);
            counterPesanan++;

            IO.println("\n[OK] Pesanan berhasil dibuat!");
            IO.println("ID Pesanan  : " + idPesanan);
            IO.println("Jamu        : " + jamu.namaJamu);
            IO.println("Jumlah      : " + jumlah + " botol");
            IO.println("Total Harga : Rp " + total);
            IO.println("Lanjut ke menu Pembayaran untuk menyelesaikan.");
        }

        void pembayaran(Pelanggan pelanggan) {
            IO.println("\n--- PEMBAYARAN ---");

            boolean adaPesanan = false;
            for (int i = 0; i < idPesananList.size(); i++) {
                if (idPelangganPesan.get(i).equals(pelanggan.idPelanggan)) {

                    // Cek sudah dibayar atau belum
                    boolean sudahBayar = false;
                    for (String bayar : idPesananBayar) {
                        if (bayar.equals(idPesananList.get(i))) {
                            sudahBayar = true;
                            break;
                        }
                    }

                    if (!sudahBayar) {
                        IO.println("\nID Pesanan  : " + idPesananList.get(i));
                        IO.println("Jamu        : " + namaJamuPesan.get(i));
                        IO.println("Jumlah      : " + jumlahPesan.get(i) + " botol");
                        IO.println("Total Harga : Rp " + totalHargaPesan.get(i));
                        adaPesanan = true;
                    }
                }
            }

            if (!adaPesanan) {
                IO.println("[!] Tidak ada pesanan yang perlu dibayar.");
                return;
            }

            IO.print("\nMasukkan ID Pesanan yang ingin dibayar: ");
            String idPilih = scanner.nextLine();

            // Cari pesanan yang dipilih (butuh index untuk akses beberapa ArrayList)
            int indexPilih = -1;
            for (int i = 0; i < idPesananList.size(); i++) {
                if (idPesananList.get(i).equals(idPilih)
                        && idPelangganPesan.get(i).equals(pelanggan.idPelanggan)) {

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
                IO.println("[!] ID Pesanan tidak ditemukan atau sudah dibayar.");
                return;
            }

            IO.println("\nPilih metode pembayaran:");
            IO.println("1. Transfer Bank");
            IO.println("2. Dompet Digital");
            IO.println("3. Bayar di Tempat (COD)");
            IO.print("Pilihan: ");
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

            IO.println("\n====== STRUK PEMBAYARAN ======");
            IO.println("ID Pembayaran : " + idPembayaran);
            IO.println("ID Pesanan    : " + idPesananList.get(indexPilih));
            IO.println("Jamu          : " + namaJamuPesan.get(indexPilih));
            IO.println("Jumlah        : " + jumlahPesan.get(indexPilih) + " botol");
            IO.println("Total         : Rp " + totalHargaPesan.get(indexPilih));
            IO.println("Metode        : " + metode);
            IO.println("==============================");
            IO.println("Pembayaran berhasil! Terima kasih.");
        }

        void tambahProdukJamu() {
            IO.println("\n--- TAMBAH PRODUK JAMU ---");

            String id = "J" + counterJamu;
            IO.println("ID Jamu (otomatis): " + id);

            IO.print("Nama Jamu : ");
            String nama = scanner.nextLine();
            IO.print("Khasiat   : ");
            String khasiat = scanner.nextLine();
            IO.print("Harga     : ");
            double harga = scanner.nextDouble();
            scanner.nextLine();
            IO.print("Stok      : ");
            int stok = scanner.nextInt();
            scanner.nextLine();

            daftarJamu.add(new Jamu(id, nama, khasiat, harga, stok));
            counterJamu++;
            IO.println("[OK] Produk " + nama + " berhasil ditambahkan!");
        }

        void updateProdukJamu() {
            IO.println("\n--- UPDATE PRODUK JAMU ---");
            lihatProdukJamu();
            if (daftarJamu.isEmpty()) return;

            IO.print("\nMasukkan ID Jamu yang ingin diupdate: ");
            String idCari = scanner.nextLine();

            // Butuh index untuk daftarJamu.set(index, ...)
            int index = -1;
            for (int i = 0; i < daftarJamu.size(); i++) {
                if (daftarJamu.get(i).idJamu.equals(idCari)) {
                    index = i;
                    break;
                }
            }

            if (index == -1) {
                IO.println("[!] ID Jamu tidak ditemukan.");
                return;
            }

            Jamu j = daftarJamu.get(index);
            IO.println("\nData lama:");
            j.tampilInfo();

            IO.print("\nNama baru   (enter = tetap): ");
            String nama = scanner.nextLine();
            IO.print("Khasiat baru (enter = tetap): ");
            String khasiat = scanner.nextLine();
            IO.print("Harga baru  (0 = tetap)    : ");
            double harga = scanner.nextDouble();
            scanner.nextLine();
            IO.print("Stok baru   (0 = tetap)    : ");
            int stok = scanner.nextInt();
            scanner.nextLine();

            if (nama.isEmpty())    nama    = j.namaJamu;
            if (khasiat.isEmpty()) khasiat = j.khasiat;
            if (harga == 0)        harga   = j.harga;
            if (stok == 0)         stok    = j.stok;

            daftarJamu.set(index, new Jamu(j.idJamu, nama, khasiat, harga, stok));
            IO.println("[OK] Produk jamu berhasil diupdate!");
        }

        void hapusProdukJamu() {
            IO.println("\n--- HAPUS PRODUK JAMU ---");
            lihatProdukJamu();
            if (daftarJamu.isEmpty()) return;

            IO.print("\nMasukkan ID Jamu yang ingin dihapus: ");
            String idCari = scanner.nextLine();

            // Butuh index untuk daftarJamu.remove(index)
            for (int i = 0; i < daftarJamu.size(); i++) {
                if (daftarJamu.get(i).idJamu.equals(idCari)) {
                    String nama = daftarJamu.get(i).namaJamu;
                    daftarJamu.remove(i);
                    IO.println("[OK] Produk " + nama + " berhasil dihapus!");
                    return;
                }
            }
            IO.println("[!] ID Jamu tidak ditemukan.");
        }

        void lihatPembayaran() {
            IO.println("\n--- DATA PEMBAYARAN ---");
            if (idPembayaranList.isEmpty()) {
                IO.println("[!] Belum ada data pembayaran.");
                return;
            }
            int nomor = 1;
            for (int i = 0; i < idPembayaranList.size(); i++) {
                IO.println("\nNo. " + nomor);
                IO.println("ID Pembayaran : " + idPembayaranList.get(i));
                IO.println("ID Pesanan    : " + idPesananBayar.get(i));
                IO.println("Jamu          : " + namaJamuBayar.get(i));
                IO.println("Jumlah        : " + jumlahBayar.get(i) + " botol");
                IO.println("Total         : Rp " + totalBayar.get(i));
                IO.println("Metode        : " + metodeBayar.get(i));
                nomor++;
            }
            IO.println("\nTotal: " + idPembayaranList.size() + " pembayaran.");
        }