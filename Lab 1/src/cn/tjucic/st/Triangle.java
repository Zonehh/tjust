package cn.tjucic.st;

public class Triangle {

	public Boolean Coin(int x) {
		if (x <= 83 && x >= 0)
		{
			if (x >= 50)
				x-=50;
			if (x >= 20)
				x-=20;
			if (x >= 5)
				x-=5;
			if (x >= 5)
				x-=5;
			if (x >= 1)
				x-=1;
			if (x >= 1)
				x-=1;
			if (x >= 1)
				x-=1;
			if (x == 0)
				return true;
		}
		return false;
	}
}
