package tiendas3b.com.mx.proyectomvp.root;

import javax.inject.Singleton;

import dagger.Component;
import tiendas3b.com.mx.proyectomvp.login.LoginActivity;
import tiendas3b.com.mx.proyectomvp.login.LoginModule;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        LoginModule.class})
public interface ApplicationComponent {

    void inject(LoginActivity target);

}
