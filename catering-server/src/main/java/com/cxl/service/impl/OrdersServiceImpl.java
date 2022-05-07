package com.cxl.service.impl;

import com.cxl.dao.OrdersDao;
import com.cxl.entity.Orders;
import com.cxl.service.OrdersService;
import com.cxl.utils.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrdersServiceImpl extends BaseServiceImpl<OrdersDao, Orders> implements OrdersService {
}
