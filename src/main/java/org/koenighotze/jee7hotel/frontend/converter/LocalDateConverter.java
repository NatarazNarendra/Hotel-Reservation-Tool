package org.koenighotze.jee7hotel.frontend.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

/**
 * Created by dschmitz on 15.11.14.
 */
@FacesConverter(forClass = LocalDate.class)
public class LocalDateConverter implements Converter {
    private static final Logger LOGGER = Logger.getLogger(LocalDateConverter.class.getName());

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        LOGGER.fine(() -> "Get as object " + s);
        // TODO: extract pattern from component

        if (null == s) {
            return null;
        }
        // as we are using html5 date components, this pattern is submitted
        return LocalDate.parse(s, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        LOGGER.fine(() -> "Get as string " + o);
        // TODO: extract pattern from component

        if (null == o || !(o instanceof LocalDate)) {
            return null;
        }
        return DateTimeFormatter.ofPattern("yyyy-MM-dd").format((LocalDate) o);
    }
}