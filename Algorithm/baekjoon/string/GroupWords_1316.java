package string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class GroupWords_1316 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int groupCnt = 0;
		for (int n = 0; n < N; n++) {
			String str = br.readLine();
			String lastPart = str.substring(0, 1);
			HashSet<String> set = new HashSet<>();
			boolean isGroup = true;
			for (int i = 1; i < str.length(); i++) {
				String cur = str.substring(i, i + 1);
				if (!cur.equals(lastPart)) {
					if (set.contains(cur)) {
						isGroup = false;
						break;
					}
					set.add(lastPart);
					lastPart = cur;
				} else {
					if (set.contains(cur)) {
						isGroup = false;
						break;
					}
				}
			}
			if (isGroup) {
				groupCnt += 1;
			}
		}
		
		bw.write(String.valueOf(groupCnt));
		
		bw.close();
		br.close();
	}
}
