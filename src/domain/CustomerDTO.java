package domain;

import lombok.Data;

public @Data class CustomerDTO {
	private String customerId,customerName,password,address,
	city,postalCode,ssn;
}
