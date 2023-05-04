import java.util.Arrays;

public class Solution242{

	public boolean isAnagram(String s, String t){
		// 1 参数合法性校验
		if(t.length() != s.length()){
			return false;
		}

		// 2 声明辅助变量
		int[] tArr = new int[26];
		int[] sArr = new int[26];
		for(int i = 0; i < t.length(); i++){
			tArr[t.charAt(i) - 'a']++;
			sArr[s.charAt(i) - 'a']++;
		}

		if(Arrays.equals(sArr, tArr)){
			return true;
		}


		// 4 返回结果
		return false;
	}

}