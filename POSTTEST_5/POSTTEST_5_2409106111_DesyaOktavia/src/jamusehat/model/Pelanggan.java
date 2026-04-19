package jamusehat.model;

public class Pelanggan extends User implements LayananToko {
    public Pelanggan(String idPelanggan, String namaPelanggan, String username, String password) {
        super(idPelanggan, namaPelanggan, username, password);
    }

    @Override
    public void sapa() {
        System.out.println("\n=== LOGIN PELANGGAN BERHASIL ===");
        System.out.println("Halo " + this.nama + ", mau pesan jamu apa hari ini?");
        tampilkanKontakBantuan();
    }

    @Override
    public void tampilkanStatusSistem() {
        System.out.println("Status Toko: Buka");
    }

    @Override
    public void tampilkanKontakBantuan() {
        System.out.println("Hubungi Admin: 0812-9575-7570");
    }
}