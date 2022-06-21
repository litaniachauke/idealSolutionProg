/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.api.service.service.impl;

import java.sql.Connection;
import za.co.api.classes.applicants.Listing;
import za.co.api.service.dao.ListingsDAO;
import za.co.api.service.dao.impl.ListingsDAOImpl;
import za.co.api.service.service.ListService;

/**
 *
 * @author TRAIN 80
 */
public class ListServiceImpl implements ListService {

    private final ListingsDAO listdao;
    public ListServiceImpl(Connection con) {
        listdao = new ListingsDAOImpl(con);
    }

    @Override
    public boolean addListing(Listing list) {
        return listdao.addListing(list);
    }

    @Override
    public Listing getListing(int lsId) {
    
        return listdao.getListing(lsId);
    }

    @Override
    public boolean deleteListing(int lsId) {
        return listdao.deleteListing(lsId);
    }

    
}
