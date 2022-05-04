package com.reecelu.pmsserver.utils;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import org.json.JSONException;


import java.io.IOException;


public class SendSmsUtil {

    private static int SDK_APP_ID = 1400672676;
    private static String SDK_APP_KEY = "1e005df63655b70538735e7ad2ae1e36";
    private static int LOGIN_ID = 1391191;

    public static int sendShortMessageLogin(String phoneNumber, String randomNumber) {
        //拼接的参数，根据短信模板
        String[] params = new String[1];
        params[0]=randomNumber;

        //签名内容，这里不是ID了
        String sing = "陆宇文的个人主页";
        SmsSingleSender sender = new SmsSingleSender(SDK_APP_ID, SDK_APP_KEY);
        SmsSingleSenderResult result=new SmsSingleSenderResult();
        try {
            result = sender.sendWithParam("86", phoneNumber,1391191, params,
                    sing, "", "");
            System.out.println(result);//查看是否出错
            return 0;
        } catch (JSONException | IOException | com.github.qcloudsms.httpclient.HTTPException e) {
            e.printStackTrace();
        }
        return result.result;
    }


}
