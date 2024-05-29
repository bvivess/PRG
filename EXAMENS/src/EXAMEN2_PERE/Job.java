package EXAMEN2_PERE;

import java.io.Serializable;

/**
 *
 * @author Pedro
 */
public class Job  implements Serializable{
    private String jobId;
    private String jobTitle;

    public Job(String jobId, String jobTitle) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
    }

    public String getJobId() {
        return jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    @Override
    public String toString() {
        return "Job{" + "jobId=" + jobId + ", jobTitle=" + jobTitle + '}';
    }
}
