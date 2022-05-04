package com.reecelu.pmsserver.service.impl;

import com.reecelu.pmsserver.controller.DTO.ProprietorRegisterDTO;
import com.reecelu.pmsserver.dao.LoginDao;
import com.reecelu.pmsserver.entity.PropertyManager;
import com.reecelu.pmsserver.entity.Proprietor;
import com.reecelu.pmsserver.entity.SMS;
import com.reecelu.pmsserver.service.LoginService;
import com.reecelu.pmsserver.utils.SendSmsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;

@Service
public class LoginServiceImpl implements LoginService {

    //使用LoginDao对象封装的数据库查询方法进行查询
    @Autowired
    LoginDao loginDao;

    //物业登陆校验函数,被DTO层调用，传入参数userName和password
    @Override
    public PropertyManager getPropertyManager(String userName, String password) {
        //创建PropertyManager对象List存放LoginDao层数据库查询结果
        List<PropertyManager> propertyManager = loginDao.loginForPropertyManagement(userName, password);
        //若List为空，则说明数据库查询无果，返回空；反之返回第一条数据；
        if (propertyManager.size() == 0) {
            return null;
        } else {
            return propertyManager.get(0);
        }
    }

    @Override
    public Proprietor getProprietor(String userName, String password){
        //创建PropertyManager对象List存放LoginDao层数据库查询结果
        List<Proprietor> Proprietor = loginDao.loginForProprietor(userName, password);
        //若List为空，则说明数据库查询无果，返回空；反之返回第一条数据；
        if (Proprietor.size() == 0) {
            return null;
        } else {
            return Proprietor.get(0);
        }
    }

    @Override
    public String proprietorRegisterSMS(String phoneNumber){

        String randomByNum = getSixBitRandom();

        if(loginDao.whetherRegistered(phoneNumber)==1){
            return "2";//手机号已被注册
        }else if( loginDao.UpdateCode(phoneNumber,randomByNum)==0){
          loginDao.newPhone(phoneNumber,randomByNum);
        }

        int i = SendSmsUtil.sendShortMessageLogin(phoneNumber, randomByNum);

        if (i != 0) {
            return "1";//验证码发送失败
        }
        return "0";//成功
    }


    private static final DecimalFormat sixdf = new DecimalFormat("000000");
    private static final Random random = new Random();
    //生成6位随机数
    public static String getSixBitRandom() {
        return sixdf.format(random.nextInt(1000000));
    }



    @Override
    public boolean proprietorRegister(ProprietorRegisterDTO proprietorRegisterDTO){

        String phone = proprietorRegisterDTO.getPhone();
        String code = proprietorRegisterDTO.getCode();

        List<SMS> checkSMS  = loginDao.getCode(phone);

        if(code.equals(checkSMS.get(0).getCode())==false){
            return false;
        }

         String userName = proprietorRegisterDTO.getUserName();
         String password = proprietorRegisterDTO.getPassword();
         String name = proprietorRegisterDTO.getName();
         String title = proprietorRegisterDTO.getTitle();
         String email = proprietorRegisterDTO.getEmail();
         String weChat = proprietorRegisterDTO.getWeChat();
         String building = proprietorRegisterDTO.getBuilding();
         String door = proprietorRegisterDTO.getDoor();
         String roleInFamily = proprietorRegisterDTO.getRoleInFamily();

         if(loginDao.newProprietor(userName,password,name,title,email,phone,weChat,building,door,roleInFamily)==1){
             return true;
         }else{
             return false;
         }

    }

}
