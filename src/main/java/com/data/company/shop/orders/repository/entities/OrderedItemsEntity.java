package com.data.company.shop.orders.repository.entities;

import com.data.company.shop.products.model.Category;
import com.data.company.shop.products.model.SubCategory;
import com.data.company.shop.products.repository.entity.ProductEntity;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "ordered_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderedItemsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//
	@Column(name = "item_id")
	private UUID itemId;

	@Column(name = "picture")
	private String picture;

	@Column(name = "item_name")
	private String itemName;

	@Column(name = "item_code")
	private String itemCode;

	@Column(name = "item_price")
	private double itemPrice;
	//

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private ProductEntity product;

	@Column(name = "item_quantity")
	private Integer itemQuantity;

	@Column(name = "item_insurance")
	private boolean itemInsurance;

	@Column(name = "item_warranty")
	private boolean itemWarranty;

	@ManyToOne(fetch = FetchType.LAZY)
	private OrderEntity order;

	//
	@Column(name = "category")
	@Enumerated(EnumType.STRING)
	private Category category;

	@Column(name = "sub_category")
	@Enumerated(EnumType.STRING)
	private SubCategory subCategory;
	//

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof OrderedItemsEntity))
			return false;
		return id != null && id.equals(((OrderedItemsEntity) o).getId());
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
