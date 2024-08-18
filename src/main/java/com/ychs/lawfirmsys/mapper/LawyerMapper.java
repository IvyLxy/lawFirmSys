package com.ychs.lawfirmsys.mapper;

import com.ychs.lawfirmsys.bean.Awards;
import com.ychs.lawfirmsys.bean.Lawyer;
import com.ychs.lawfirmsys.bean.Punishment;
import com.ychs.lawfirmsys.bean.User;
import com.ychs.lawfirmsys.dto.lawyer.LawyerSelfInfoDto;

import java.util.List;

public interface LawyerMapper {
    // 根据相关条件查询
    List<Lawyer> getLawyersByCondition(Lawyer lawyer);
    // 编辑相关信息
    int editLawyer(Lawyer lawyer);
    // 添加
    int addLawyer(Lawyer lawyer);
    // 获取到所有的律师姓名
    List<Lawyer> getAllNames();
    // 根据用户名查询律师的相关信息
    Lawyer getSelfInfo(String realname);

    List<Awards> getAwards(LawyerSelfInfoDto selfInfoDto);

    List<Punishment> getPunishment(LawyerSelfInfoDto selfInfoDto);
}
