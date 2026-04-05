package jamusehat.model;

public class Admin extends User {
    public Admin(String idAdmin, String namaAdmin, String username, String password) {
        super(idAdmin, namaAdmin, username, password);
    }

    @Override
    public void sapa() {
        System.out.println("\n[LOGGED IN AS ADMIN]");
        super.sapa();
    }
}