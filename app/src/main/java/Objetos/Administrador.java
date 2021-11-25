package Objetos;

import java.util.Objects;

public class Administrador {

    private int id;
    private String user;
    private String pass;

    public Administrador()
    {
        user = "e";
        pass = "1";
    }

    public Administrador(int id, String user, String pass) {
        this.id = id;
        this.user = user;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Administrador that = (Administrador) o;
        return id == that.id && Objects.equals(user, that.user) && Objects.equals(pass, that.pass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, pass);
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
