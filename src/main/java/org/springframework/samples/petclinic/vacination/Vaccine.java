package org.springframework.samples.petclinic.vacination;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.springframework.samples.petclinic.model.NamedEntity;
import org.springframework.samples.petclinic.pet.PetType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="vaccine_types")
public class Vaccine extends NamedEntity {

    @Column(name = "name", unique = true)
    @NotNull
    @Size(min = 3, max = 50)
    String name;

    @Min(0)
    Double price;

    @ManyToOne
    @NotNull
    @JoinColumn(name="pet_type_id")
    PetType petType;
}
