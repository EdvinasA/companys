package com.data.company.shop.viewedItems.repository.entity;

import com.data.company.shop.products.model.Category;
import com.data.company.shop.products.model.SubCategory;
import com.data.company.shop.products.repository.entity.ProductEntity;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "viewed_item")
@NoArgsConstructor
@AllArgsConstructor
public class ViewedItemEntity {

	@Id
	private UUID id;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id")
	private ProductEntity product;

	@Column(name = "user_id")
	private UUID userId;
}
