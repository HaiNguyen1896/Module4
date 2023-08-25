package Model;

import javax.persistence.*;

@Entity //Đánh dâu entity
@Table(name = "customer") //Đánh dấu bảng
public class Customer {
    @Id //Đánh dấu khóa chính
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Đánh dấu tự tăng
    private int id;
    private String email;
    private String address;

    public Customer() {
    }

    public Customer(int id, String email, String address) {
        this.id = id;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
