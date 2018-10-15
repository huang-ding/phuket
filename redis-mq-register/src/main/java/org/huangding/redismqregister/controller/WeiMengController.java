package org.huangding.redismqregister.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.huangding.redismqregister.util.HttpsUtil;
import org.huangding.redismqregister.util.JsonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangding
 * @description
 * @date 2018/10/8 11:43
 */
@RestController
@RequestMapping("weimeng")
@Slf4j
@Api("测试")
public class WeiMengController {

    //client_id 和 client_secret 是开发者的应用发起微盟Oauth 授权的凭证；
    private static String CLIENT_ID="8799E36C051A9DA84F50F0BFF0BEC122";
    private static String CLIENT_SECRET="C32993061B8FE72B8CDDA84CD110BA43";
    private static String GET_OAUTH2_TOKENURL ="https://dopen.weimob.com/fuwu/b/oauth2/token";

    @ApiOperation("测试")
    @GetMapping("/authorize")
    public JsonResult authorize(@RequestParam(value = "code") String code,
        @RequestParam(value = "state") String state) {
        log.info("code=====================>",code);
        log.info("state===================>",state);

        /**
         * ?code={code}&grant_type=authorization_code&client_id={client_id}&client_secret={client_secret}&redirect_uri={redirect_uri}
         */
        Map<String, String> param = new HashMap<>();
        param.put("code",code);
        param.put("grant_type","authorization_code");
        param.put("client_id",CLIENT_ID);
        param.put("client_secret",GET_OAUTH2_TOKENURL);
        param.put("redirect_uri","");
        //换取access_token
        HttpsUtil.postClient(GET_OAUTH2_TOKENURL,param);

        return JsonResult.SUCCESS();
    }

//    @ApiOperation("测试")
//    @GetMapping("/authorize")
//    public JsonResult token() {
//        return JsonResult.SUCCESS();
//    }

}
