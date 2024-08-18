package com.ychs.lawfirmsys.service.Impl;

import com.ychs.lawfirmsys.bean.Contract;
import com.ychs.lawfirmsys.bean.ContractCancel;
import com.ychs.lawfirmsys.mapper.ContractCancelMapper;
import com.ychs.lawfirmsys.mapper.ContractMapper;
import com.ychs.lawfirmsys.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author lixiaoya
 * @version 1.0
 * @date 2024/7/29
 */
@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractMapper contractMapper;
    @Autowired
    private ContractCancelMapper contractCancelMapper;
    @Override
    public List<Contract> getContractByConditions(Contract contract) {
        return contractMapper.getContractByConditions(contract);
    }

    @Override
    public int addContract(Contract contract) {
        return contractMapper.addContract(contract);
    }

    @Override
    @Transactional
    public int cancelContract(ContractCancel contractCancel) {
        // 获取修改的合同id
        int res = contractMapper.modifyContractState(contractCancel);
        // 注销表添加
        int res2 = contractCancelMapper.addCancelContract(contractCancel);

        return res & res2;
    }

    @Override
    public List<ContractCancel> getCancelContractByConditions(ContractCancel contractCancel) {
        return contractCancelMapper.getCancelContractByConditions(contractCancel);
    }
}


