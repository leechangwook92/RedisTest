package redis.redistest.redis.controller;

import lombok.Getter;

@Getter
public class RedisRequestDto {
    private String key;
    private String value;
}
