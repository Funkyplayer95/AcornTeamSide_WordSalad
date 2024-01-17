package com.wordsalad.service;

import com.wordsalad.dto.AdminDto;
import com.wordsalad.entity.UserInfo;
import com.wordsalad.repository.AdminInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AdminInfoService {

    private final AdminInfoRepository adminInfoRepository;

    public List<AdminDto> getUserList(String id) {
        List<UserInfo> userlist = adminInfoRepository.findAll();
        List<AdminDto> adminDtoAll = new ArrayList<AdminDto>();

        for (UserInfo user : userlist) {
            AdminDto adminDto = new AdminDto(
                    user.getId(),
                    user.getNickname(),
                    user.getState());
            adminDtoAll.add(adminDto);
        }
        return adminDtoAll;
    }

    public void updateState(String id, String changeState){

        UserInfo userInfo = adminInfoRepository.findById(id).orElse(null);

        if(userInfo != null){
            userInfo.setState(changeState);
            userInfo.setId(userInfo.getId());
            userInfo.setNickname(userInfo.getNickname());

            adminInfoRepository.save(userInfo);
        }

    }

}
