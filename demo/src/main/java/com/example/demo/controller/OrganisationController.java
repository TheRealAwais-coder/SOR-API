package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.OrganisationDTO;
import com.example.demo.services.LookUpOrganisationService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api")
@Tag(name = "Organisation")
public class OrganisationController 
{

	@Autowired
    private LookUpOrganisationService lookUpOrganisationService;
	
	
    @GetMapping("/GetOrganisationBySorCode")
    public OrganisationDTO GetOrganisationBySorCode(String sorCode) 
    {
        return lookUpOrganisationService.GetOrganisationBySorCode(sorCode);
    }
    
    @GetMapping("/GetParentOrganisationBySorCode")
    public OrganisationDTO GetParentOrganisationBySorCode(String sorCode) 
    {
        return lookUpOrganisationService.GetParentOrganisationBySorCode(sorCode);
    }
}