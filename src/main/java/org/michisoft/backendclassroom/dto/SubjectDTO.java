package org.michisoft.backendclassroom.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SubjectDTO {

    @NotBlank(message = "name field must not be blank")
    private String name;

    @NotBlank(message = "code field must not be blank")
    private String code;

}
