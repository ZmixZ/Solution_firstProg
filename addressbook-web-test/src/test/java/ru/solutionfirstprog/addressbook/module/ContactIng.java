package ru.solutionfirstprog.addressbook.module;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "addressbook")
@XStreamAlias("contact")
public class ContactIng {

    @XStreamOmitField
    @Id
    @Column(name = "id")
    private int id = Integer.MAX_VALUE;

    @Transient
    private String company;

    @Transient
    private String street;

    @Transient
    private String email1;

    @Column(name = "firstname")
    private String name;

    @Transient
    private String middlename;

    @Column(name = "lastname")
    private String lastname;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name ="address_in_groups",
            joinColumns = @JoinColumn(name ="id"), inverseJoinColumns = @JoinColumn(name ="group_id"))
    private Set<GroupInf> groups = new HashSet<>();

    @Column(name = "home")
    @Type(type ="text")
    private String homePhone;

    @Column(name = "mobile")
    @Type(type ="text")
    private String mobilePhone;

    @Column(name = "work")
    @Type(type ="text")
    private String workPhone;

    @Transient
    private String allPhone;

    @Transient
    private String email2;

    @Transient
    private String email3;

    @Transient
    private String allEmail;

    @Column(name = "photo")
    @Type(type ="text")
    private String photo;

    public String getAllPhone() {
        return allPhone;
    }

    public String getCompany() {
        return company;
    }

    public String getStreet() {
        return street;
    }

    public String getEmail1() {
        return email1;
    }

    public String getName() {
            return name;
        }

        public String getMiddlename() {
            return middlename;
        }

        public String getLastname() {
            return lastname;
        }

    public String getHomePhone() {
        return homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public String getAllEmail() {
        return allEmail;
    }

    public File getPhoto() {
        return new File(photo);
    }

    public Groups getGroups() {
        return new Groups(groups);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactIng that = (ContactIng) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastname);
    }

    public int getId() {
        return id;
    }

    public ContactIng withId(int id) {
        this.id = id;
        return this;
    }

    public ContactIng  withCompany(String company) {
        this.company = company;
        return this;
    }

    public ContactIng  withStreet(String street) {
        this.street = street;
        return this;
    }

    public ContactIng withEmail1(String email1) {
        this.email1 = email1;
        return this;
    }

    public ContactIng  withName(String name) {
        this.name = name;
        return this;
    }

    public ContactIng withMiddlename(String middlename) {
        this.middlename = middlename;
        return this;
    }

    public ContactIng  withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactIng withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public ContactIng withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public ContactIng withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }

    public ContactIng withAllPhones(String allPhone) {
        this.allPhone = allPhone;
        return this;
    }

    public ContactIng withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public ContactIng withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public ContactIng withAllEmail(String allEmail) {
        this.allEmail = allEmail;
        return this;
    }

    public ContactIng withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
    }

    @Override
    public String toString() {
        return "ContactIng{" +
                "lastname='" + lastname + '\'' +
                '}';
    }

    public ContactIng inGroup(GroupInf group){
        groups.add(group);
        return this;
    }

}

