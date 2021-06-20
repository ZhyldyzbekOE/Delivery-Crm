package kg.megacom.deliverycrm.models;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "admins")
public class Admin {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Pattern(regexp = "[а-яА-Я]*" , message = "Введите на кириллице")
    private String firstName;
    @NotEmpty
    @Pattern(regexp = "[а-яА-Я]*" , message = "Введите на кириллице")
    private String lastName;
    @NotEmpty
    private String login;
    @Size(min = 5)
    @Pattern(regexp = "[a-zA-Z0-9]*")
    @NotEmpty
    private String password;


    public Admin(String firstName, String lastName, String login, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
    }

    public Admin(Long id, String firstName, String lastName, String login, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
    }

    public Admin() { }

    @Override
    public String toString() {
        return "Admin{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
