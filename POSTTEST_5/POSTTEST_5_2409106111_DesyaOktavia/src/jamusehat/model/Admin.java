package jamusehat.model;

public class Admin extends User implements LayananToko {
    public Admin(String idAdmin, String namaAdmin, String username, String password) {
        super(idAdmin, namaAdmin, username, password);
    }

    @Override
    public void sapa() {
        System.out.println("\n=== LOGIN ADMIN BERHASIL ===");
        System.out.println("Selamat bertugas, rekan " + this.nama + "!");
        tampilkanStatusSistem();
    }

    @Override
    public void tampilkanStatusSistem() {
        System.out.println("Status: Server Aktif (Database Terhubung)");
    }

    @Override
    public void tampilkanKontakBantuan() {
        System.out.println("Bantuan Teknis: IT Support UNMUL");
    }
}