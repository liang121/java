
import java.util.ArrayList;
import java.util.List;

/*
 * http://blog.csdn.net/lsdtc1225/article/details/39949367
 * ����17��
 * �о�������������е��� ��һ��string�� ���治�������֡� Ȼ�����еĴ�д��ĸ�ͷ���ĸ���Ų��ܶ�, 
 * ������Сд��ĸ�������⶯�� ������еĿ��ܡ�
 * e.g. input Oh my-god!
 * output Om hd-goy! Oy hm-dog! �ȵȡ�
 */

public class letterPermutation {
	public static void main(String[] args) {
		doTests();
	}
	
	public static void helper(List<String> res, StringBuilder sb, 
							  List<Character> candidate, List<Integer> position,
							  boolean[] occured, int index) {
		if (index == position.size()) {
			res.add(sb.toString());
			return;
		}
		for (int i = index; i < position.size(); i++) {
			if (!occured[i]) {
				occured[i] = true;
				for (int j = 0; j < candidate.size(); j++) {
					sb.setCharAt(position.get(i), candidate.get(j));
					char c = candidate.remove(j);
					helper(res, sb, candidate, position, occured, index + 1);
					candidate.add(j, c);
				}
				occured[i] = false;
			}
		}
	}
	
	public static void doTests() {
		List<String> res = new ArrayList<String>();
		List<Character> candidate = new ArrayList<Character>();
		List<Integer> position = new ArrayList<Integer>();
		String s = "Oh my-god!";
		StringBuilder sb = new StringBuilder(s);
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isAlphabetic(c) && Character.isLowerCase(c)) {
				candidate.add(c);
				position.add(i);
			}
		}
		boolean[] occured = new boolean[candidate.size()];
		helper(res, sb, candidate, position, occured, 0);
		System.out.println(res);
	}
}
