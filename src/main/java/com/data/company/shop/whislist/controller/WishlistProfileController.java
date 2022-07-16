package com.data.company.shop.whislist.controller;

import com.data.company.shop.whislist.model.WishlistProfile;
import com.data.company.shop.whislist.model.WishlistProfileInput;
import com.data.company.shop.whislist.service.WishlistProfileCommandService;
import com.data.company.shop.whislist.service.WishlistProfileQueryService;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wishlist")
@AllArgsConstructor
@Slf4j
public class WishlistProfileController {

  private final WishlistProfileCommandService commandService;
  private final WishlistProfileQueryService queryService;

  @PostMapping("{userId}")
  public ResponseEntity<Void> createWishlistProfile(@RequestBody WishlistProfileInput input,
                                                    @PathVariable("userId") UUID userId) {
    log.info("Received wishlist profile name: {}", input.getName());

    commandService.createWishlistProfile(input, userId);
    return ResponseEntity.ok(null);
  }

  @GetMapping("{userId}")
  public ResponseEntity<List<WishlistProfile>> getWishlistProfilesByUserId(@PathVariable("userId") UUID userId) {
    log.info("Retrieving wishlist profiles for user id: {}", userId);

    List<WishlistProfile> result = queryService.findProfilesByUserId(userId);
    log.info("Retrieved a list of profiles: [Size: {}]", result.size());

    return ResponseEntity.ok(result);
  }
}
