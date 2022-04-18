package com.patient1.patient1.web;

import com.patient1.patient1.entities.Patient;
import com.patient1.patient1.repositories.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;
    @GetMapping(path = "/index")
    public String patients(Model model,
                           @RequestParam(name="page",defaultValue = "0") int page,
                           @RequestParam(name="size",defaultValue ="5")int size,
                           @RequestParam(name="keyword",defaultValue ="") String keyword
    ){
        Page<Patient> p1= (Page<Patient>) patientRepository.findAll(PageRequest.of(page,size));
        model.addAttribute("ListPatients",p1);
        model.addAttribute("pages",new int[p1.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);
        return "patients";
    }

}
