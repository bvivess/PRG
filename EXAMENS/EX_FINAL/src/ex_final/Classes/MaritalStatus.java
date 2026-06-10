package ex_final.Classes;

public enum MaritalStatus {
    MARRIED ("Married"),
    SINGLE ("Single"),
    DIVORCED ("Divorced"),
    WIDOWED ("Widowed"),
    SEPARATED ("Separated");
    
    private final String description; 

    MaritalStatus(String description) { 
        this.description = description;
    }
    
    public String getDescription() { 
        return this.description;
    }

}
