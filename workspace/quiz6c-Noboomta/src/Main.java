import java.io.*;
import java.util.TreeMap;

/**
 * Main class
 */
public class Main {

	/**
	 * Main method.
	 * @param args filename
	 */
	public static void main(String[] args) {
		TreeMap<String, Double> bankMap = new TreeMap<>();
		String source = args[0];
		File file1 = new File(source);
		try(BufferedReader bufferedReader = new BufferedReader((new FileReader(file1)))){
			String line;
			double costD = 0;
			String currency = "";
			String[] all;
			while((line =bufferedReader.readLine()) != null){
				if(!line.isEmpty()){
					double old = 0;
					all = line.split("\\s");
					int a =0;
					for(int i=0;i<all.length;i++){
						if(!all[i].isBlank()){
							if(a == 0){
								costD = Double.parseDouble(all[i]);
								a=1;
								continue;
							}
							if(a==1){
								currency = all[i];
								a+=1;
							}
						}
					}
					if(bankMap.containsKey(currency)){
						old=bankMap.get(currency);
						bankMap.remove(currency);
						bankMap.put(currency, old+costD);
					}
					else {
						bankMap.put(currency, costD);
					}
				}
			}
			if (!bankMap.isEmpty()){
				for(String cc: bankMap.keySet()){
					
					// System.out.println(bankMap.get(cc)+ "   " + cc);
					System.out.printf("%,04.2f   %s\n", bankMap.get(cc), cc);
				}
			}
		}catch(FileNotFoundException e){
			System.out.println("Cannot read file "+ source);
			System.exit(1);
		}catch(IOException f){
			System.out.println("Cannot read file "+ source);
			System.exit(1);
		}
	
	}
}
