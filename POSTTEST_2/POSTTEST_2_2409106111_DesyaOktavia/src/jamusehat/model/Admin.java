package jamusehat.model;

public class Admin {
    private String idAdmin;
    private String namaAdmin;
    private String username;
    private String password;

    public Admin() {
        this.idAdmin   = "A000";
        this.namaAdmin = "Tidak Diketahui";
        this.username  = "admin";
        this.password  = "admin123";
    }

    public Admin(String idAdmin, String namaAdmin, String username) {
        this();
        this.idAdmin   = idAdmin;
        this.namaAdmin = namaAdmin;
        this.username  = username;
    }

    public Admin(String idAdmin, String namaAdmin, String username, String password) {
        this(idAdmin, namaAdmin, username);
        this.password = password;
    }

    public String getIdAdmin()   { return idAdmin; }
    public String getNamaAdmin() { return namaAdmin; }
    public String getUsername()  { return username; }
    public void setIdAdmin(String idAdmin) {
        if (idAdmin == null || idAdmin.isEmpty()) {
            System.out.println("ID Admin tidak boleh kosong.");
        } else {
            this.idAdmin = idAdmin;
        }
    }

    public void setNamaAdmin(String namaAdmin) {
        if (namaAdmin == null || namaAdmin.isEmpty()) {
            System.out.println("Nama tidak boleh kosong.");
        } else {
            this.namaAdmin = namaAdmin;
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
        System.out.println("Halo, " + this.namaAdmin + "! Selamat datang.");
    }
}