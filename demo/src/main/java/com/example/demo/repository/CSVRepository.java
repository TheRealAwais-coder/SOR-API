package com.example.demo.repository;

import com.example.demo.dto.OrganisationDTO;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.StreamSupport;

@Repository
public class CSVRepository implements CSVRepositoryInterface 
{
    private final String filePath = "src/main/resources/sor.csv";
    private Map<String, OrganisationDTO> organisationMap = new ConcurrentHashMap<>();

    @PostConstruct
    public void LoadOrganisationsFromCSV() 
    {
        CSVParser csvParser = new CSVParserBuilder()
                .withSeparator(';')
                .build();

        try 
        (
            InputStreamReader fileReader = new InputStreamReader(new FileInputStream(filePath), StandardCharsets.ISO_8859_1);
            CSVReader csvReader = new CSVReaderBuilder(fileReader)
                    .withCSVParser(csvParser)
                    .withSkipLines(1)
                    .build();
        ) 
        {
            StreamSupport.stream(csvReader.spliterator(), true).forEach(record -> 
            {
                    OrganisationDTO organisation = new OrganisationDTO(); 
                    organisation.setName(record[0]);
                    organisation.setType(record[1]);
                    organisation.setRegion(record[53]);
                    organisation.setSorCode(record[7]);
                    organisation.setCvr(record[51]);
                    organisation.setParentSorCode(record[8]);

                    
                    organisationMap.put(organisation.getSorCode(), organisation);
                    
            });

        } 
        catch (IOException  e) {
            //empty on purpose
        }
    }

    public Map<String, OrganisationDTO> GetOrganisationMap() 
    {
        return organisationMap;
    }
}
