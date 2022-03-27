/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanager;

import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Birame NDIAYE
 */
public class StudentManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        out.println("1- Liste des étudiants");
        out.println("2- Enregistrer un étudiant");
        Scanner src = new Scanner(System.in);
        int op = src.nextInt();
        studentStorageCsv cs = new studentStorageCsv();
        if (op == 1) {
            int i = 0;
            for (Student s : cs.list()) {
                i++;
                out.println(i + " " + s.getName());
            }

            out.println("Afficher les détails");
            out.print("Entrez l'index de l'étudiant : ");
            src = new Scanner(System.in);
            int index = src.nextInt();
            Student s = cs.list().get(index - 1);
            s.displaystudent();

            out.println("1-Modifier l'etudiant");
            out.println("2-Supprimer l'etudiant");
            src = new Scanner(System.in);
            op = src.nextInt();

            if (op == 1) {
                src = new Scanner(System.in);
                Student s1 = cs.list().get(index - 1);
                String name, niv, mail, address;
                out.print("Veillez entrez le nouveau nom (" + s1.getName() + ") : ");
                name = src.nextLine();
                out.print("Veillez entrez le nouveau niveau(" + s1.getNiveau() + ") : ");
                niv = src.nextLine();

                if (s1.getEmail() == null) {
                    out.print("Veillez le nouvel email () : ");
                    mail = src.nextLine();
                } else {
                    out.print("Veillez le nouvel email (" + s1.getEmail() + ") :");
                    mail = src.nextLine();
                }

                if (s1.getAddress() == null) {
                    out.print("Veillez le nouvel adresse () : ");
                    address = src.nextLine();
                } else {
                    out.print("Veillez le nouvel adresse (" + s1.getAddress() + ") :");
                    address = src.nextLine();
                }

                if (name.isEmpty()) {
                    name = s1.getName();
                }

                if (niv.isEmpty()) {
                    niv = s1.getNiveau();
                }

                if (mail.isEmpty()) {
                    mail = s1.getEmail();
                }

                if (address.isEmpty()) {
                    address = s1.getAddress();
                }
                Student s2 = new Student(name, niv, mail, address);
                out.println(cs.update(s2, index - 1));

            }

            if (op == 2) {
                out.println(" Voulez-vous vraiment supprimer cet élément?(1 pour oui et 2 pour non)");
                src = new Scanner(System.in);
                op = src.nextInt();
                if (op == 1) {
                    out.println(cs.delete(index - 1));
                }
            }
            op = 1;
        }

        if (op == 2) {
            String name, niv, mail, address;
            src = new Scanner(System.in);

            do {
                out.print("Entrez le nom de l'etudiant : ");
                name = src.nextLine();
            } while (name.isEmpty());

            do {
                out.print("Entrez le niveau de l'etudiant : ");
                niv = src.nextLine();
            } while (niv.isEmpty());

            out.print("Entrez l'email de l'etudiant : ");
            mail = src.nextLine();

            out.print("Entrez l'adresse de l'etudiant : ");
            address = src.nextLine();
            if (mail.isEmpty()) {
                mail = null;
            }
            if (address.isEmpty()) {
                address = null;
            }
            Student student = new Student(name, niv, mail, address);
            out.println(cs.save(student));

        }

    }

}
