package jamusehat.model;

public class Jamu {
    private String idJamu;
    private String namaJamu;
    private String khasiat;
    private double harga;
    private int stok;

    public Jamu(String idJamu, String namaJamu, String khasiat, double harga, int stok) {
        this.idJamu = idJamu;
        this.namaJamu = namaJamu;
        this.khasiat = khasiat;
        this.harga = harga;
        this.stok = stok;
    }

    public void tambahStok(int jumlah) {
        this.stok += jumlah;
        System.out.println("Stok " + namaJamu + " berhasil ditambah!");
    }

    public void tambahStok(int jumlah, String keterangan) {
        this.stok += jumlah;
        System.out.println("Update Stok: " + jumlah + " unit. Keterangan: " + keterangan);
    }

    public String getIdJamu() { return idJamu; }
    public String getNamaJamu() { return namaJamu; }
    public String getKhasiat() { return khasiat; }
    public double getHarga() { return harga; }
    public int getStok() { return stok; }

    public void setNamaJamu(String namaJamu) { this.namaJamu = namaJamu; }
    public void setHarga(double harga) { if (harga >= 0) this.harga = harga; }
    public void setStok(int stok) { if (stok >= 0) this.stok = stok; }

    public void tampilInfo() {
        System.out.println("ID Jamu  : " + getIdJamu());
        System.out.println("Nama     : " + getNamaJamu());
        System.out.println("Khasiat  : " + getKhasiat());
        System.out.println("Harga    : Rp " + getHarga());
        System.out.println("Stok     : " + getStok() + " botol");
        System.out.println();
    }

    public void kurangiStok(int jumlah) {
        if (jumlah <= this.stok) this.stok -= jumlah;
    }
}