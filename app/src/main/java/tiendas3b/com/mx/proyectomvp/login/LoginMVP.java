package tiendas3b.com.mx.proyectomvp.login;

public interface LoginMVP {


    interface View {
        String getFirstName();

        String getLastName();

        void showUserNotAvailable();

        void showInputError();

        void showUserSaved();

        void setFirstName(String firstName);

        void setLastName(String lastName);

    }


    interface Presenter {
        void setView(LoginMVP.View view);

        void loginButtonClicked();

        void getCurrentUser();
    }

    interface Model {
        void createUser(String firstName, String lastName);

        User getUser();
    }
}
