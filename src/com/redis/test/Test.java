package com.redis.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.redis.user.User;

import redis.clients.jedis.Jedis;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Jedis jedis = new Jedis("127.0.0.1",6379);
//		System.out.println("���ӳɹ�");
//        //�鿴�����Ƿ�����
//        System.out.println("������������: "+jedis.ping());
//        //���� redis �ַ�������
//        jedis.set("hello", "world");
//        // ��ȡ�洢�����ݲ����
//        System.out.println("redis �洢���ַ���Ϊ: "+ jedis.get("hello"));
//        jedis.lpush("list1","java");
//        jedis.lpush("list1","javaee");
//        List list = jedis.lrange("list1", 0, -1);
//        for(int i =0;i<list.size();i++) {
//        	System.out.println("�б���Ϊ"+list.get(i));
//        }
		Jedis jedis = new Jedis();
		
		User u1 = new User("1","jack1",21,"m");
		User u2 = new User("2","jack2",22,"m");
		User u3 = new User("3","jack3",23,"m");
		User u4 = new User("4","jack4",24,"m");
		User u5 = new User("5","jack5",25,"m");
		
		Map<String,String> userMap = new HashMap<String,String>();
		userMap.put("u1",JSON.toJSONString(u1));//����fastJoson��pojo����ת����json
		userMap.put("u2",JSON.toJSONString(u2));
		userMap.put("u3",JSON.toJSONString(u3));
		userMap.put("u4",JSON.toJSONString(u4));
		userMap.put("u5",JSON.toJSONString(u5));
		
		jedis.hmset("t_user",userMap);
		List<String> userList = jedis.hmget("t_user", "u1", "u2", "u3");
		for(int i =0;i<userList.size();i++) {
			String u = userList.get(i);
			System.out.println(u);
		}
		
	}
}
