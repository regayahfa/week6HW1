package com.example.week6hw1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(min = 4 ,max = 9)
    @Column(columnDefinition = "varchar(20)")
    private String title;
    @Column(columnDefinition = "varchar(200)")
    private String body;
@Column(insertable = false, updatable = false)
private Integer userId;

@ManyToOne
    @JoinColumn(name = "userId",referencedColumnName = "id")
@JsonIgnore
    private User user;

}
