package kataCRUD.models;



import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min = 2, max = 20, message = "Имя должно быть от 2 до 20 знаков")
    private String name;

    @Column(name = "age")
    @Min(value = 0, message = "Возраст должен быть больше 0")
    private int age;

    @Column(name = "email")
    @NotEmpty(message = "email должен быть не пустым")
    @Email(message = "email введен неправильно")
    private String email;

    public User(int id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }
    public User(){

    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
