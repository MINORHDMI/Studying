package org.example.mapper;

/*
 * @Author: ZHOUPENG
 * @Date: 2020.11.22 12:32
 */

import org.example.entity.AbnormalResignation;

import java.util.List;

public interface AbnormalResignationMapper {
    public  List<AbnormalResignation> findAll();

    public void insertAbnormalResignation(AbnormalResignation abnormalResignation);

    void deleteAbnormalResignation(int i);

    void updateAbnormalResignation(AbnormalResignation abnormalResignation);
}
