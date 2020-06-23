## jackson ע�� @JsonTypeInfo �����̬�����л�����

## jackson �汾
```xml
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.9.9</version>
        </dependency>
```


###  �����Ҫ��ȡ��д����ж�����ܵ������ͣ�Ҳ���Ƕ�̬�Ե������ͣ��Ķ����ֵ������Ҫ�������л�ʱ������Щ����Ϣ�����Ǳ����еģ��Ա� jackson �ڷ����л���ʱ�򣨽�json�ַ�������ɶ����ܹ���ȷ�Ļ�ȡ�������͡�

> ����ѡ���ڻ�������� @JsonTypeInfo ע�⿪������ܵ�֧��
```java

// Include Java class name ("com.myempl.ImplClass") as JSON property "class"
@JsonTypeInfo(use=Id.CLASS, include=As.PROPERTY, property="class")
public abstract class BaseClass {
}

public class Impl1 extends BaseClass {
  public int x;
}
public class Impl2 extends BaseClass {
  public String name;
}

public class PojoWithTypedObjects {
  public List<BaseClass> items;
}

```

�����������л�֮�������£�

```json
{ "items" : [
  { "class":"Impl2", "name":"Bob" },
  { "class":"Impl1", "x":13 }
]}
```

### @JsonTypeInfo ע�����
- use�������л���ʱ���־����ͬ������ʹ��ʲô���֣��ڷ����л���ʱ��ת������Ӧ������
- include����������Ԫ�ص�һ�ֻ���
- property���Զ�����������͵�id��Ĭ���� `@class`
- @JsonSubTypes: ������������������������������Щ��
- visible Ĭ��Ϊfalse Ҳ���Ǳ�ʾ�ֶβ���Ӱ�� json �����л��Լ������л����������Ϊtrue�������л���û�н�����ʾ����������ᱨ��

```java
@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true)
@JsonSubTypes({@JsonSubTypes.Type(value = StringPage.class, name = "input"),
		@JsonSubTypes.Type(value = NumberPage.class, name = "number")})
public class Page {

	private String type;
	private String name;
	private String uiType;
	private String label;

}

@Data
public class NumberPage extends Page{

	private String number;

}


@Data
public class StringPage extends Page {

	private String str;

}
```

