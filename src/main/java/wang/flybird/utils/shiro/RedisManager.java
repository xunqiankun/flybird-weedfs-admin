package wang.flybird.utils.shiro;

import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Component
public class RedisManager {
	@Value(value = "${spring.redis.host}")
	private String host = "127.0.0.1";
	
	@Value(value = "${spring.redis.port}")
	private int port = 6379;
	
	// 0 - never expire
	@Value(value = "${spring.redis.expire}")
	private int expire = 0;
	
	//timeout for jedis try to connect to redis server, not expire time! In milliseconds
	@Value(value = "${spring.redis.timeout}")
	private int timeout = 0;
	
	@Value(value = "${spring.redis.password}")
	private String password = "";
	
	private static JedisPool jedisPool = null;
	
	public RedisManager(){
		
	}
	
	/**
	 * 初始化方法
	 */
	public void init(){
		if(jedisPool == null){
			if(password != null && !"".equals(password)){
				jedisPool = new JedisPool(new JedisPoolConfig(), host, port, timeout, password);
			}else if(timeout != 0){
				jedisPool = new JedisPool(new JedisPoolConfig(), host, port,timeout);
			}else{
				jedisPool = new JedisPool(new JedisPoolConfig(), host, port);
			}
			
		}
	}
	
	/**
	 * get value from redis
	 * @param key
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public byte[] get(byte[] key){
		byte[] value = null;
		Jedis jedis = jedisPool.getResource();
		try{
			value = jedis.get(key);
		}finally{
			jedisPool.returnResource(jedis);
		}
		return value;
	}
	
	/**
	 * set 
	 * @param key
	 * @param value
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public byte[] set(byte[] key,byte[] value){
		Jedis jedis = jedisPool.getResource();
		try{
			jedis.set(key,value);
			if(this.expire != 0){
				jedis.expire(key, this.expire);
		 	}
		}finally{
			jedisPool.returnResource(jedis);
		}
		return value;
	}
	
	/**
	 * set 
	 * @param key
	 * @param value
	 * @param expire
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public byte[] set(byte[] key,byte[] value,int expire){
		Jedis jedis = jedisPool.getResource();
		try{
			jedis.set(key,value);
			if(expire != 0){
				jedis.expire(key, expire);
		 	}
		}finally{
			jedisPool.returnResource(jedis);
		}
		return value;
	}
	
	/**
	 * del
	 * @param key
	 */
	@SuppressWarnings("deprecation")
	public void del(byte[] key){
		Jedis jedis = jedisPool.getResource();
		try{
			jedis.del(key);
		}finally{
			jedisPool.returnResource(jedis);
		}
	}
	
	/**
	 * flush
	 */
	@SuppressWarnings("deprecation")
	public void flushDB(){
		Jedis jedis = jedisPool.getResource();
		try{
			jedis.flushDB();
		}finally{
			jedisPool.returnResource(jedis);
		}
	}
	
	/**
	 * size
	 */
	@SuppressWarnings("deprecation")
	public Long dbSize(){
		Long dbSize = 0L;
		Jedis jedis = jedisPool.getResource();
		try{
			dbSize = jedis.dbSize();
		}finally{
			jedisPool.returnResource(jedis);
		}
		return dbSize;
	}

	/**
	 * keys
	 * @param regex
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public Set<byte[]> keys(String pattern){
		Set<byte[]> keys = null;
		Jedis jedis = jedisPool.getResource();
		try{
			keys = jedis.keys(pattern.getBytes());
		}finally{
			jedisPool.returnResource(jedis);
		}
		return keys;
	}
	
	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getExpire() {
		return expire;
	}

	public void setExpire(int expire) {
		this.expire = expire;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
