
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean(name = "lgn")
public class loginController {

    private String email, password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean Login() {
        try {
            Connection con = DbConnection.getConnection();

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from login where email ='" + email + "' and password = '" + password + "'");

            if (!rs.first()) {
                System.out.print("Login Failed");
                return false;
            } else {
                System.out.print("Logged In Successfully !");
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print("Something Went Wrong");
        }

        return false;

    }

}
