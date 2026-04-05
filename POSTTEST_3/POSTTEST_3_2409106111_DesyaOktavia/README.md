Jamu Sehat - Sistem Pemesanan Jamu Modern
Sistem aplikasi berbasis Java untuk mengelola pemesanan dan pembayaran jamu secara digital. 

Fitur Utama
1. Manajemen Produk: Admin dapat menambah, memperbarui, dan menghapus data jamu.
2. Pemesanan Real-time: Pelanggan dapat melihat stok dan memesan jamu secara langsung.
3. Sistem Pembayaran: Pencatatan transaksi.
4. Autentikasi Multi-User: Login terpisah antara Admin dan Pelanggan.

Konsep PBO yang Diterapkan:
1. Encapsulation: Penggunaan access modifier private dan protected serta method Getter/Setter untuk keamanan data.
2. Inheritance (Pewarisan): Menerapkan Hierarchical Inheritance dengan class User sebagai Superclass, serta class Admin dan Pelanggan sebagai Subclass.
3. Polymorphism: Penggunaan method Overriding pada method sapa() untuk memberikan respon yang berbeda pada tiap tipe user.
4. Data Structures: Menggunakan ArrayList untuk penyimpanan data objek yang dinamis.

Struktur Folder
src/
└── jamusehat/
    ├── app/
    │   └── Main.java 
    └── model/
        ├── User.java
        ├── Admin.java
        ├── Pelanggan.java
        └── Jamu.java
