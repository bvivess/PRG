package ACT7_1C;

/**
 *
 * @author Administrador
 */
public class Main {

    public static void main(String[] args) {
        Manager manager = new Manager("Barbara Johnson", "Manager", "1");
        TechnicalWriter tWriter = new TechnicalWriter("Bill Monroe", "Writer", "2");
        manager.addEmployee(tWriter);
        tWriter.addSkill("Skill1");
        tWriter.addSkill("Skill2");
        tWriter.addSkill("Skill2");
        
        System.out.println(manager.toString());

    }
    
}
