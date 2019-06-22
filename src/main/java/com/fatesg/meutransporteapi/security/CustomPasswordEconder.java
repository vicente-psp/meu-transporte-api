package com.fatesg.meutransporteapi.security;

import com.fatesg.meutransporteapi.utils.hash.HashUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomPasswordEconder implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        String hash = HashUtil.getSecureHash(charSequence.toString());
        return hash;
    }

    @Override
    public boolean matches(CharSequence charSequence, String encodePassword) {
        String hash = HashUtil.getSecureHash(charSequence.toString());
        return hash.equals(encodePassword);
    }
}
