import java.util.*;
import java.io.*;
import java.io.IOException;

public class Main
{
	public static void main(String[] args) throws IOException
	{
	
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter the file path - ");
			String path = sc.nextLine();
			File file = new File(path);
			
			try (BufferedReader br = new BufferedReader(new FileReader(file))) {
					
					int sum = 0;
					int val = 0;
					while (br.readLine() != null){
					
							sum+=1;
							String[] valores = br.readLine().split(",");
							val = valores.length;
							}
							
					String[][] colunas = new String[sum][val+1];
					
					
					while(br.readLine() != null){
							for(int i =0; i < sum; i++){
									String[] campos = br.readLine().split(",");
									Double total = Double.parseDouble(campos[1])*Double.parseDouble(campos[2]);
									
									for(int j =0; j < val; j++){
									
											colunas[i][j] = campos[j];
									}
									colunas[1][val+1] = String.valueOf(total);
									
							}
							
					}
					
					String folderPath = file.getParent();
					boolean sucess = new File(folderPath + "Out").mkdir();
					if(sucess){
							
							String[][] summary = new String[sum][3];
							
								try(BufferedWriter bw = new BufferedWriter(new FileWriter(folderPath + "Out//summary.csv"))) {
									for(int i = 0; i < sum; i++){
											for(int j =0; j < 3; j++){
													summary[i][j] = colunas[i][j];
													summary[i][3] = colunas[i][val+1];
											}
									}
							}
					
					}
			}
			
			
			
}
}
