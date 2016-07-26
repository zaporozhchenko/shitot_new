package com.shitot.web;

import com.shitot.model.Doctor;
import com.shitot.model.TargetAudience;
import com.shitot.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Next on 21.07.2016.
 */
@Controller
public class RootController {

    @Autowired
    private DoctorService doctorService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String root(Model model) {
        model.addAttribute("page","home");
        return "index";
    }

    @RequestMapping(value = "/doctors", method = RequestMethod.GET)
    public String doctorList(Model model) {
        List<Doctor> doctors = doctorService.getAll();
        model.addAttribute("doctorList", doctors);
        model.addAttribute("page","doctorList");
        model.addAttribute("specialtyList", doctorService.getAllSpecialties());
        model.addAttribute("expertList", doctorService.getAllExperiences());
        model.addAttribute("certificateList", doctorService.getAllCertificates());
        model.addAttribute("targetAudienceList", doctorService.getAllTargetAudiences());
        return "index";
    }
}
