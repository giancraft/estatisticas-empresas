package com.classes.DTO.dataFormatter;

import java.time.format.DateTimeFormatter;

public class DataFormatter {
	public static DateTimeFormatter formatarData(){
		return DateTimeFormatter.ofPattern("dd/MM/yyyy");
	}
}