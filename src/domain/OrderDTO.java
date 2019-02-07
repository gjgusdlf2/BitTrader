package domain;

import lombok.Data;

@Data
public class OrderDTO {
	private String orderId,orderDate,shipperId,customerId,employeeId;
}
