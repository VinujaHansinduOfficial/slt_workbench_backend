package com.example.backend.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "WORKFLOW")
@Getter
@Setter
public class Workflow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "form_id", nullable = false)
    private Long formId;

    @Column(name = "level1")
    private String level1;

    private String Step1;

    @Column(name = "level1_action")
    private String level1Action;

    @Column(name = "level1_action_type")
    private String level1ActionType;

    @Column(name = "level2")
    private String level2;

    private String Step2;

    @Column(name = "level2_action")
    private String level2Action;

    @Column(name = "level2_action_type")
    private String level2ActionType;

    @Column(name = "level3")
    private String level3;

    private String Step3;

    @Column(name = "level3_action")
    private String level3Action;

    @Column(name = "level3_action_type")
    private String level3ActionType;

    @Column(name = "level4")
    private String level4;

    private String Step4;

    @Column(name = "level4_action")
    private String level4Action;

    @Column(name = "level4_action_type")
    private String level4ActionType;

    @Column(name = "level5")
    private String level5;

    private String Step5;

    @Column(name = "level5_action")
    private String level5Action;

    @Column(name = "level5_action_type")
    private String level5ActionType;

    @Column(name = "level6")
    private String level6;

    private String Step6;

    @Column(name = "level6_action")
    private String level6Action;

    @Column(name = "level6_action_type")
    private String level6ActionType;

    @Column(name = "upto_1")
    private String upto1;

    @Column(name = "upto_2")
    private String upto2;

    @Column(name = "upto_3")
    private String upto3;

    @Column(name = "upto_4")
    private String upto4;

    @Column(name = "upto_5")
    private String upto5;

    @Column(name = "upto_6")
    private String upto6;
}
