package com.data.company.shop.cart.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
public class Cart {

	private UUID id;
	private List<CartItem> cartItems;
	private LocalDateTime purchaseDate;
	private UUID userId;
	private CartStatus status;

}
