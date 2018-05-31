package io.github.externschool.planner.entity;

import io.github.externschool.planner.dto.UserDTO;

import io.github.externschool.planner.entity.profile.Person;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private Person person;

    @Column(name = "email")
    private String email;

    @Transient
    @Column(name = "password")
    private String password;

    @Column(name = "encrypted_password")
    private String encryptedPassword;

    public User() {

    }

    public User(Person person, String email, String password, String encryptedPassword) {
        this.person = person;
        this.email = email;
        this.password = password;
        this.encryptedPassword = encryptedPassword;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

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

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(encryptedPassword, user.encryptedPassword);
    }


    public UserDTO constructUser() {
        UserDTO userDtO = new UserDTO();
        userDtO.setEmail(this.getEmail());
        userDtO.setPassword(this.getPassword());
        return userDtO;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, email, password, encryptedPassword);
    }

}
