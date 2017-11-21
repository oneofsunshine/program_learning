package hitGame;

import java.util.ArrayList;

/**
 * ���������
 *
 */
public class ArrayTipleGrid {
	private ArrayList<TtipleGrid> webSite;// TtipleGrid����
	private int count = 0;// ��վ����
	private String[] label = new String[count];// ��վ��ǩ����

	public ArrayTipleGrid(String[] label) {
		this.count = label.length;// ���������վ����
		this.label = label;
		webSite = new ArrayList<TtipleGrid>();
		generateWebsite();
	}

	/**
	 * ����7*7������վ���ظ�����
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
	 * �ж��Ƿ�������ɸ����ظ�
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
	 * @return ����������miss,hit,sunk
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
	 * �ж��Ƿ��Ѿ��������е���վ
	 */
	public boolean isStop() {
		for (TtipleGrid TG : webSite)
			if (!TG.isSunk())
				return false;
		return true;
	}

	/**
	 * ��Ϸ�÷�����
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
			result += "webSite" + (i + 1) + " �������� " + webSite.get(i).toString() + "\n";
		}
		return result;
	}

}
