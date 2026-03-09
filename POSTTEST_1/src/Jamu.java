public class Jamu {
    String idJamu;
    String namaJamu;
    String khasiat;
    double harga;
    int stok;

    Jamu() {
        this.idJamu   = "J0";
        this.namaJamu = "Tidak Diketahui";
        this.khasiat  = "-";
        this.harga    = 0;
        this.stok     = 0;
    }

    Jamu(String idJamu, String namaJamu, String khasiat, double harga, int stok) {
        this.idJamu   = idJamu;
        this.namaJamu = namaJamu;
        this.khasiat  = khasiat;
        this.harga    = harga;
        this.stok     = stok;
    }

    void tampilInfo() {
        IO.println("ID Jamu  : " + this.idJamu);
        IO.println("Nama     : " + this.namaJamu);
        IO.println("Khasiat  : " + this.khasiat);
        IO.println("Harga    : Rp " + this.harga);
        IO.println("Stok     : " + this.stok + " botol");
    }

    void kurangiStok(int jumlah) {
        this.stok = this.stok - jumlah;
    }
}