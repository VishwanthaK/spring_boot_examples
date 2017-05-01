package com.vacker.example.multiple_db.domain.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.vacker.example.multiple_db.domain.BaseModel;

@Entity
@Table(name = "primary_table1")
public class PrimaryTable1 extends BaseModel {
	
	private static final long serialVersionUID = 790783626359984900L;
	private String firstname;
	private String lastname;

    @Column(name = "firstname", length = 50)
    @NotNull
    @Size(min = 4, max = 50)
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Column(name = "lastname", length = 50)
    @NotNull
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}