package redis.redistest.redis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisService {

    private final int LIMIT_TIME = 3*60;

    private final StringRedisTemplate stringRedisTemplate;

    public ResponseDto<?> create(RedisRequestDto redisRequestDto) {
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        stringStringValueOperations.set(redisRequestDto.getKey(), redisRequestDto.getValue(),LIMIT_TIME);

        return ResponseDto.success("good");
    }

    public ResponseDto<?> getRedisValue(String key) {
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        String value = stringStringValueOperations.get(key);
        return ResponseDto.success(value);
    }
    
    public ResponseDto<?> update(RedisRequestDto redisRequestDto) {
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        stringStringValueOperations.getAndSet(redisRequestDto.getKey(), redisRequestDto.getValue());
        return ResponseDto.success("update is good");
    }

    public ResponseDto<?> delete(String key) {
        stringRedisTemplate.delete(key);
        return ResponseDto.success("delete ok");
    }
}
