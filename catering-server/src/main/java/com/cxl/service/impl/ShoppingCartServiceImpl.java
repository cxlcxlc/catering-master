package com.cxl.service.impl;

import com.cxl.dao.ShoppingCartDao;
import com.cxl.entity.ShoppingCart;
import com.cxl.service.ShoppingCartService;
import com.cxl.utils.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ShoppingCartServiceImpl extends BaseServiceImpl<ShoppingCartDao, ShoppingCart> implements ShoppingCartService {
}
