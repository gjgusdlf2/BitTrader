package domain;

import lombok.Data;

public @Data class EmployeeDTO {
	private String EmployeeId,Manager,Name,BirthDate,Photo,Notes;
}
