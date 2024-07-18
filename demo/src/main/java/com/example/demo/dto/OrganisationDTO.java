package com.example.demo.dto;

import java.util.List;

public class OrganisationDTO 
{
	//
    private String name;
    private String type;
    private String region;
    private String sorCode;
    private String cvr;
    private String parentSorCode;
    private List<String> childSorCodes;

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSorCode() {
        return sorCode;
    }

    public void setSorCode(String sorCode) {
        this.sorCode = sorCode;
    }

    public String getCvr() {
        return cvr;
    }

    public void setCvr(String cvr) {
        this.cvr = cvr;
    }

    public String getParentSorCode() {
        return parentSorCode;
    }

    public void setParentSorCode(String parentSorCode) {
        this.parentSorCode = parentSorCode;
    }

    public List<String> getChildSorCodes() {
        return childSorCodes;
    }

    public void setChildSorCodes(List<String> childSorCodes) {
        this.childSorCodes = childSorCodes;
    }
}
