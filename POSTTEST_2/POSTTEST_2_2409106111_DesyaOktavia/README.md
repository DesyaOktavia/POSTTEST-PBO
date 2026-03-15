Laporan Posttest 2 Pemrograman Berorientasi Objek

Deskripsi Program
Program ini merupakan pengembangan dari Posttest 1. Pada Posttest 2 diterapkan
konsep Encapsulation dengan menggunakan Access Modifier dan Getter/Setter
pada seluruh class model. Program juga menerapkan package untuk memisahkan
class model dan class utama.

Konsep Encapsulation
Semua properti di class Jamu, Pelanggan, dan Admin dibuat private sehingga 
tidak bisa diakses langsung dari luar class. Akses dilakukan melalui method 
getter (untuk membaca) dan setter (untuk mengubah nilai dengan validasi).

Access Modifier (4 Jenis)
| Modifier    | Diterapkan Pada |
|-------------|-----------------|
| `private`   | Semua properti di Jamu, Pelanggan, Admin |
| `public`    | Semua getter, setter, constructor, method |
| `protected` | Method `jalankan()` di Main |
| `default`   | ArrayList dan variabel di Main |
