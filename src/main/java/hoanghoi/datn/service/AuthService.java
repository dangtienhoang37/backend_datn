package hoanghoi.datn.service;

import com.nimbusds.jose.JOSEException;
import hoanghoi.datn.dto.request.IntrospectRequest;
import hoanghoi.datn.dto.response.ApiResponse;

import java.text.ParseException;

public interface AuthService {


    ApiResponse introspect(IntrospectRequest introspectRequest) throws JOSEException, ParseException;
}
