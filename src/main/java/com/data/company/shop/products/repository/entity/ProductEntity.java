package com.data.company.shop.products.repository.entity;

import com.data.company.shop.shared.Category;
import com.data.company.shop.shared.ComputerAndOfficeCategory;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {

	@Id
	private UUID id;

	@Column(name = "name")
	private String name;

	@Column(name = "picture")
	private String picture;

	@Column(name = "code")
	private String code;

	@Column(name = "price")
	private double price;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "type")
	private String type;

	@Column(name = "category")
	private Category category;

	@Column(name = "stripe_product_id")
	private String stripeProductId;
}
