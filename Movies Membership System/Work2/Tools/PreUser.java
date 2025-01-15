package Work2.Tools;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import Work2.InterfaceClass.WriteUser;

public class PreUser implements WriteUser{//เขียนไฟล์สำหรับpremium
    private BufferedWriter bw;
    public void write(String status,String info) {
        try {
            bw = new BufferedWriter(new FileWriter("src/" +status + ".csv",true));
            bw.write(info + "\n");
            
        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    
}
