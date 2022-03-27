/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanager;

import static java.lang.System.out;

/**
 *
 * @author Birame NDIAYE
 */
public class Student {

    private String Name;
    private String Niveau;
    private String Email;
    private String address;

    public Student(String Name, String Niveau, String Email, String address) {
        this.Name = Name;
        this.Niveau = Niveau;
        this.Email = Email;
        this.address = address;
    }

    public Student(String Name, String Niveau) {
        this.Name = Name;
        this.Niveau = Niveau;
    }

    Student() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getNiveau() {
        return Niveau;
    }

    public void setNiveau(String Niveau) {
        this.Niveau = Niveau;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void displaystudent() {
        if (Email != null && address != null) {
            out.println("Nom : " + Name + "\nNiveau : " + Niveau + "\n Email : " + Email + "\nAdresse : " + address);
        }
        if (Email != null && address == null) {
            out.println("Nom : " + Name + "\nNiveau : " + Niveau + "\n Email : " + Email);
        }
        if (Email == null && address != null) {
            out.println("Nom : " + Name + "\nNiveau : " + Niveau + "\nAdresse : " + address);
        }
        if (Email == null && address == null) {
            out.println("Nom : " + Name + "\nNiveau : " + Niveau);
        }
    }

    public String convertUserToCsvLine() {
        return Name + "," + Niveau + "," + Email + "," + address;

    }

}
