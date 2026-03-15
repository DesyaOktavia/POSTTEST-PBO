package jamusehat.model;

public class Pelanggan {
    private String idPelanggan;
    private String namaPelanggan;
    private String username;
    private String password;

    public Pelanggan() {
        this.idPelanggan   = "P000";
        this.namaPelanggan = "Tidak Diketahui";
        this.username      = "user";
        this.password      = "user123";
    }

    public Pelanggan(String idPelanggan, String username, String password) {
        this();
        this.idPelanggan = idPelanggan;
        this.username    = username;
        this.password    = password;
    }

    public Pelanggan(String idPelanggan, String namaPelanggan, String username, String password) {
        this.idPelanggan   = idPelanggan;
        this.namaPelanggan = namaPelanggan;
        this.username      = username;
        this.password      = password;
    }

    public String getIdPelanggan()   { return idPelanggan; }
    public String getNamaPelanggan() { return namaPelanggan; }
    public String getUsername()      { return username; }
    public void setIdPelanggan(String idPelanggan) {
        if (idPelanggan == null || idPelanggan.isEmpty()) {
            System.out.println("ID Pelanggan tidak boleh kosong.");
        } else {
            this.idPelanggan = idPelanggan;
        }
    }

    public void setNamaPelanggan(String namaPelanggan) {
        if (namaPelanggan == null || namaPelanggan.isEmpty()) {
            System.out.println("Nama tidak boleh kosong.");
        } else {
            this.namaPelanggan = namaPelanggan;
        }
    }

    public void setUsername(String username) {
        if (username == null || username.isEmpty()) {
            System.out.println("Username tidak boleh kosong.");
        } else {
            this.username = username;
        }
    }

    public void setPassword(String password) {
        if (password == null || password.isEmpty()) {
            System.out.println("Password tidak boleh kosong.");
        } else {
            this.password = password;
        }
    }

    public boolean cekPassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    public void sapa() {
        System.out.println("Halo, " + this.namaPelanggan + "! Selamat datang di Toko Jamu.");
    }
}