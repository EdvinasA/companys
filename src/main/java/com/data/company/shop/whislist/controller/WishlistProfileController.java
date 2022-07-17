package com.data.company.shop.whislist.controller;

import com.data.company.shop.whislist.model.WishlistItem;
import com.data.company.shop.whislist.model.WishlistProfile;
import com.data.company.shop.whislist.model.WishlistDeleteInput;
import com.data.company.shop.whislist.model.WishlistProfileInput;
import com.data.company.shop.whislist.service.WishlistItemCommandService;
import com.data.company.shop.whislist.service.WishlistItemQueryService;
import com.data.company.shop.whislist.service.WishlistProfileCommandService;
import com.data.company.shop.whislist.service.WishlistProfileQueryService;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wishlist/{userId}")
@AllArgsConstructor
@Slf4j
public class WishlistProfileController {

  private final WishlistProfileCommandService commandService;
  private final WishlistProfileQueryService queryService;
  private final WishlistItemCommandService wishlistItemCommandService;
  private final WishlistItemQueryService wishlistItemQueryService;

  @PostMapping
  public ResponseEntity<Void> createWishlistProfile(@RequestBody WishlistProfileInput input,
                                                    @PathVariable("userId") UUID userId) {
    log.info("Received wishlist profile name: {}", input.getName());

    commandService.createWishlistProfile(input, userId);
    return ResponseEntity.ok(null);
  }

  @GetMapping
  public ResponseEntity<List<WishlistProfile>> getWishlistProfilesByUserId(@PathVariable("userId") UUID userId) {
    log.info("Retrieving wishlist profiles for user id: {}", userId);

    List<WishlistProfile> result = queryService.findProfilesByUserId(userId);
    log.info("Retrieved a list of profiles: [Size: {}]", result.size());

    return ResponseEntity.ok(result);
  }

  @DeleteMapping
  public ResponseEntity<Void> deleteWishlistProfile(@RequestBody WishlistDeleteInput input,
                                                    @PathVariable("userId") UUID userId) {
    log.info("Deleting wishlist profile with id: {}. Requested by user with id: {}", input.getId(), userId);
    commandService.deleteWishlistProfile(input.getId());

    return ResponseEntity.ok(null);
  }

  @PostMapping("/item")
  public ResponseEntity<Void> addItemToWishlistProfile(@RequestBody WishlistItem input,
                                                       @PathVariable("userId") UUID userId) {
    log.info("Adding item to wishlist profile: {} for userId {}", input, userId);

    wishlistItemCommandService.addItemToWishlistProfile(input);
    return ResponseEntity.ok(null);
  }

  @GetMapping("/item/{profileId}")
  public ResponseEntity<List<WishlistItem>> getItemsForWishlistProfile(@PathVariable("profileId") UUID profileId,
                                                                       @PathVariable("userId") UUID userId) {
    log.info("Getting items of wishlist profile: {} for userId {}", profileId, userId);

    List<WishlistItem> result = wishlistItemQueryService.getListOfWishlistItems(profileId);
    log.info("Retrieved list of items: [Size: {}]", result.size());

    return ResponseEntity.ok(result);
  }

  @DeleteMapping("/item")
  public ResponseEntity<Void> deleteItemFromWishlist(@RequestBody List<WishlistItem> items,
                                                     @PathVariable String userId) {
    log.info("Removing from wishlist items: {}. Requested by user with id: {}", items, userId);
    wishlistItemCommandService.deleteItemsFromWishlist(items);

    return ResponseEntity.ok(null);
  }
}
