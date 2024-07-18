package com.example.demo.repository;

import java.util.Map;
import com.example.demo.dto.OrganisationDTO;

public interface CSVRepositoryInterface 
{
    public void LoadOrganisationsFromCSV();
    public Map<String, OrganisationDTO> GetOrganisationMap();
}