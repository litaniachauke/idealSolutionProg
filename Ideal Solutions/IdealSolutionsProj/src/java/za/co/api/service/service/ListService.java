package za.co.api.service.service;

import za.co.api.classes.applicants.Listing;

public interface ListService {
     public boolean addListing(Listing list);
    public Listing getListing(int lsId);
    public boolean deleteListing(int lsId);
}
