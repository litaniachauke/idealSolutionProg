package za.co.api.service.dao;

import za.co.api.classes.applicants.Applicants;

public interface ApplicantsDAO {
    public boolean addApplicant(Applicants app);
    public Applicants getApplicant(int appId);
    public boolean deleteApplicant(int appId);
    public boolean editApplicant(Applicants app);
}
