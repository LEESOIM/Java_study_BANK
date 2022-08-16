package com.iu.start.di;


public class Car {
	//Car는 Engine을 가지고 있다
	//Car는 Engine이 없으면 X
	//Car는 Engine에 의존적이다

	
/**	1. 멤버변수 선언과 동시에 초기화 **/
//	private Engine engine = new Engine();
	
/**	2. 객체 생성 후 멤버변수에 값을 대입 **/
//	Car car = new Car();
//	car.engine = new Engin();
	private Engine engine;
	private Wheel leftWheel;
	private Wheel rightWheel;
	
/**	3. 생성자에서 초기화 **/
//	public Car() {
//		this.engine = new Engine();
//	}

	public Car(Wheel leftWheel, Wheel rightWheel) {
		this.leftWheel = leftWheel;
		this.rightWheel = rightWheel;
	}
//	Engine engine = new Engine();
//	Car car = new Car(engine);
	
/**	4. instance block **/
//	{
//		this.engine = new Engine();
//	}
	
/**	5. Getter / Setter 메서드 **/
	public Engine getEngine() {
		return engine;
	}
	
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
//	Car car = new Car();
//	Engine engine = new Engine();
//	car.setEngine(engine);
	
	
}
