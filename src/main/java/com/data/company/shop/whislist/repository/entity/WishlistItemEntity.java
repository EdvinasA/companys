package com.data.company.shop.whislist.repository.entity;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "wishlist_item")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WishlistItemEntity {

	@Id
	private UUID id;

	@Column(name = "item_id")
	private UUID itemId;

	@Column(name = "item_name")
	private String itemName;

	@Column(name = "item_code")
	private String itemCode;

	@Column(name = "item_picture")
	private String itemPicture;

	@Column(name = "item_price")
	private double itemPrice;

	@Column(name = "wishlist_profile_id")
	private UUID wishListProfileId;

}
