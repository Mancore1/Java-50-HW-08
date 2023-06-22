package telran.homework.exceptions.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import telran.homework.exceptions.*;

class ExceptionsTest {

	@Test
	void ballBrokenFloorTest() {
		BallBrokenFloor bbf = new BallBrokenFloor(200);
		assertEquals(bbf.getFloor(), getMinFloor(bbf));
	}
	
	private int getMinFloor(BallBrokenFloor bbf) {
		int res = 0;
		int nFloors = bbf.getnFloors();
		int left = 1;
		int right = nFloors;
		
		while (left <= right) {
			int mid = left + (right - left) / 2;
			
			try {
				bbf.broken(mid);
				left = mid + 1;
			} catch (Exception e) {
				res = mid;
				right = mid - 1;
			}
		}
		return res;
	}
}

