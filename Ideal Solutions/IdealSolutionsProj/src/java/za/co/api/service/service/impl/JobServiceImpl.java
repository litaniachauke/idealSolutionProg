package za.co.api.service.service.impl;

import java.sql.Connection;
import za.co.api.classes.applicants.Job;

import za.co.api.service.dao.JobDAO;
import za.co.api.service.dao.impl.JobDAOImpl;
import za.co.api.service.service.JobService;

public class JobServiceImpl implements JobService{

    private final JobDAO jobdao;
    public JobServiceImpl(Connection con) {
        jobdao = new JobDAOImpl(con);
    }

    
    @Override
    public boolean addJob(Job job) {
        return jobdao.addJob(job);
    }

    @Override
    public Job getJob(int jobId) {
        return jobdao.getJob(jobId);
    }

    @Override
    public boolean deleteJob(int jobId) {
        return jobdao.deleteJob(jobId);
    }

    @Override
    public boolean editJob(Job job) {
        return jobdao.editJob(job);
    }
    
}
