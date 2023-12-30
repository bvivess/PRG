/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ACT8_0E;

/**
 *
 * @author winadmin
 */
public class Television extends ElectronicDevice {
    String b;
    
    public void turnOn() {
    changeChannel(1);
    initializeScreen();
    }

    public void turnOff() {}
    public void changeChannel(int channel) {}
    public void initializeScreen() {}
}