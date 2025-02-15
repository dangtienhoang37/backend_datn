package hoanghoi.datn.service.impl;

import com.nimbusds.jose.JOSEException;
import hoanghoi.datn.dto.request.IntrospectRequest;
import hoanghoi.datn.dto.response.ApiResponse;
import hoanghoi.datn.service.AuthService;
import hoanghoi.datn.util.JWToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;


@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private JWToken jwToken;

    @Override
    public ApiResponse introspect(IntrospectRequest introspectRequest) throws JOSEException, ParseException {
        String token = introspectRequest.getToken();
        System.out.println(token);
        boolean isOk = jwToken.verifyToken(token);
        var response = new ApiResponse();
        if(!isOk){

            response.setSucess(false);
            response.setCode(1001);
            response.setData("false");
            System.out.println("loi roi");

            return response;
        }
        response.setSucess(true);
        response.setCode(1000);
        response.setData("ok");
        System.out.println("ok");

        return response;


    }
}
