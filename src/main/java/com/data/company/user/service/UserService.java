package com.data.company.user.service;

import com.data.company.exceptions.PasswordNotMatchingException;
import com.data.company.exceptions.RegisteredEmailFoundException;
import com.data.company.exceptions.TokenNotFoundException;
import com.data.company.jwt.JwtTokenGenerator;
import com.data.company.jwt.model.Token;
import com.data.company.jwt.service.TokenQueryService;
import com.data.company.shop.cart.service.CartCommandService;
import com.data.company.shop.whislist.model.WishlistProfileInput;
import com.data.company.shop.whislist.service.WishlistProfileCommandService;
import com.data.company.user.model.SubscriptionDetails;
import com.data.company.user.model.UserLoginInput;
import com.data.company.user.model.UserRegisterInput;
import com.data.company.user.model.User;
import com.data.company.user.model.UserUpdateInput;
import com.data.company.user.repository.SubscriptionDetailsQueryRepository;
import com.data.company.user.repository.UserCommandRepository;
import com.data.company.user.repository.UserQueryRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserService {

	private final UserQueryRepository queryRepository;
	private final TokenQueryService tokenQueryService;
	private final SubscriptionDetailsQueryRepository subscriptionDetailsQueryRepository;
	private final UserCommandRepository commandRepository;

	private final CartCommandService cartCommandService;
	private final WishlistProfileCommandService wishlistProfileCommandService;

	private final JwtTokenGenerator tokenGenerator;
	private final PasswordEncoder passwordEncoder;

	public User login(UserLoginInput userLoginInputBody) {
		User user = checkIfUserLoginIsValid(userLoginInputBody);
		return user
				.setToken(tokenGenerator.generateToken(userLoginInputBody.getEmail()));
	}

	@Transactional
	public User register(UserRegisterInput userRegisterInputBody) {
		String email = userRegisterInputBody.getEmail();

		checkIfEmailExists(email);

		User newUser = new User()
				.setId(UUID.randomUUID())
				.setEmail(email)
				.setName(userRegisterInputBody.getName())
				.setLastName(userRegisterInputBody.getLastName())
				.setPassword(passwordEncoder.encode(userRegisterInputBody.getPassword()))
				.setRegisteredDate(LocalDate.now())
				.setRoles(List.of("USER"));

		SubscriptionDetails subscriptionDetails = buildNewSubscriptionDetails();

		User user = commandRepository.create(newUser, subscriptionDetails);
		user.setToken(tokenGenerator.generateToken(email));
		user.setSubscriptionDetails(subscriptionDetails);

		cartCommandService.createCart(user.getId());
		wishlistProfileCommandService
				.createWishlistProfile(new WishlistProfileInput().setName("Saved items"), user.getId());

		return user;
	}

	private SubscriptionDetails buildNewSubscriptionDetails() {
		LocalDate localDate = LocalDate.now();

		return new SubscriptionDetails()
				.setReceiveEmails(true)
				.setReceiveEmailsDate(localDate)
				.setReceiveEmailsAboutServiceQuality(true)
				.setReceiveEmailsAboutServiceQualityDate(localDate)
				.setReceiveEmailsAboutLookedItems(true)
				.setReceiveEmailsAboutLookedItemsDate(localDate)
				.setReceiveEmailsAboutGivingFeedback(true)
				.setReceiveEmailsAboutGivingFeedbackDate(localDate);
	}

	public User validateToken(String token) {
		Optional<Token> storedTokenOptional = tokenQueryService.findByToken(token);
		Token storedToken = storedTokenOptional.orElseThrow(TokenNotFoundException::new);

		User user = queryRepository.getUserByEmail(storedToken.getEmail());
		user.setSubscriptionDetails(subscriptionDetailsQueryRepository.findByUserId(user.getId()));
		user.setToken(storedToken.getToken());

		return user;
	}

	public User updateUser(UserUpdateInput input) {
		User storedUser = queryRepository.findById(input.getId());
		updateUserFields(storedUser, input);

		commandRepository.update(storedUser);

		return storedUser;
	}

	private void updateUserFields(User user, UserUpdateInput input) {
		Optional.ofNullable(input.getName()).ifPresent(user::setName);
		Optional.ofNullable(input.getLastName()).ifPresent(user::setLastName);
		Optional.ofNullable(input.getPassword()).ifPresent(user::setPassword);
		Optional.ofNullable(input.getSubscriptionDetails()).ifPresent(user::setSubscriptionDetails);
		Optional.ofNullable(input.getRoles()).ifPresent(user::setRoles);
		Optional.ofNullable(input.getDeliveryInformation()).ifPresent(user::setDeliveryInformation);
	}

	private void checkIfEmailExists(String input) {
		if (queryRepository.findUserByEmail(input).getEmail() != null) {
			throw new RegisteredEmailFoundException(String.format("Email %s already in use.", input));
		}
	}

	private User checkIfUserLoginIsValid(UserLoginInput userLoginInput) {
		User user = queryRepository.getUserByEmail(userLoginInput.getEmail());
		user.setSubscriptionDetails(subscriptionDetailsQueryRepository.findByUserId(user.getId()));

		if (userLoginInput.getEmail().equals(user.getEmail()) && passwordEncoder
				.matches(userLoginInput.getPassword(), user.getPassword())) {
			return user;

		} else {
			throw new PasswordNotMatchingException(
					String.format("User with email %s password does not match", userLoginInput.getEmail()));
		}
	}

}
