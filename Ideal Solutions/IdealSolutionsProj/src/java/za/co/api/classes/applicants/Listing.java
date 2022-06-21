/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.api.classes.applicants;

/**
 *
 * @author Litania Chauke
 */
public class Listing {
    private int listingId;
    private int JobId;
    private int candidate;

    public Listing() {
    }

    public Listing(int listingId, int JobId, int candidate) {
        this.listingId = listingId;
        this.JobId = JobId;
        this.candidate = candidate;
        
    }
    
    

    public int getListingId() {
        return listingId;
    }

    public void setListingId(int listingId) {
        this.listingId = listingId;
    }

    public int getJobId() {
        return JobId;
    }

    public void setJobId(int JobId) {
        this.JobId = JobId;
    }

    public int getCandidates() {
        return candidate;
    }

    public void setCandidate(int candidates) {
        this.candidate = candidates;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.listingId;
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
        final Listing other = (Listing) obj;
        if (this.listingId != other.listingId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Listing{" + "listingId=" + listingId + ", JobId=" + JobId + ", candidates=" + candidate+'}';
    }
    
    
}
