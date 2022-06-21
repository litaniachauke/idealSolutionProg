package za.co.api.service.service;

import za.co.api.classes.applicants.Job;



public interface JobService {
    public boolean addJob(Job job);
    public Job getJob(int jobId);
    public boolean deleteJob(int jobId);
    public boolean editJob(Job job);
}
