import SondeoPrecios.UsuarioPasswordEncoderListener
import org.springframework.web.servlet.i18n.SessionLocaleResolver

// Place your Spring DSL code here
beans = {
    usuarioPasswordEncoderListener(UsuarioPasswordEncoderListener)
    localeResolver(SessionLocaleResolver) {
        defaultLocale= new Locale('es')
    }
}
