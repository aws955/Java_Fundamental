package codingDojang;


import java.util.ArrayList;

//어떤 자연수 n이 있을 때, d(n)을 n의 각 자릿수 숫자들과 n 자신을 더한 숫자라고 정의하자.
//예를 들어
//d(91) = 9 + 1 + 91 = 101
//이 때, n을 d(n)의 제네레이터(generator)라고 한다. 위의 예에서 91은 101의 제네레이터이다.
//어떤 숫자들은 하나 이상의 제네레이터를 가지고 있는데, 101의 제네레이터는 91 뿐 아니라 100도 있다. 
//그런데 반대로, 제네레이터가 없는 숫자들도 있으며, 이런 숫자를 인도의 수학자 Kaprekar가 셀프 넘버(self-number)라 이름 붙였다. 예를 들어 1,3,5,7,9,20,31 은 셀프 넘버 들이다.
//1 이상이고 5000 보다 작은 모든 셀프 넘버들의 합을 구하라.
//1227365
public class Problem2 {

	public void print(int i) {

		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		
		int initialValue = 1;
		for (int j = 0; j < i; j++) {
			arrayList.add(initialValue);
			initialValue++;
		}
		// 4999 까지 배열과 리스트에 담기

		
		// selectValue 를 ++ 해주며 제너레이션 찾기 / temp 에 제너레이션 숫자 담기
		int selectValue = 1;
		for (int k = 1; k < i; k++) {

			int temp = 0;
			String str = String.valueOf(selectValue);

			for (int charSize = 0; charSize < str.length(); charSize++) {
				temp += Integer.parseInt(String.valueOf(str.charAt(charSize)));
			}
			temp += selectValue;

			selectValue++;
			
			
			// 제너레이션으로 된 경우 셀프넘버가 아니기에 지워준다.
			for (int array = 0; array < arrayList.size(); array++) {
				if (temp == arrayList.get(array)) {
					arrayList.remove(array);
					break;
				}
			}

		}
		
		//최종 남아있는 숫자들을 더한다.
		int total = 0;
		for (Integer integer : arrayList) {
			total += integer;
		}
		
		System.out.println(total);
	}

	public static void main(String[] args) {
		new Problem2().print(5000);
	}
}
