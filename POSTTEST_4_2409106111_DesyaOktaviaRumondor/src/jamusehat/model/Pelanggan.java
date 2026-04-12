package jamusehat.model;

public class Pelanggan extends User {
    public Pelanggan(String idPelanggan, String namaPelanggan, String username, String password) {
        super(idPelanggan, namaPelanggan, username, password);
    }

    @Override
    public void sapa() {
        System.out.println("\n=== LOGIN PELANGGAN BERHASIL ===");
        System.out.println("Halo Kak " + this.nama + ", mau sehat pakai jamu apa hari ini?");
    }
}