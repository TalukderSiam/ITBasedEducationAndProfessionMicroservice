package com.ChatMicroservice.entity.CompettiveProgramming;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime creationDate;
    private LocalDateTime updatedDate;
    private String remarks;
    private String status;
    private String userId;
    private String topicName;
    private String topicDescribtion;
    private String featureName;
    private String semester;

    // When need bidirection

    // @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
    //
    // private List<Problem> problems = new ArrayList<>();

    // @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
    //
    // private List<Contest> contests = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id")
    private List<Problem> problems = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id")
    private List<Contest> contests = new ArrayList<>();

}
