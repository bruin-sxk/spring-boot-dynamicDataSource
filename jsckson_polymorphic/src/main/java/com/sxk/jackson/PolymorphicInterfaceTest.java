package com.sxk.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sxk.jackson.model.IAnimals;
import com.sxk.jackson.model.interfacez.Dragon;
import com.sxk.jackson.model.interfacez.Monkey;
import com.sxk.jackson.model.interfacez.Tiger;

import java.io.IOException;

public class PolymorphicInterfaceTest {

	public static void main(String[] args) throws IOException {
		IAnimals iAnimals = new IAnimals();
		Dragon dragon = new Dragon();
		dragon.setFly("����һֻ�����һ��");
		Monkey monkey = new Monkey();
		monkey.setJump("���Ǻ��ӣ������ּ�������ȥ");
		Tiger tiger = new Tiger();
		tiger.setRoar("�����ϻ���������������");

		iAnimals.addIAnimal(dragon);
		iAnimals.addIAnimal(monkey);
		iAnimals.addIAnimal(tiger);

		ObjectMapper om = new ObjectMapper();

		String string = om.writeValueAsString(iAnimals);
		System.out.println(string);


		IAnimals target = om.readValue(string, IAnimals.class);
		System.out.println(target);

	}

}
