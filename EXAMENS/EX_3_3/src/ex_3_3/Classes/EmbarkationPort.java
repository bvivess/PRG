package ex_3_3.Classes;


public enum EmbarkationPort {
    C ("Cherbourg"),
    Q ("Queenstown"),
    S ("Southampton");

    private String portName;

    EmbarkationPort(String portName) {
        this.portName = portName;
    }

    public String getPortName() {
        return portName;
    }
    
}
