package tiendas3b.com.mx.proyectomvp.login;

public class LoginRepositoryMemory implements LoginRepository {

    private User user;

    @Override
    public void saveUser(User user) {
        if (user == null) {
            user = getUser();
        } else {
            this.user = user;
        }
    }

    @Override
    public User getUser() {
        if (user == null) {
            user = new User("John", "Doe");
            user.setId(0);
            return user;
        } else{
            return user;
        }
    }
}
