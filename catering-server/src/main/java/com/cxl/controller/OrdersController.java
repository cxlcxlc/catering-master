package com.cxl.controller;

import com.cxl.entity.Orders;
import com.cxl.service.OrdersService;
import com.cxl.utils.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrdersController extends BaseController<OrdersService, Orders> {
}
