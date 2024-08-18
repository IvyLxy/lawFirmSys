package com.ychs.lawfirmsys.mapper;

import com.ychs.lawfirmsys.bean.Contract;
import com.ychs.lawfirmsys.bean.ContractCancel;

import java.util.List;

public interface ContractMapper {
    List<Contract> getContractByConditions(Contract contract);

    int addContract(Contract contract);
    // 合同注销 修改状态
    int modifyContractState(ContractCancel contractCancel);
}
