package com.cxl.dto;

import com.cxl.entity.SetMeal;
import com.cxl.entity.SetMealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetMealDto extends SetMeal {

    private List<SetMealDish> setMealDishes;

    private String categoryName;
}
