package com.ychs.lawfirmsys.service;

import com.ychs.lawfirmsys.bean.Seal;

import java.util.List;

public interface SealService {
    List<Seal> getSealByCondition(Seal seal);

    int addSeal(Seal seal);
}
