package EX_UD13_II;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;

public class Job implements Serializable {
    private String jobId;
    private String jobTitle;

    public Job(String jobId, String jobTitle) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
    }

    public String getJobId() {
        return jobId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.jobId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Job other = (Job) obj;
        return Objects.equals(this.jobId, other.jobId);
    }

    @Override
    public String toString() {
        return "Job{" + "jobId=" + jobId + ", jobTitle=" + jobTitle + '}';
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();  // assegura el procés normal de serialitzacio

        // Emmagatzemar la data (per exemple)
        oos.writeObject(new java.util.Date());  // escriu un timestamp
    }
    
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();  // assegura el procés normal de deserialització

        // Altres
        System.out.println ("Emmagatzemat en data: " + (java.util.Date)ois.readObject()); // mostra el timestamp
    }
 
}
