package com.data.company.shop.products.repository.entity;

import com.data.company.shop.orders.repository.entities.OrderedItemsEntity;
import com.data.company.shop.products.model.Category;
import com.data.company.shop.products.model.SubCategory;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
	@Enumerated(EnumType.STRING)
	private Category category;

	@Column(name = "sub_category")
	@Enumerated(EnumType.STRING)
	private SubCategory subCategory;

	@Column(name = "stripe_product_id")
	private String stripeProductId;

	@Column(name = "stripe_price_id")
	private String stripePriceId;

	@OneToOne(mappedBy = "product", cascade = CascadeType.ALL,
			fetch = FetchType.LAZY, optional = false)
	private OrderedItemsEntity orderedItems;
}
