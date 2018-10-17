package demo.pattern.creational.prototypepattern;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 原型模式必须实现Cloneable接口，并且调用super.clone()方法完成复制。
 *
 */
public abstract class Computer implements Cloneable, Serializable {

	private static final long serialVersionUID = 1L;
	public String name = "default";
	
	public void name() {
		System.out.println("this is " + name);
	}
	
	public abstract void use();
	
	/**
	 * 浅复制：
	 * 将一个对象复制后，引用类型的指针和被引用类型相同，基础类型的会重新创建。
	 * 无须实现Serializable接口
	 */
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	/**
	 * 深复制：
	 * 将一个对象复制后，引用类型和基础类型都会重新创建。
	 * 必须实现Serializable接口
	 */
	public Object deepClone() throws IOException, ClassNotFoundException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(this);
		
		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		return ois.readObject();
	}
}
