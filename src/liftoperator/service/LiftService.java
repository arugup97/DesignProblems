package liftoperator.service;

import java.util.Collections;
import java.util.List;

import liftoperator.comparators.SortByFloorAndLiftType;
import liftoperator.contants.Constant.ButtonType;
import liftoperator.contants.Constant.Direction;
import liftoperator.contants.Constant.GateStatus;
import liftoperator.entity.Lift;

public class LiftService {
	public List<Lift> lifts;

	public void emergency() {
		for (Lift lift : lifts) {
			lift.currDirection = Direction.down;
			while (true) {
				boolean flag = move(lift);
				if (!flag)
					break;
			}
		}
	}

	public void emergency(Lift lift) {
		lift.currDirection = Direction.down;
		while (true) {
			if (!move(lift))
				break;
		}
	}

	public void powerOff() {
		for (Lift lift : lifts) {
			gotoNearestFloor(lift);
			lift.gateStatus = GateStatus.open;
		}
	}

	public Lift getNearestLift(int currFloor, Direction direction) {
		for (Lift lift : lifts) {
			if (direction.equals(lift.currDirection) && lift.capacity > getPersonCountFromSensor())
				return lift;
		}
		return lifts.get(lifts.size() - 1);
	}

	private boolean move(Lift lift) {
		if (lift.currentfloor == 0) {
			System.out.println("Ground Floor Reached.");
			return false;
		} else if (lift.currentfloor == lift.topFloor) {
			System.out.println("Top Floor Reached.");
			return false;
		}
		if (Direction.down == lift.currDirection)
			lift.currentfloor = lift.currentfloor - 1;
		else
			lift.currentfloor = lift.currentfloor + 1;
		System.out.println("Reached floor : " + lift.currentfloor);

		Collections.sort(lifts, new SortByFloorAndLiftType());

		return true;
	}

	private void gotoNearestFloor(Lift lift) {
		move(lift);
	}

	public void override(int destFloor, Lift lift) {
		int currFloor = lift.currentfloor;
		Direction direction = currFloor > destFloor ? Direction.down : Direction.up;
		while (true) {
			lift.currDirection = direction;
			if (!move(lift))
				break;
		}
		System.out.println("Override Successfull.");
	}

	private int getPersonCountFromSensor() {
		return 5;
	}

	public void pressButton(Lift lift, ButtonType buttonType) {
		switch (buttonType) {
		case emergency: {
			emergency(lift);
			break;
		}
//		case override :override(0, lift);
		}
	}
}
