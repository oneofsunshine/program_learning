package hitGame;

import java.util.ArrayList;

/**
 * 打击格子类
 *
 */
public class ArrayTipleGrid {
	private ArrayList<TtipleGrid> webSite;// TtipleGrid数组
	private int count = 0;// 网站个数
	private String[] label = new String[count];// 网站标签数组

	public ArrayTipleGrid(String[] label) {
		this.count = label.length;// 随机生成网站个数
		this.label = label;
		webSite = new ArrayList<TtipleGrid>();
		generateWebsite();
	}

	/**
	 * 产生7*7格子网站不重复布局
	 *
	 */
	public void generateWebsite() {
		for (int i = 0; i < count; i++) {
			TtipleGrid tg = new TtipleGrid(label[i]);
			while (hasWebsite(tg))
				tg = new TtipleGrid(label[i]);
			webSite.add(tg);
		}
	}

	/**
	 * 判断是否跟已生成格子重复
	 *
	 */
	public boolean hasWebsite(TtipleGrid tg) {
		for (TtipleGrid TG : webSite) {
			if (TG.equals(tg))
				return true;
		}
		return false;
	}

	

	/**
	 * @return 打击后情况，miss,hit,sunk
	 */
	public String hitting(String value) {

		String result = "";
		for (TtipleGrid TG : webSite) {
			result = "miss";
			for (int i = 0; i < 3; i++) {
				if (TG.getGrid()[i].isHit(value).equals("hit")) {
					result = "hit";
					if (TG.isSunk())
						result += "\n" + "ouch! You sunk " + TG.getName() + " : (kill)";
					return result;
				}
			}

		}
		return result;
	}

	/**
	 * 判断是否已经击沉所有的网站
	 */
	public boolean isStop() {
		for (TtipleGrid TG : webSite)
			if (!TG.isSunk())
				return false;
		return true;
	}

	/**
	 * 游戏得分详情
	 */
	public double yourPrize(int guessNum) {
		if (guessNum == 0)
			return 0;
		if (guessNum == 9)
			return 100;

		return (double) (100 / guessNum * 9);
	}

	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < count; i++) {
			result += "webSite" + (i + 1) + " ———— " + webSite.get(i).toString() + "\n";
		}
		return result;
	}

}
