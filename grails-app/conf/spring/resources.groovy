import SondeoPrecios.UsuarioPasswordEncoderListener
import org.springframework.web.servlet.i18n.SessionLocaleResolver
import java.text.NumberFormat 
import org.grails.databinding.converters.web.LocaleAwareNumberConverter

// Place your Spring DSL code here
beans = {
    usuarioPasswordEncoderListener(UsuarioPasswordEncoderListener)
    localeResolver(SessionLocaleResolver) {
        defaultLocale= new Locale('es')
    }
 	//Necesario para cambiar el separador de decimal a punto
    defaultGrailsBigDecimalConverter(conversorDecimalAPunto)
}

class conversorDecimalAPunto extends LocaleAwareNumberConverter {

    @Override
    protected NumberFormat getNumberFormatter() {
        NumberFormat.getInstance(Locale.en_US)
    }
}