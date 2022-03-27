/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Birame NDIAYE
 */
public class studentStorageCsv implements StudentStorage {

    Scanner sc = new Scanner(System.in);
    File file = new File("student.csv");
    String message;

    @Override
    public String save(Student s) {

        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            fw.write(saveFormat(s) + "\n");
            fw.flush();
            fw.close();
            message = "Etudiant enregistré  crée avec succes";
        } catch (IOException ex) {
            message = "Etudiant non enregistré";
        }
        return message;
    }

    @Override
    public ArrayList<Student> list() {

        ArrayList<Student> list = new ArrayList();

        try (BufferedReader bw = new BufferedReader(new FileReader("student.csv"))) {

            String ab;
            Student s = new Student();

            while ((ab = bw.readLine()) != null) {
                String[] array = ab.split(";");
                String name = null, niv = null, mail = null, address = null;
                if (array.length == 2) {
                    name = array[0];
                    niv = array[1];
                }
                if (array.length == 3) {
                    name = array[0];
                    niv = array[1];
                    if (array[2].contains("@")) {
                        mail = array[2];
                    } else {
                        address = array[2];
                    }
                }
                if (array.length == 4) {
                    name = array[0];
                    niv = array[1];
                    mail = array[2];
                    address = array[3];
                }
                Student student = new Student(name, niv, mail, address);
                list.add(student);
            }
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public String saveFormat(Student s) {
        String str = s.getName() + ";" + s.getNiveau();
        if (s.getEmail() != null && s.getAddress() != null) {
            str += ";" + s.getEmail() + ";" + s.getAddress();
        } else if (s.getEmail() == null && s.getAddress() != null) {
            str += ";" + s.getAddress();
        } else if (s.getEmail() != null && s.getAddress() == null) {
            str += ";" + s.getEmail();
        } else {
        }
        return str;
    }

    @Override
    public String delete(int index) {

        ArrayList<String> array = new ArrayList();
        try (BufferedReader bw = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bw.readLine()) != null) {
                array.add(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(studentStorageCsv.class.getName()).log(Level.SEVERE, null, ex);
        }
        array.remove(index);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            array.forEach(l -> {
                try {
                    bw.append(l + "\n");
                } catch (IOException ex) {
                }
            });

            message = "Etudiant supprimé ";
        } catch (IOException ex) {
            message = "Etudiant non supprimé";
        }
        return message;
    }

    @Override
    public String update(Student s, int index) {
        ArrayList<String> array = new ArrayList();
        try (BufferedReader bw = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bw.readLine()) != null) {
                array.add(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(studentStorageCsv.class.getName()).log(Level.SEVERE, null, ex);
        }
        array.set(index, saveFormat(s));
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            array.forEach(l -> {
                try {
                    bw.append(l + "\n");
                } catch (IOException ex) {
                }
            });

            message = "Etudiant modifié ";
        } catch (IOException ex) {
            message = "Etudiant non modifié";
        }
        return message;
    }

}
