package cn.tedu.dao;

import cn.tedu.entity.User;
//这个为mapper映射器，所谓的映射器就是DAO接口，它与对应映射文件中的SQL保持一致
//与映射文件对应，映射文件中的namespace属性指向的映射器
public interface UserDao {

	public User findByName(String name);
}
