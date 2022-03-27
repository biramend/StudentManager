/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanager;

import java.util.ArrayList;

/**
 *
 *@author Birame NDIAYE
 */
public interface StudentStorage {

    String save(Student s);

    ArrayList<Student> list();

    String delete(int index);

    String update(Student s, int index);

}
