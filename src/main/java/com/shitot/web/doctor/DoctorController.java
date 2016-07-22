package com.shitot.web.doctor;

import com.shitot.model.Doctor;
import com.shitot.model.TargetAudience;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * Created by Next on 21.07.2016.
 */
@Controller
@RequestMapping(value = "/doctors")
public class DoctorController extends AbstractDoctorController {

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String editForCreate(Model model) {
        fillListsAttributes(model);
        model.addAttribute("doctor", new Doctor());
        model.addAttribute("page", "doctorEdit");
        return "index";
    }

    private void fillListsAttributes(Model model) {
        model.addAttribute("scpecialtyList", service.getAllSpecialties());
        model.addAttribute("expertList", service.getAllExperiences());
        model.addAttribute("certificateList", service.getAllCertificates());
        model.addAttribute("targetAudienceList", TargetAudience.values());
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String editForUpdate(HttpServletRequest request, Model model) {
        fillListsAttributes(model);
        model.addAttribute("doctor", super.get(getId(request)));
        model.addAttribute("page", "doctorEdit");
        return "index";
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.valueOf(paramId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String updateOrCreate(HttpServletRequest request) {
        String id = request.getParameter("id");
        int doctorId = id.isEmpty() ? null : Integer.valueOf(id);
        String name = request.getParameter("name");
        String certificate = request.getParameter("certificate");
        String comments = request.getParameter("comments");
        String email = request.getParameter("email");
        String[] expertIn = request.getParameterValues("expertIn");
        String lections = request.getParameter("lections");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String preferential = request.getParameter("preferential");
        String specialty1 = request.getParameter("specialty1");
        String specialty2 = request.getParameter("specialty2");
        String[] targetAudiences = request.getParameterValues("target");
        String telAdditional = request.getParameter("telAdditional");
        String telNumber = request.getParameter("telNumber");

//        Doctor doctor = new Doctor(doctorId,name);
        return "redirect:/doctors";
    }
}
