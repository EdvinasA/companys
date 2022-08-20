package com.data.company.shop.whislist.repository.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "wishlist_profile")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WishlistProfileEntity {

	@Id
	private UUID id;

	@Column(name = "name")
	private String name;

	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "wishlist_profile_id")
	private List<WishlistItemEntity> items = new ArrayList<>();

	@Column(name = "user_id")
	private UUID userId;
}
