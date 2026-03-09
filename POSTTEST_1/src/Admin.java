public class Admin {
    String idAdmin;
    String namaAdmin;
    String username;
    String password;

    Admin() {
        this.idAdmin   = "A000";
        this.namaAdmin = "Tidak Diketahui";
        this.username  = "admin";
        this.password  = "admin123";
    }

    Admin(String idAdmin, String namaAdmin, String username) {
        this();
        this.idAdmin   = idAdmin;
        this.namaAdmin = namaAdmin;
        this.username  = username;
    }

    Admin(String idAdmin, String namaAdmin, String username, String password) {
        this(idAdmin, namaAdmin, username);
        this.password = password;
    }

    boolean cekPassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    void sapa() {
        IO.println("Halo, " + this.namaAdmin + "! Selamat datang.");
    }
}