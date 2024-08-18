package com.ychs.lawfirmsys.mapper;

import com.ychs.lawfirmsys.bean.Seal;

import java.util.List;

public interface SealMapper {

    List<Seal> getSealByCondition(Seal seal);

    int addSeal(Seal seal);
}
