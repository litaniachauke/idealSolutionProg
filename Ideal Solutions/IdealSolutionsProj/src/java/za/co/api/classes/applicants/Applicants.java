/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.api.classes.applicants;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Litania Chauke
 */
public class Applicants {
      @JsonProperty("app-Id")
    private int appId;
        @JsonProperty("resume")
    private String resume;
          @JsonProperty("name")
    private String name;
            @JsonProperty("surname")
    private String surname;

    public Applicants(int appId, String name, String surname, String resume) {
        this.appId = appId;
        this.resume = resume;
        this.name = name;
        this.surname = surname;
    }

    
    

    public Applicants() {
    }

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + this.appId;
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
        final Applicants other = (Applicants) obj;
        if (this.appId != other.appId) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public String toString() {
        return "Applicants{" + "appId=" + appId + ", resume=" + resume + ", name=" + name + ", surname=" + surname + '}';
    }
    
    
   
}
