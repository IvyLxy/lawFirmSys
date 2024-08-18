package com.ychs.lawfirmsys.mapper;

import com.ychs.lawfirmsys.bean.ContractCancel;

import java.util.List;

public interface ContractCancelMapper {
    int addCancelContract(ContractCancel contractCancel);
    // 查询注销合同
    List<ContractCancel> getCancelContractByConditions(ContractCancel contractCancel);
}
