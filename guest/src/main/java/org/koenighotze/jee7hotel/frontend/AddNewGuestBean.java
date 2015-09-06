package org.koenighotze.jee7hotel.frontend;

import org.koenighotze.jee7hotel.business.GuestService;
import org.koenighotze.jee7hotel.domain.Guest;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

import static javax.faces.application.FacesMessage.SEVERITY_INFO;
import static org.koenighotze.jee7hotel.frontend.FacesMessageHelper.addMessage;

/**
 * @author dschmitz
 */
@Named
// DO NOT USE: import javax.faces.bean.ViewScoped;
@ViewScoped
public class AddNewGuestBean implements Serializable {
    @NotNull
    private Guest guest;

    @Inject
    private GuestService guestService;

    @PostConstruct
    public void init() {
        this.guest = new Guest("", "");
    }

    public Guest getGuest() {
        return this.guest;
    }

    public void saveGuest() {
        this.guestService.saveGuest(this.guest);
        addMessage(SEVERITY_INFO, "Guest saved: " + this.guest);

        this.guest = new Guest("", "");
    }
}
