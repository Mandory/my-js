package dynamic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LCS_9251 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s1 = br.readLine();
		String s2 = br.readLine();
		int[][] d = new int[s1.length()+1][s2.length()+1];
		
		for(int i = 1; i <= s1.length(); i++) {
			for(int j = 1; j <= s2.length(); j++) {
				if(s1.substring(i-1, i).equals(s2.substring(j-1, j))) {
					d[i][j] = d[i-1][j-1] + 1;
				} else {
					d[i][j] = Math.max(d[i-1][j], d[i][j-1]);
				}
			}
		}
		
		bw.write(String.valueOf(d[s1.length()][s2.length()]));
		
		bw.close();
		br.close();
		
	}
}
