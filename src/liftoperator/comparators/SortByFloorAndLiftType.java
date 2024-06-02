package liftoperator.comparators;

import java.util.Comparator;

import liftoperator.contants.Constant.LiftType;
import liftoperator.entity.Lift;

public class SortByFloorAndLiftType implements Comparator<Lift> {

	@Override
	public int compare(Lift o1, Lift o2) {
		if (o1.currentfloor == o2.currentfloor) {
			if (LiftType.passenger.equals(o1.type))
				return -1;
			else
				return 1;
		} else
			return o1.currentfloor - o2.currentfloor;
	}

}
