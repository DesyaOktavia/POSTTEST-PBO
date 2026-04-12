package jamusehat.model;

public class Jamu {
    protected String idJamu;
    protected String namaJamu;
    protected String khasiat;
    protected double harga;
    protected int stok;

    public Jamu(String idJamu, String namaJamu, String khasiat, double harga, int stok) {
        this.idJamu = idJamu;
        this.namaJamu = namaJamu;
        this.khasiat = khasiat;
        this.harga = harga;
        this.stok = stok;
    }

    public String getIdJamu() { return idJamu; }
    public String getNamaJamu() { return namaJamu; }
    public double getHarga() { return harga; }
    public int getStok() { return stok; }

    public void setNamaJamu(String namaJamu) { this.namaJamu = namaJamu; }
    public void setHarga(double harga) { this.harga = harga; }
    public void setStok(int stok) { this.stok = stok; }

    public void infoTambahan() {
        System.out.println("Jenis: Jamu Umum");
    }

    public void tampilInfo() {
        System.out.println("ID Jamu  : " + idJamu);
        System.out.println("Nama     : " + namaJamu);
        System.out.println("Khasiat  : " + khasiat);
        System.out.println("Harga    : Rp " + harga);
        System.out.println("Stok     : " + stok);
        infoTambahan();
    }

    public void kurangiStok(int jumlah) {
        if (jumlah <= this.stok) this.stok -= jumlah;
    }
}