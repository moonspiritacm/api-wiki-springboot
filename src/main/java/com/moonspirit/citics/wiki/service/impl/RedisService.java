package com.moonspirit.citics.wiki.service.impl;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public final class RedisService {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	public boolean expire(String key, long time) {
		try {
			if (time > 0) {
				redisTemplate.expire(key, time, TimeUnit.SECONDS);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public long getExpire(String key) {
		return redisTemplate.getExpire(key, TimeUnit.SECONDS);
	}

	public boolean hasKey(String key) {
		try {
			return redisTemplate.hasKey(key);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public void del(String... key) {
		if (key != null && key.length > 0) {
			if (key.length == 1) {
				redisTemplate.delete(key[0]);
			} else {
				redisTemplate.delete(CollectionUtils.arrayToList(key));
			}
		}
	}

	public Object get(String key) {
		return key == null ? null : redisTemplate.opsForValue().get(key);
	}

	public void set(String key, Object value) {
		redisTemplate.opsForValue().set(key, value);
	}

	public void set(String key, Object value, long timeout) {
		if (timeout > 0) {
			redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
		} else {
			set(key, value);
		}
	}

	public long incr(String key, long delta) {
		if (delta < 0) {
			throw new RuntimeException("递增因子必须大于0");
		}
		return redisTemplate.opsForValue().increment(key, delta);
	}

	public long decr(String key, long delta) {
		if (delta < 0) {
			throw new RuntimeException("递减因子必须大于0");
		}
		return redisTemplate.opsForValue().increment(key, -delta);
	}

	public Object hget(String key, String item) {
		return redisTemplate.opsForHash().get(key, item);
	}

	public Map<Object, Object> hmget(String key) {
		return redisTemplate.opsForHash().entries(key);
	}

	public boolean hmset(String key, Map<String, Object> map) {
		try {
			redisTemplate.opsForHash().putAll(key, map);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean hmset(String key, Map<String, Object> map, long time) {
		try {
			redisTemplate.opsForHash().putAll(key, map);
			if (time > 0) {
				expire(key, time);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean hset(String key, String item, Object value) {
		try {
			redisTemplate.opsForHash().put(key, item, value);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean hset(String key, String item, Object value, long time) {
		try {
			redisTemplate.opsForHash().put(key, item, value);
			if (time > 0) {
				expire(key, time);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void hdel(String key, Object... item) {
		redisTemplate.opsForHash().delete(key, item);
	}

	public boolean hHasKey(String key, String item) {
		return redisTemplate.opsForHash().hasKey(key, item);
	}

	public double hincr(String key, String item, double by) {
		return redisTemplate.opsForHash().increment(key, item, by);
	}

	public double hdecr(String key, String item, double by) {
		return redisTemplate.opsForHash().increment(key, item, -by);
	}

	public Set<Object> sGet(String key) {
		try {
			return redisTemplate.opsForSet().members(key);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean sHasKey(String key, Object value) {
		try {
			return redisTemplate.opsForSet().isMember(key, value);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public long sSet(String key, Object... values) {
		try {
			return redisTemplate.opsForSet().add(key, values);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public long sSetAndTime(String key, long time, Object... values) {
		try {
			Long count = redisTemplate.opsForSet().add(key, values);
			if (time > 0)
				expire(key, time);
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public long sGetSetSize(String key) {
		try {
			return redisTemplate.opsForSet().size(key);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	//	public long setRemove(String key, Object... values) {
	// try{ Long count=redisTemplate.opsForSet().remove(key,values); return count;}catch(Exception e){ e.printStackTrace();380 return 0;381}382
	//	}
	//
	//	public List<Object> lGet(String key, long start, long end) {
	// try{ return redisTemplate.opsForList().range(key,start,end);395}catch(Exception e){396 e.printStackTrace();397 return null;398}399
	//	}
	//
	//	public long lGetListSize(String key) {
	// try{408 return redisTemplate.opsForList().size(key);409}catch(Exception e){410 e.printStackTrace();411 return 0;412}413
	//	}
	//
	//	public Object lGetIndex(String key, long index) {
	//	 try{423 return redisTemplate.opsForList().index(key,index);}catch(Exception e){425 e.printStackTrace();426 return null;427}428
	//	}
	//
	//	public boolean lSet(String key, Object value) {
	//try{redisTemplate.opsForList().rightPush(key,value); return true;441}catch(Exception e){442 e.printStackTrace();443 return false;444}445
	//	}
	//
	//	public boolean lSet(String key, Object value, long time) {
	//try{redisTemplate.opsForList().rightPush(key,value); if(time>0)458 expire(key,time);459 return true;460}catch(Exception e){461 e.printStackTrace();462 return false;463}464
	//	}
	//
	//	public boolean lSet(String key, List<Object> value) {
	//try{ redisTemplate.opsForList().rightPushAll(key,value);476 return true;477}catch(Exception e){478 e.printStackTrace();479 return false;480}481
	//	}
	//
	//	public boolean lSet(String key, List<Object> value, long time) {
	//try{ redisTemplate.opsForList().rightPushAll(key,value);494 if(time>0)495 expire(key,time);496 return true;497}catch(Exception e){498 e.printStackTrace();499 return false;500}501
	//	}
	//
	//	public boolean lUpdateIndex(String key, long index, Object value) {
	//try{ redisTemplate.opsForList().set(key,index,value);513 return true;514}catch(Exception e){515 e.printStackTrace();516 return false;517}518
	//	}
	//
	//	public long lRemove(String key, long count, Object value) {
	//		 try{529 Long remove=redisTemplate.opsForList().remove(key,count,value);530 return remove;531}catch(Exception e){532 e.printStackTrace();533 return 0;534}535
	//	}
}