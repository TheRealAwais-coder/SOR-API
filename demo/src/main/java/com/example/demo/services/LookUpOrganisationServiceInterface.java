package com.example.demo.services;

import com.example.demo.dto.OrganisationDTO;

public interface LookUpOrganisationServiceInterface 
{
   public OrganisationDTO GetOrganisationBySorCode(String sorCode);
   public OrganisationDTO GetParentOrganisationBySorCode(String sorCode);
}
