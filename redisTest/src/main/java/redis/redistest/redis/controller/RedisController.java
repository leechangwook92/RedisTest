package redis.redistest.redis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class RedisController {

    private final RedisService redisService;

    @PostMapping("/redis")
    public ResponseDto<?> create(@RequestBody RedisRequestDto redisRequestDto){
        return redisService.create(redisRequestDto);
    }

    @GetMapping("/redis")
    public ResponseDto<?> create(@RequestParam String key){
        return redisService.getRedisValue(key);
    }

    @PutMapping("/redis")
    public ResponseDto<?> update(@RequestBody RedisRequestDto redisRequestDto) {
        return redisService.update(redisRequestDto);
    }

    @DeleteMapping("/redis")
    public ResponseDto<?> delete(@RequestBody RedisRequestDto redisRequestDto) {
        return redisService.delete(redisRequestDto.getKey());
    }

}
