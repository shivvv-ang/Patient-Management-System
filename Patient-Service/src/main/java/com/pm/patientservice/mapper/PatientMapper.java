package com.pm.patientservice.mapper;
import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.model.Patient;
import java.time.LocalDate;

public class PatientMapper {

    public static PatientResponseDTO toDto(Patient p){
        PatientResponseDTO dto = new PatientResponseDTO();

        dto.setId(p.getId().toString());
        dto.setName(p.getName());
        dto.setAddress(p.getAddress());
        dto.setEmail(p.getEmail());
        dto.setDateOfBirth(p.getDateOfBirth().toString());

        return dto;
    }

    public static Patient toModel(PatientRequestDTO dto){

        Patient model = new Patient();

        model.setName(dto.getName());
        model.setAddress(dto.getAddress());
        model.setEmail(dto.getEmail());
        model.setDateOfBirth(LocalDate.parse(dto.getDateOfBirth()));
        model.setRegisteredDate(String.valueOf(LocalDate.parse(dto.getRegisteredDate())));

        return model;
    }

}
