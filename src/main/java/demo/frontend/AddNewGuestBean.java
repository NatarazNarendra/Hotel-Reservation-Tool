

package demo.frontend;

import demo.business.GuestService;
import demo.domain.Guest;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
// DO NOT USE: import javax.faces.bean.ViewScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

/**
 *
 * @author dschmitz
 */
@Named
//@RequestScoped
@ViewScoped
// @RolesAllowed({ "ADMIN", "CLERK" })
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
        FacesMessage message = new FacesMessage("Guest saved: " + this.guest, "Guest saved:" + this.guest);
        FacesContext.getCurrentInstance().addMessage(null, message);
        this.guest = new Guest("", "");
    }
}
