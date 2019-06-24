package com.guilder.hospital.bootstrap;

import com.guilder.hospital.models.Doctor;
import com.guilder.hospital.models.Specialty;
import com.guilder.hospital.repositories.DoctorRepository;
import com.guilder.hospital.repositories.SpecialtyRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile({"dev", "prod"})
public class MysqlBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private DoctorRepository doctorRepository;
    private SpecialtyRepository specialtyRepository;

    public MysqlBootstrap(DoctorRepository doctorRepository, SpecialtyRepository specialtyRepository) {
        this.doctorRepository = doctorRepository;
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadData();
    }

    private void loadData(){


        if (specialtyRepository.count() == 0L && doctorRepository.count() == 0L){
            Specialty specialty = new Specialty();
            specialty.setName("Cardiologia");
            specialty.setDescription("Especialidad que se ocupa de problemas cardiacos");
            specialtyRepository.save(specialty);
            Doctor doctor = new Doctor();
            doctor.setFistName("Nick");
            doctor.setLastName("Riviera");
            doctor.setSpecialty(specialty);
            doctor.setEnrollment("123456");
            doctorRepository.save(doctor);
        }


    }


}

