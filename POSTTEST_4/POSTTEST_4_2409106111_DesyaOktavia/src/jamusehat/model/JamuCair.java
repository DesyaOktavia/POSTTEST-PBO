package jamusehat.model;

public class JamuCair extends Jamu {
    public JamuCair(String id, String nama, String khasiat, double harga, int stok) {
        super(id, nama, khasiat, harga, stok);
    }

    @Override
    public void infoTambahan() {
        System.out.println("Jenis: Jamu Cair (Siap diminum)");
    }
}