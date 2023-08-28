package com.doza.cloud.DozaCloud.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;



@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PROTECTED, force=true)
public class Completion {

    @Id
    private final String id;
    private final String name;
    private final Type type;

    public enum Type {
        ENGINE, GEARBOX, BODYTYPE, INTERIOR, PANORAMICROOF
    }
}
