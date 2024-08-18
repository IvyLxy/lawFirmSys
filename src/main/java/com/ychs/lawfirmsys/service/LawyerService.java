package com.ychs.lawfirmsys.service;

import com.ychs.lawfirmsys.bean.Awards;
import com.ychs.lawfirmsys.bean.Lawyer;
import com.ychs.lawfirmsys.bean.Punishment;
import com.ychs.lawfirmsys.dto.lawyer.LawyerSelfInfoDto;

import java.util.List;
import java.util.Map;

public interface LawyerService {
    List<Lawyer> getLawyersByCondition(Lawyer lawyer);

    int editLawyer(Lawyer lawyer);

    int addLawyer(Lawyer lawyer);
    // 根据真实姓名查询律师信息
    Lawyer getSelfInfo(String realname);

    // 查询所有的信息
    Map<String, List<?>> getSelfInfoV2(LawyerSelfInfoDto selfInfoDto);
}
