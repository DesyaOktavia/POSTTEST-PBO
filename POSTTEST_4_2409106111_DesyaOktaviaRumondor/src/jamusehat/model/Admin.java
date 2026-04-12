package jamusehat.model;

public class Admin extends User {
    public Admin(String idAdmin, String namaAdmin, String username, String password) {
        super(idAdmin, namaAdmin, username, password);
    }

    @Override
    public void sapa() {
        System.out.println("\n=== LOGIN ADMIN BERHASIL ===");
        System.out.println("Selamat bertugas, rekan " + this.nama + "!");
    }
}