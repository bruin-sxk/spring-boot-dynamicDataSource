package com.sxk.jackson;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * jackson Ĭ�Ϸ�����������public �ֶκ� `public getter` �Լ� `public setter`
 *  ����ʹ�� @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY) ���Ĺ���
 *  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE) ����ȫ��ֹ�ֶ�������������
 *  `get*()` ����
 * @author suxingkang
 */
public class JsonAutoDetectTest {

	public static void main(String[] args) throws JsonProcessingException {
		M m = new M();
		m.setName("quan bu dou shi ni");

		ObjectMapper om = new ObjectMapper();

		String string = om.writeValueAsString(m);

		System.out.println(string);
	}

}

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class M {
	String name;

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}
}
