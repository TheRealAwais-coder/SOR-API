package com.example.demo.services;

import com.example.demo.dto.OrganisationDTO;
import com.example.demo.repository.CSVRepositoryInterface;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class LookUpOrganisationService implements LookUpOrganisationServiceInterface 
{
	private Map<String, OrganisationDTO> organisationMap;

	public LookUpOrganisationService(CSVRepositoryInterface csvRepository) 
	{
		this.organisationMap = csvRepository.GetOrganisationMap();
	}

	public OrganisationDTO GetOrganisationBySorCode(String sorCode) 
	{
		OrganisationDTO organisation = organisationMap.get(sorCode);
		if (organisation == null) 
		{
			return null;
		}

		OrganisationDTO organisationDTO = new OrganisationDTO();
		organisationDTO.setName(organisation.getName());
		organisationDTO.setType(organisation.getType());
		organisationDTO.setRegion(organisation.getRegion());
		organisationDTO.setSorCode(organisation.getSorCode());
		organisationDTO.setCvr(organisation.getCvr());
		organisationDTO.setParentSorCode(organisation.getParentSorCode());

		List<String> childSorCodes = new ArrayList<>();
		for (OrganisationDTO org : organisationMap.values()) 
		{
			if (sorCode.equals(org.getParentSorCode())) 
			{
				childSorCodes.add(org.getSorCode());
			}
		}
		organisationDTO.setChildSorCodes(childSorCodes);

		return organisationDTO;
	}

	public OrganisationDTO GetParentOrganisationBySorCode(String sorCode) 
	{
		OrganisationDTO organisation = organisationMap.get(sorCode);
		if (organisation == null) 
		{
			return null;
		}
		
		while (organisation.getParentSorCode() != null && !organisation.getParentSorCode().isEmpty()) 
		{
			OrganisationDTO parentOrganisation = organisationMap.get(organisation.getParentSorCode());
			if (parentOrganisation == null) 
			{
				break;
			}
			organisation = parentOrganisation;
		}

		return organisation;
	}
}
