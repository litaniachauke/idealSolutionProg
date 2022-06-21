
package za.co.api.service.dao;

import za.co.api.classes.applicants.Listing;

public interface ListingsDAO {
    public boolean addListing(Listing list);
    public Listing getListing(int lsId);
    public boolean deleteListing(int lsId);
}
