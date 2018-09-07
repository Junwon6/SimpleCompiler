package hw1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;

public class assignment1 {
	
	public static String[] tokens(String raw_line) {
		String[] tokens = new String[4];
		
		String[] str_part = extract1(raw_line.split(":")[0]);
		String[] command_part = {" "};
		
		if (raw_line.split(":").length != 0) {
			command_part = extract2(raw_line.split(":")[1]);
		}
		
		tokens[0] = str_part[0];
		if (str_part.length == 2) {
			tokens[1] = str_part[1];
		}
		tokens[2] = command_part[0];
		if (command_part.length == 2) {
			tokens[3] = command_part[1];
		}
		
		return tokens;
	}
	
	public static String[] extract1(String str_part) {
		StringTokenizer st = new StringTokenizer(str_part);
		String[] temp = new String[st.countTokens()];
		
		for (int i = 0; i < temp.length; i++) {
			temp[i] = st.nextToken();
			temp[i] = temp[i].substring(1, temp[i].length() - 1);
		}
		
		return temp;
	}
	
	public static String[] extract2(String command_part) {
		StringTokenizer st = new StringTokenizer(command_part);
		String[] temp = new String[st.countTokens()];
		
		temp[0] = st.nextToken();
		
		if (temp.length == 2) {
			temp[0] = temp[0].substring(1, temp[0].length() - 1);
			temp[1] = st.nextToken();
		}
		
		return temp;
	}
	
	public static String make_str(String str, String str_command, String count_str) {
		String _str = str;
		
		if (str_command.equals("null")) {
			System.out.println("gd");
		}
		
		if (str_command.equals("U")) {
			_str = str.toUpperCase();
		}
		
		else if (str_command.equals("L")) {
			_str = str.toLowerCase();
		}
		
		else {
			String[] temp = str_command.split("/");
			_str.replaceAll(temp[0], temp[1]);
		}
		
		if (!count_str.equals("null")) {
			int _count = Integer.parseInt(count_str);
			for (int i = 0; i < _count; i++) {
				_str += _str;
			}
		}
		
		return _str;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File c_file = new File("test.c"); // 현재 실행되는 프로그램 프로젝트 안의 test.c 파일에 접근
			BufferedWriter fw = new BufferedWriter(new FileWriter(c_file));
			
			fw.write("#include <stdio.h>");
			fw.write("\n");
			fw.write("\n");
			fw.write("int main() {");
			fw.write("\n");
			fw.flush();
			
			File hoo_file = new File("test.hoo");
			BufferedReader fr = new BufferedReader(new FileReader(hoo_file));
			
			String line = "";
			while((line = fr.readLine()) != null) {
				String[] tokens = tokens(line);
				
				String str = make_str(tokens[0], tokens[1], tokens[2]);
				System.out.println(str);
//				fw.write("	printf(\"%s\", \"" + str + "\");");
			}
			
			fw.close();
			fr.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
