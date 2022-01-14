package org.springframework.samples.petclinic.vacination;

import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccinationService {

    @Autowired
    VaccinationRepository vaccinationRepository;

    public List<Vaccination> getAll(){
        return vaccinationRepository.findAll();
    }

    public List<Vaccine> getAllVaccines(){
        return vaccinationRepository.findAllVaccines();
    }

    public Vaccine getVaccine(String typeName) {
        return vaccinationRepository.findVaccineByName(typeName);
    }

    //@Transactional(rollbackFor = UnfeasibleVaccinationException.class)
    public Vaccination save(Vaccination p) throws UnfeasibleVaccinationException {
        Vaccine otherVaccine = p.getVaccine();
        //if(otherVaccine != p.getVaccinatedPet())
            vaccinationRepository.save(p);
            return p;
        //throw new UnfeasibleVaccinationException();
    }

 
    
}
