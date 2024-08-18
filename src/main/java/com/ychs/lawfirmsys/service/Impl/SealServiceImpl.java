package com.ychs.lawfirmsys.service.Impl;

import com.ychs.lawfirmsys.bean.Seal;
import com.ychs.lawfirmsys.mapper.SealMapper;
import com.ychs.lawfirmsys.service.SealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lixiaoya
 * @version 1.0
 * @date 2024/7/31
 */
@Service
public class SealServiceImpl implements SealService {
    @Autowired
    private SealMapper sealMapper;

    @Override
    public List<Seal> getSealByCondition(Seal seal) {
        return sealMapper.getSealByCondition(seal);
    }

    @Override
    public int addSeal(Seal seal) {
        return sealMapper.addSeal(seal);
    }
}


