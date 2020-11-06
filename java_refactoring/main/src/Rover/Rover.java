package Rover;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

import static Rover.Order.*;
import static java.util.Arrays.stream;


public class Rover {

	private ViewPoint viewPoint;
	public Rover(ViewPoint viewPoint) {
		this.viewPoint = viewPoint;
	}

	public ViewPoint viewPoint(){
		return viewPoint();
	}
	public void go(String instrucions){
		set(go(Arrays.stream(instrucions.split("")).map(Order::of)));
	}

	public void go(Order...orders){
		set(go(stream(orders)));

	}
	private void set(ViewPoint viewPoint){
		if(viewPoint==null) return;
		this.viewPoint=viewPoint;
	}
	public ViewPoint go(Stream<Order> orders){
		return orders.filter(Objects::nonNull)
				.reduce(viewPoint, this::execute,(v1,v2)->null);
	}

	private ViewPoint execute(ViewPoint v, Order o){
		return v != null ? actions.get(o).execute(v) :null;
	}
	private Map<Order, Action> actions = new HashMap<>();

	{
		actions.put(Forward,  ViewPoint::forward);
		actions.put(Backward, ViewPoint::backward);
		actions.put(Left, ViewPoint::turnLeft);
		actions.put(Right, ViewPoint::turnRight);
	}

	private void turnLeft(){
		viewPoint = viewPoint().turnLeft();
	}
	private void turnRight(){
		viewPoint = viewPoint().turnLeft();
	}
	private void forward(){
		viewPoint = viewPoint().forward();
	}
	private void backward(){
		viewPoint = viewPoint().backward();
	}




	public interface Action {
		ViewPoint execute(ViewPoint viewPoint);
	}






}
