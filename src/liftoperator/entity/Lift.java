package liftoperator.entity;

import java.util.List;
import java.util.PriorityQueue;

import liftoperator.contants.Constant.Direction;
import liftoperator.contants.Constant.GateStatus;
import liftoperator.contants.Constant.LiftType;

public class Lift {
	public int id;
	public int currentfloor;
	public boolean isActive;
	public int capacity;
	public int topFloor;
//	public boolean isMoving;
	public GateStatus gateStatus;
	public Direction currDirection;
	public LiftType type;
	public PriorityQueue<Integer> upfloors;
	public PriorityQueue<Integer> downfloors;
	public List<InternalButton> buttons;

	public Lift(int id, int capacity, LiftType type) {
		this.id = id;
		this.currentfloor = 0;
		this.capacity = capacity;
		this.type = type;
		this.isActive = true;
		this.gateStatus = GateStatus.open;
		this.currDirection = Direction.up;
	}

}

// Buttons Behaviour ?
// Accept User Input ?
// poweroff internal or external ?