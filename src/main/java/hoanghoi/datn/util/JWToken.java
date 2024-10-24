package hoanghoi.datn.util;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.experimental.NonFinal;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component
public class JWToken {
    @NonFinal
    protected static final String SIGNER_KEY = "Ry5OGtcJ+5dTSUV30C1LMaNew2uOotz0zpaBT/F9DJ5fLbcC5EoYtK/Ldh3H8VZo";

    public String genJWT(String username,String role) throws Exception{
        // Tạo header
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512); // dua vao bien moi truong

        //Tạo payload
        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(username)
                .issuer("hoanghoi")
                .issueTime(new Date())
                .expirationTime(new Date(
                        Instant.now().plus(1, ChronoUnit.HOURS).toEpochMilli()
                ))
                .claim("Role", role)
                .build();

        Payload payload = new Payload(jwtClaimsSet.toJSONObject());
        JWSObject jwsObject = new JWSObject(header,payload);
        jwsObject.sign(new MACSigner(SIGNER_KEY.getBytes()));

        return jwsObject.serialize();
    }
    public boolean verifyToken(String token) throws JOSEException, ParseException {
        JWSVerifier verifier = new MACVerifier(SIGNER_KEY.getBytes());
        SignedJWT signedJWT = SignedJWT.parse(token);
        Date expireTime = signedJWT.getJWTClaimsSet().getExpirationTime();
        return signedJWT.verify(verifier) && expireTime.after(new Date());
    }

}
