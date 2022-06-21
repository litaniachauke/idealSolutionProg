package za.co.api.service.dao;

import za.co.api.classes.applicants.Job;



public interface JobDAO {
    public boolean addJob(Job job);
    public Job getJob(int jobId);
    public boolean deleteJob(int jobId);
    public boolean editJob(Job job);
}
