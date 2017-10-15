package org.mlzw.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

@Component
public class RedisCache {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	
	public void set (final String key, final Object value) {
		redisTemplate.execute(new RedisCallback<Object>() {
			@SuppressWarnings("unchecked")
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				connection.set(redisTemplate.getStringSerializer().serialize(key), 
						((RedisSerializer<Object>) redisTemplate.getDefaultSerializer()).serialize(value));
				return null;
			}
		});
	}
	
	
	
	public <T> T get (final String key) {
		return redisTemplate.execute(new RedisCallback<T>() {
			@SuppressWarnings("unchecked")
			public T doInRedis(RedisConnection connection) throws DataAccessException {
				byte[] bs = connection.get(redisTemplate.getStringSerializer().serialize(key));
				return (T)redisTemplate.getDefaultSerializer().deserialize(bs);
			}
		});
	}
}
