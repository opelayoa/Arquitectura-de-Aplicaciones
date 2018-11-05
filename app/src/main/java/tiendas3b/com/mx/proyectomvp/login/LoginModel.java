package tiendas3b.com.mx.proyectomvp.login;

public class LoginModel implements LoginMVP.Model {

    private LoginRepository repository;

    public LoginModel(LoginRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createUser(String firstName, String lastName) {
        // Business Logic
        // Transformations
        repository.saveUser(new User(firstName, lastName));
    }

    @Override
    public User getUser() {
        // Business Logic
        // Transformations
        return repository.getUser();
    }
}
