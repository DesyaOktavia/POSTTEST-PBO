package jamusehat.model;

public abstract class User {
    protected String id;
    protected String nama;
    protected String username;
    protected String password;

    public User(String id, String nama, String username, String password) {
        this.id = id;
        this.nama = nama;
        this.username = username;
        this.password = password;
    }

    public String getId() { return id; }
    public String getNama() { return nama; }
    public String getUsername() { return username; }

    public boolean cekPassword(String input) {
        return this.password.equals(input);
    }

    public abstract void sapa();
}