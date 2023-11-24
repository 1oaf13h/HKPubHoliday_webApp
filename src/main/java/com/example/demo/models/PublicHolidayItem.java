package com.example.demo.models;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;


@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@Entity
@Table(name = "publicHoliday_item")  //Due to the default name strategy is camel-case, actual table should be "public_holiday_item"
public class PublicHolidayItem implements Serializable {
	
	@Id
	@Column(name="uid")
	private String uid;		// primary key
	@Column(name="dtstart")
	private LocalDate dtstart;
	@Column(name="dtend")
	private LocalDate dtend;
	@Column(name="summary")
	private String summary;
	
	
	//temporary override toString for logging 	
	@Override
	public String toString() {
		return String.format(
				"PublicHoliday_Item{uid='%s', dtstart='%s', dtend='%s', summary='%s'}", 
				uid, dtstart, dtend, summary);
	}

}
