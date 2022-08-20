package com.data.company.user.repository.converter;

import com.data.company.user.model.DeliveryInformation;
import com.data.company.user.repository.entity.DeliveryInformationEntity;
import org.springframework.stereotype.Component;

@Component
public class DeliveryInformationConverter {

	public DeliveryInformationEntity convertToEntity(DeliveryInformation input) {
		return new DeliveryInformationEntity()
				.setFirstName(input.getFirstName())
				.setLastName(input.getLastName())
				.setPhoneNumber(input.getPhoneNumber())
				.setAddress(input.getAddress())
				.setCity(input.getCity())
				.setPostalCode(input.getPostalCode())
				.setCompanyCode(input.getCompanyCode())
				.setCompanyName(input.getCompanyName())
				.setCompanyPVMCode(input.getCompanyPVMCode())
				.setCompanyAddress(input.getCompanyAddress());
	}

	public DeliveryInformation convertFromEntity(DeliveryInformationEntity input) {
		return new DeliveryInformation()
				.setId(input.getId())
				.setFirstName(input.getFirstName())
				.setLastName(input.getLastName())
				.setPhoneNumber(input.getPhoneNumber())
				.setAddress(input.getAddress())
				.setCity(input.getCity())
				.setPostalCode(input.getPostalCode())
				.setCompanyCode(input.getCompanyCode())
				.setCompanyName(input.getCompanyName())
				.setCompanyPVMCode(input.getCompanyPVMCode())
				.setCompanyAddress(input.getCompanyAddress());
	}
}
