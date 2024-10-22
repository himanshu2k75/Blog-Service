package com.codewithhims.blog_app_apis.payloads;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {


    private Integer categoryID;
    private String  categoryTitle;
    private String  categoryDescription;

}
