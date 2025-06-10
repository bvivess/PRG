package ex_ord;

import examen.utils.GestorExamen;

public class Main {
    public static void main(String[] args) {
        GestorExamen gestor = new GestorExamen();

        try {
            gestor.carregaDades();

            gestor.mostraDepartments();
            gestor.mostraEmployees();
            gestor.mostraDepartmentsXEmployees();
            
            gestor.desaDepartmentsXEmployeesCSV("c:\\temp\\departmentXEmpleats.cvs");

            
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

