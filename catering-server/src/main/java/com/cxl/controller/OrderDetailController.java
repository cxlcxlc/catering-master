package com.cxl.controller;

import com.cxl.entity.OrderDetail;
import com.cxl.service.OrderDetailService;
import com.cxl.utils.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orderDetail")
public class OrderDetailController extends BaseController<OrderDetailService, OrderDetail> {
}
