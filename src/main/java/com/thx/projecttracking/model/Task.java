package com.thx.projecttracking.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.thx.projecttracking.enums.PriorityUnit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "person_responsible")
    private String person_responsible;

    @Column(name = "status")
    private String status;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "date_due")
    private LocalDate date_due;

    @Enumerated(EnumType.STRING)
    @Column(name = "priority")
    private PriorityUnit priority;
}
