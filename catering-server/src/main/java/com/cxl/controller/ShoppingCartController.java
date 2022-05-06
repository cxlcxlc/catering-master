package com.cxl.controller;

import com.cxl.entity.ShoppingCart;
import com.cxl.service.ShoppingCartService;
import com.cxl.utils.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController extends BaseController<ShoppingCartService, ShoppingCart> {
}
