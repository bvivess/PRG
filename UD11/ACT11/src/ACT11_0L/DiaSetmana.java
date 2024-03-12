/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ACT11_0L;

/**
 *
 * @author winadmin
 */
public enum DiaSetmana {
    DILLUNS("DL","Laborable"), 
    DIMARTS("DM","Laborable"), 
    DIMECRES("DX","Meitat de setmana"),
    DIJOUS("DJ","Laborable"),
    DIVENDRES("DV","Laborable"), 
    DISSABTE("DS","Festiu"), 
    DIUMENGE("DG","Festiu");

    private final String abreviacio;
    private final String activitat;

    DiaSetmana(String abreviacio, String activitat) {
        this.abreviacio = abreviacio;
        this.activitat = activitat;
    }
    
    public String getAbreviacio() {
        return abreviacio;
    }

    public String getActivitat() {
        return activitat;
    }
}

