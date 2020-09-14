package kr.or.connect.diexam01;

public class UserBean {
	/*Bean class의 특징 (java class를 bean class라고 보통 말함)  
	 * 기본 생성자를 가지고 있다.
	 * 필드는 private하게 선언한다. 
	 * getter, setter 메소드를 가진다. 
	 * getName() setName() 메소드를 name PROPERTY 라고 한다. (용어 중요함)
	 */
		
		private String name;
		private int age;
		private boolean male;
		
		public UserBean() {		}
		public UserBean(String name, int age, boolean male) {
			this.name = name;
			this.age = age;
			this.male = male;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public boolean isMale() {
			return male;
		}
		public void setMale(boolean male) {
			this.male = male;
		}
		
		
	}
