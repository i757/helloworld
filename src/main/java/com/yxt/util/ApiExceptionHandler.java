package com.yxt.util;

import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

/**
 * @author luoxiaozhu
 * @date 2018-1-31-0031 17:39
 */
@ControllerAdvice
public class ApiExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApiExceptionHandler.class);
    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity<String> apiExceptionHandler(ApiException e) {
        String key = e.getErrorKey();
        String msg = messageSource.getMessage(key, e.getValues(), null);
        return generateResponse(key,msg);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<String> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        String key;
        if(errors == null || errors.isEmpty()){
            key = KeyConstants.GLOBAL_ERROR;
        }else {
            key = errors.get(0).getDefaultMessage();
        }
        String msg = messageSource.getMessage(key, null, null);
        return generateResponse(key,msg);
    }

    public static ResponseEntity<String> generateResponse(String key,String msg){
        String[] msgs = msg.split(";");
        if (msgs.length < 2) {
            msgs = new String[]{"400", "Unknow error!"};
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key", key);
        jsonObject.put("message", msgs[1]);
        JSONObject error = new JSONObject();
        error.put("error", jsonObject);
        return new ResponseEntity<String>(error.toString(), HttpStatus.valueOf(str2Int(msgs[0], 400)));
    }

    public static int str2Int(String str, int nullVal) {
        int result = nullVal;
        try {
            if (str != null && StringUtils.isNumeric(str)) {
                result = Integer.parseInt(str);
            }
        } catch (Exception e) {
            LOGGER.info("Integer.parseInt() str is not a number:" + str);
        }
        return result;
    }
}
