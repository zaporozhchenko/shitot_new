package com.shitot.web.doctor;

import com.shitot.model.Doctor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Next on 25.07.2016.
 */
@RestController
@RequestMapping("/rest/doctors")
public class DoctorRestController extends AbstractDoctorController {

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Doctor> getAll() {
        return super.getAll();
    }
}
