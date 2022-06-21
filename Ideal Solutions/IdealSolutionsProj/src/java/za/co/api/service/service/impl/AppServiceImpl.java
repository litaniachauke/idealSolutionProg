/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.api.service.service.impl;

import java.sql.Connection;
import za.co.api.classes.applicants.Applicants;
import za.co.api.service.dao.ApplicantsDAO;
import za.co.api.service.dao.impl.ApplicantsDAOImpl;
import za.co.api.service.service.ApplicantsService;


/**
 *
 * @author Litania Chauke
 */
public class AppServiceImpl implements ApplicantsService{
    private final ApplicantsDAO appdao;

    public AppServiceImpl(Connection con) {
        this.appdao = new ApplicantsDAOImpl(con);
    }
    
    
    
    
    @Override
    public boolean addApplicant(Applicants app) {
        return appdao.addApplicant(app);
    }

    @Override
    public Applicants getApplicant(int appId) {
        return appdao.getApplicant(appId);
    }

    @Override
    public boolean deleteApplicant(int appId) {
        return appdao.deleteApplicant(appId);
    }

    @Override
    public boolean editApplicant(Applicants app) {
        return appdao.editApplicant(app);
    }
    
}
