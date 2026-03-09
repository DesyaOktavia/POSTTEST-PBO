Sistem Manajemen Toko Jamu
Proyek ini adalah aplikasi berbasis konsol (CLI) yang dirancang untuk mengelola operasional toko jamu. Sistem ini mendukung dua level akses, yaitu Admin untuk manajemen inventaris dan Pelanggan untuk melakukan pemesanan hingga pembayaran.

--Fitur Utama--
1. Fitur Admin
- Manajemen Produk: Tambah, lihat, update, dan hapus (CRUD) data produk jamu.
- Monitoring Inventaris: Pemantauan stok secara real-time.
- Laporan Penjualan: Melihat seluruh riwayat pembayaran yang dilakukan oleh pelanggan.

2. Fitur Pelanggan
- Katalog Produk: Melihat daftar jamu beserta khasiat dan harganya.
- Pemesanan Online: Melakukan pemesanan jamu dengan validasi stok otomatis.
- Sistem Pembayaran: Menyelesaikan transaksi dengan berbagai metode (Transfer, Dompet Digital, COD) dan mendapatkan struk digital.

3. Struktur Class
Program ini dibangun menggunakan konsep Pemrograman Berorientasi Objek (OOP) dengan beberapa class utama:
- Class Jamu = Menyimpan data produk seperti ID, nama, khasiat, harga, dan stok.
- Class Pelanggan = Mengelola data profil pelanggan dan autentikasi.
- Class Admin = Mengelola hak akses khusus untuk operasional toko.
