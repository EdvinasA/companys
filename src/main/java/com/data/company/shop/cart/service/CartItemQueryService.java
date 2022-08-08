package com.data.company.shop.cart.service;

import com.data.company.shop.cart.model.Cart;
import com.data.company.shop.cart.model.CartItem;
import com.data.company.shop.cart.repository.CartItemQueryRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CartItemQueryService {

  private final CartItemQueryRepository queryRepository;

  public List<CartItem> findCartItems(Cart cart) {
    return queryRepository.findCartItemsForCart(cart);
  }
}
