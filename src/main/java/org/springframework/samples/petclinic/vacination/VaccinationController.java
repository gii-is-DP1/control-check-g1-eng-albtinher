package org.springframework.samples.petclinic.vacination;

import java.util.Collection;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VaccinationController {
    
    @Autowired
    VaccinationService vaccinationService;

    @ModelAttribute("types")
    public Collection<Vaccine> populateVaccine() {
	return vaccinationService.getAllVaccines();
    }
    
    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
	dataBinder.setDisallowedFields("id");
    }

    //con esto para el 9 vale solamente
    @GetMapping("/vaccination/create")
    public String initCreationForm(Map<String, Object> model) {
	    Vaccination vaccination = new Vaccination();
	    model.put("vaccination", vaccination);
	    return "vaccination/createOrUpdateVaccinationForm";
    }

    //TEST 10 --> no tengo implementado el save bien
    @PostMapping("/product/create")
    public String processCreationForm(@Valid Vaccination vaccination, BindingResult result) {
	if(result.hasErrors()) {
	    return "vaccination/createOrUpdateVaccinationForm";
	} else {
	    //vaccinationService.save(vaccination);
	    return "welcome";
	    }
    }

}
