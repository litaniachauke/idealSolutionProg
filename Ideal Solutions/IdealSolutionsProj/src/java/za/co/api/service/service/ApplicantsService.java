package za.co.api.service.service;

import za.co.api.classes.applicants.Applicants;

public interface ApplicantsService {
     public boolean addApplicant(Applicants app);
    public Applicants getApplicant(int appId);
    public boolean deleteApplicant(int appId);
    public boolean editApplicant(Applicants app);
}
