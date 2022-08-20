package com.data.company.shop.viewedItems.repository.entity;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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

	@Column(name = "item_id")
	private UUID itemId;

	@Column(name = "item_picture")
	private String itemPicture;

	@Column(name = "item_name")
	private String itemName;

	@Column(name = "item_code")
	private String itemCode;

	@Column(name = "item_price")
	private double itemPrice;

	@Column(name = "delivery")
	private boolean delivery;

	@Column(name = "withdrawal")
	private boolean withdrawal;

	@Column(name = "user_id")
	private UUID userId;
}
