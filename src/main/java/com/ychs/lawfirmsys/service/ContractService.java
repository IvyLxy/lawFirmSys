package com.ychs.lawfirmsys.service;

import com.ychs.lawfirmsys.bean.Contract;
import com.ychs.lawfirmsys.bean.ContractCancel;

import java.util.List;

public interface ContractService {
    // 根据条件查询合同
    List<Contract> getContractByConditions(Contract contract);
    // 添加合同
    int addContract(Contract contract);
    // 注销合同
    int cancelContract(ContractCancel contractCancel);
    // 查询注销的合同
    List<ContractCancel> getCancelContractByConditions(ContractCancel contractCancel);
}
