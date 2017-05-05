package com.vacker.example.jwt_sample.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

import net.minidev.json.annotate.JsonIgnore;

@MappedSuperclass
public class BaseModel extends BaseObject {
	
	private static final long serialVersionUID = 9006542356747236015L;

	private Long id;
	private Integer recordStatus;
	private LocalDateTime updatedOn;
	
	public BaseModel() {
		this.recordStatus = 1;
		this.updatedOn = LocalDateTime.now();
	}
	
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "record_status")
	public Integer getRecordStatus() {
		return recordStatus;
	}
	public void setRecordStatus(Integer recordStatus) {
		this.recordStatus = recordStatus;
	}
	
	@Column(name = "update_on")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}
	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this,
                ToStringStyle.MULTI_LINE_STYLE);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof BaseModel)) {
            return false;
        }
        BaseModel other = (BaseModel) o;
        if (this.getId() == null) {
            return other.getId() == null;
        }

        if (other.getId() == null) {
            return false;
        }
        return this.getId().equals(other.getId());
    }

    @Override
    public int hashCode() {
        return this.getId() == null ? 0 : this.getId().hashCode();
    }
	
	
}
