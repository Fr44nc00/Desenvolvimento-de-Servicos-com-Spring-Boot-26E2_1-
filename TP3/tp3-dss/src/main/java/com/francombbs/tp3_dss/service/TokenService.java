package com.francombbs.tp3_dss.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class TokenService {

    private final RedisTemplate<String, String> redisTemplate;

    public TokenService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public String gerarToken(Long alunoId) {
        String token = UUID.randomUUID().toString();
        redisTemplate.opsForValue().set("token:" + token, alunoId.toString(), 5, TimeUnit.MINUTES);
        return token;
    }

    public boolean validarToken(String token) {
        return redisTemplate.hasKey("token:" + token);
    }
}
