import java.io.*;
import java.util.ArrayList;


/**
 * Created by Alexey Pavlov on 30.08.2019.
 */
public class Solution {
    public static void main(String[] args) {
        String FileNameIn = "in.data";
        String FileNameOut = "out.data";
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(FileNameIn));
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(FileNameOut));


            ArrayList<String> list = new ArrayList();
            while (fileReader.ready()) {
                String s = fileReader.readLine();
                list.add(s);
            }
            for (int u = 0; u < list.size(); u++) {
                String[] uvalues = list.get(u).split(",");
                for (int i = 0; i < list.size(); i++) {
                    if (i == u) continue;
                    String[] ivalues = list.get(i).split(",");
                    if ((uvalues[0].equals(ivalues[0])) & (uvalues[1].equals(ivalues[1])) & (uvalues[3].equals(ivalues[3]))) {
                        int n1 = Integer.parseInt(ivalues[4]);
                        int n2 = Integer.parseInt(uvalues[4]);
                        ivalues[4] = String.valueOf(n1 + n2);//ivalues[4] += uvalues[4];
                        n1 = Integer.parseInt(ivalues[5]);
                        n2 = Integer.parseInt(uvalues[5]);
                        ivalues[5] = String.valueOf(n1 + n2);
                        String s = "";
                        for (int j = 0; j < ivalues.length; j++) {
                            s += ivalues[j] + ",";//ivalues.toString();
                        }
                        s = s.substring(0, s.length() - 1);
                        list.set(i, s);
                        list.remove(u);
                    }
                }
            }
            for (int i = 0; i < list.size(); i++) {
                fileWriter.write(list.get(i) + '\n');
            }
            fileReader.close();
            fileWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


