package com.edupro.EducationWeb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeviceConfiguration {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "RAM")
    private String ram;
    @Column(name = "ssd")
    private String ssd;
    @Column(name = "BatteryBackUp")
    private String batteryBackUp;
    @Column(name = "ProcessorName")
    private String processorName;
    @Column(name = "Genaration")
    private String genaration;
    @Column(name = "ProcessorVersion")
    private String processorVersion;
    @Column(name = "ExtraSlot")
    private String extraSlot;
    @Column(name = "GrpahicsCard")
    private String grpahicsCard;


}
