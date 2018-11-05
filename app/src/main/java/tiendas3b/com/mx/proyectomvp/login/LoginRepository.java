package tiendas3b.com.mx.proyectomvp.login;

public interface LoginRepository {

    void saveUser(User user);

    User getUser();
}
