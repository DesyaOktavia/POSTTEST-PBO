public class Pelanggan {
    String idPelanggan;
    String namaPelanggan;
    String username;
    String password;

    Pelanggan() {
        this.idPelanggan   = "P000";
        this.namaPelanggan = "Tidak Diketahui";
        this.username      = "user";
        this.password      = "user123";
    }

    Pelanggan(String idPelanggan, String username, String password) {
        this();
        this.idPelanggan = idPelanggan;
        this.username    = username;
        this.password    = password;
    }

    Pelanggan(String idPelanggan, String namaPelanggan, String username, String password) {
        this.idPelanggan   = idPelanggan;
        this.namaPelanggan = namaPelanggan;
        this.username      = username;
        this.password      = password;
    }

    boolean cekPassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    void sapa() {
        IO.println("Halo, " + this.namaPelanggan + "! Selamat datang di Toko Jamu.");
    }
}