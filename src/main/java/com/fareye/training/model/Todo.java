package com.fareye.training.model;

import com.fareye.training.validations.Duplicates;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.Date;

@Getter @Setter @NoArgsConstructor @Duplicates
public class Todo {
//    int todo_id;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date dueDate;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date createdDate;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date modifiedDate;

    private String body;

    private String title;

    private String status;

    private int user_id;
}