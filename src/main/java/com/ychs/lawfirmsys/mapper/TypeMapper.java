package com.ychs.lawfirmsys.mapper;

import com.ychs.lawfirmsys.bean.Type;

import java.util.List;

public interface TypeMapper {
    /**
     * 查询所有的类型
     * @return 查询到的类型
     */
    List<Type> getAllTypes();
}
