package jamusehat.model;

public class JamuBubuk extends Jamu {
    public JamuBubuk(String id, String nama, String khasiat, double harga, int stok) {
        super(id, nama, khasiat, harga, stok);
    }

    @Override
    public void infoTambahan() {
        System.out.println("Jenis: Jamu Bubuk (Perlu diseduh)");
    }
}