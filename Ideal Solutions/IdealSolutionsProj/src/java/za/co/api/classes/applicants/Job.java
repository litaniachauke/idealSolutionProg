
package za.co.api.classes.applicants;

public class Job {
        int jobID;
        String des;
        double Salary;

    public Job(int jobID, String des, double Salary) {
        this.jobID = jobID;
        this.des = des;
        this.Salary = Salary;
    }

    public Job() {
    }

    public int getJobID() {
        return jobID;
    }

    public void setJobID(int jobID) {
        this.jobID = jobID;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double Salary) {
        this.Salary = Salary;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.jobID;
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
        if (this.jobID != other.jobID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Job{" + "jobID=" + jobID + ", des=" + des + ", Salary=" + Salary + '}';
    }
 
        
        
}
