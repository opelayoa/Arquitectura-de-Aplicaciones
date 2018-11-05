package tiendas3b.com.mx.proyectomvp;

import org.junit.Before;
import org.junit.Test;

import tiendas3b.com.mx.proyectomvp.login.LoginMVP;
import tiendas3b.com.mx.proyectomvp.login.LoginPresenter;
import tiendas3b.com.mx.proyectomvp.login.User;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PresenterUnitTest {

    LoginPresenter presenter;
    User user;

    LoginMVP.Model mockedModel;
    LoginMVP.View mockedView;

    @Before
    public void init() {
        mockedModel = mock(LoginMVP.Model.class);
        mockedView = mock(LoginMVP.View.class);

        user = new User("Manolo", "Escobar");

        // when(mockedModel.getUser()).thenReturn(user);

        // when(mockedView.getFirstName()).thenReturn("Antonio");
        // when(mockedView.getLastName()).thenReturn("Banderas");

        presenter = new LoginPresenter(mockedModel);
        presenter.setView(mockedView);
    }


    @Test
    public void noExistInteractionWithView() {
        presenter.getCurrentUser();
        // verifyZeroInteractions(mockedView);
        // verify(mockedView, times(1)).showUserNotAvailable();
        // verify(mockedView, never()).showUserNotAvailable();
        verify(mockedView, times(1)).showUserNotAvailable();
    }

    @Test
    public void loadUserFromTheRepoWhenValidUserIsPresent () {
        when(mockedModel.getUser()).thenReturn(user);

        presenter.getCurrentUser();
        verify(mockedModel, times(1)).getUser();
        verify(mockedView, times(1)).setFirstName("Manolo");
        verify(mockedView, times(1)).setLastName("Escobar");
        verify(mockedView, never()).showUserNotAvailable();

    }


    @Test
    public void showErrorMessageWhenUserIsNull() {
        when(mockedModel.getUser()).thenReturn(null);


        presenter.getCurrentUser();
        verify(mockedModel, times(1)).getUser();
        verify(mockedView, never()).setFirstName("Manolo");
        verify(mockedView, never()).setLastName("Escobar");
        verify(mockedView, times(1)).showUserNotAvailable();

    }

    @Test
    public void showErrorMessageWhenAnyFieldIsEmpty () {
        when(mockedView.getFirstName()).thenReturn("");
        presenter.loginButtonClicked();

        verify(mockedView, times(1)).getFirstName();
        verify(mockedView, never()).getLastName();
        verify(mockedView, times(1)).showInputError();

        when(mockedView.getFirstName()).thenReturn("Daniel");
        when(mockedView.getLastName()).thenReturn("");
        presenter.loginButtonClicked();

        verify(mockedView, times(2)).getFirstName();
        verify(mockedView, times(1)).getLastName();
        verify(mockedView, times(2)).showInputError();

    }

    @Test
    public void saveValidUser() {
        when(mockedView.getFirstName()).thenReturn("Daniel");
        when(mockedView.getLastName()).thenReturn("Pelayo");

        presenter.loginButtonClicked();

        verify(mockedModel, times(1)).createUser("Daniel", "Pelayo");
        verify(mockedView, times(1)).showUserSaved();
        verify(mockedView, times(2)).getFirstName();
        verify(mockedView, times(2)).getLastName();
    }
}
