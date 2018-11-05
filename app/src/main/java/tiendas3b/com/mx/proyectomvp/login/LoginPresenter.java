package tiendas3b.com.mx.proyectomvp.login;

import android.support.annotation.Nullable;

import javax.inject.Inject;

public class LoginPresenter implements LoginMVP.Presenter {

    @Nullable
    private LoginMVP.View view;
    private LoginMVP.Model model;

    public LoginPresenter(LoginMVP.Model model) {
        this.model = model;
    }

    @Override
    public void setView(LoginMVP.View view) {
        this.view = view;
    }

    @Override
    public void loginButtonClicked() {
        if (view != null) {
            if (view.getFirstName().trim().equals("") || view.getLastName().trim().equals("")) {
                view.showInputError();
            } else {
                model.createUser(view.getFirstName().trim(), view.getLastName().trim());
                view.showUserSaved();
            }
        }
    }

    @Override
    public void getCurrentUser() {
        User user = model.getUser();
        if (user == null) {
            if (view != null) {
                view.showUserNotAvailable();
            }
        } else {
            if (view != null) {
                view.setFirstName(user.getFirstName());
                view.setLastName(user.getLastName());
            }
        }
    }
}
