package liftoperator.Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import liftoperator.comparators.SortByFloorAndLiftType;
import liftoperator.contants.Constant.LiftType;
import liftoperator.entity.Lift;

public class EntryPoint {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Lift operations::::::::::::::;");

		List<Lift> list = new ArrayList<>();
		int id = 0;
		while (true) {
			System.out.println("Add Lift? 1. Yes 2. No");
			if (sc.nextInt() == 1) {
				id++;
				System.out.println("Lift Type? 1. Passenger 2. Service");

				int type = sc.nextInt();
				LiftType liftType = type == 1 ? LiftType.passenger : LiftType.service;

				System.out.println("Capacity ?");
				int capacity = sc.nextInt();
				list.add(new Lift(id, capacity, liftType));
			} else
				break;
		}
		if (list.size() == 0)
			System.exit(0);
		Collections.sort(list, new SortByFloorAndLiftType());
	}

}
