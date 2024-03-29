package com.guilder.hospital.bootstrap;

import com.guilder.hospital.models.Doctor;
import com.guilder.hospital.models.Specialty;
import com.guilder.hospital.repositories.DoctorRepository;
import com.guilder.hospital.repositories.SpecialtyRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@Profile("default")
public class TestDvBootstrap implements ApplicationListener<ContextRefreshedEvent> {


    private DoctorRepository doctorRepository;
    private SpecialtyRepository specialtyRepository;

    public TestDvBootstrap(DoctorRepository doctorRepository, SpecialtyRepository specialtyRepository) {
        this.doctorRepository = doctorRepository;
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }


    private void initData(){

    }
}
