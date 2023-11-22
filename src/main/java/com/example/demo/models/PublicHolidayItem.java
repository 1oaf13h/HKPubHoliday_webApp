package com.example.demo.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;


@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PRIVATE)
@Entity
@Table(name = "publicHoliday_item")
public class PublicHolidayItem implements Serializable {
	
	@Id
	@Column(name="uid")
	private String uid;		// primary key
	@Column(name="dtstart")
	private String dtstart;
	@Column(name="dtend")
	private String dtend;
	@Column(name="summary")
	private String summary;
	
	
	//temporary override toString for logging 	
	@Override
	public String toString() {
		return String.format(
				"PublicHoliday_Item{uid=%s, dtstart='%s', dtend='%s', summary='%s'}", 
				uid, dtstart, dtend, summary);
	}

}
