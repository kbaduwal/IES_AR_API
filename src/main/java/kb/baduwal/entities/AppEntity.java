package kb.baduwal.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="IES_APP")
public class AppEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long casNum;

    private String fullname;

    private String email;

    private String gender;

    private LocalDate dob;

    private String phno;

    private Long ssn;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public Long getCasNum() {
        return casNum;
    }

    public void setCasNum(Long casNum) {
        this.casNum = casNum;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public Long getSsn() {
        return ssn;
    }

    public void setSsn(Long ssn) {
        this.ssn = ssn;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
