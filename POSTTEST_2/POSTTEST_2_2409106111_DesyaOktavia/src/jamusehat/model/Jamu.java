package jamusehat.model;

public class Jamu {
    private String idJamu;
    private String namaJamu;
    private String khasiat;
    private double harga;
    private int stok;

    public Jamu() {
        this.idJamu   = "J0";
        this.namaJamu = "Tidak Diketahui";
        this.khasiat  = "-";
        this.harga    = 0;
        this.stok     = 0;
    }

    public Jamu(String idJamu, String namaJamu, String khasiat, double harga, int stok) {
        this.idJamu   = idJamu;
        this.namaJamu = namaJamu;
        this.khasiat  = khasiat;
        this.harga    = harga;
        this.stok     = stok;
    }

    public String getIdJamu()   { return idJamu; }
    public String getNamaJamu() { return namaJamu; }
    public String getKhasiat()  { return khasiat; }
    public double getHarga()    { return harga; }
    public int    getStok()     { return stok; }

    public void setIdJamu(String idJamu) {
        if (idJamu == null || idJamu.isEmpty()) {
            System.out.println("ID Jamu tidak boleh kosong.");
        } else {
            this.idJamu = idJamu;
        }
    }

    public void setNamaJamu(String namaJamu) {
        if (namaJamu == null || namaJamu.isEmpty()) {
            System.out.println("Nama jamu tidak boleh kosong.");
        } else {
            this.namaJamu = namaJamu;
        }
    }

    public void setKhasiat(String khasiat) {
        if (khasiat == null || khasiat.isEmpty()) {
            System.out.println("Khasiat tidak boleh kosong.");
        } else {
            this.khasiat = khasiat;
        }
    }

    public void setHarga(double harga) {
        if (harga < 0) {
            System.out.println("Harga tidak boleh negatif.");
        } else {
            this.harga = harga;
        }
    }

    public void setStok(int stok) {
        if (stok < 0) {
            System.out.println("Stok tidak boleh negatif.");
        } else {
            this.stok = stok;
        }
    }

    public void tampilInfo() {
        System.out.println("ID Jamu  : " + this.idJamu);
        System.out.println("Nama     : " + this.namaJamu);
        System.out.println("Khasiat  : " + this.khasiat);
        System.out.println("Harga    : Rp " + this.harga);
        System.out.println("Stok     : " + this.stok + " botol");
    }

    public void kurangiStok(int jumlah) {
        if (jumlah > this.stok) {
            System.out.println("Stok tidak cukup.");
        } else {
            this.stok = this.stok - jumlah;
        }
    }
}