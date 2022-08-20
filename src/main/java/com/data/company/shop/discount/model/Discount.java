package com.data.company.shop.discount.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
public class Discount {

	private UUID id;
	private String code;
	private int percent;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate validUntil;
	private boolean forAllItems;
	private List<UUID> itemIds;
}
