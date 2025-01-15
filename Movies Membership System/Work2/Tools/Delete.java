package Work2.Tools;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import Work2.AdminPanel.AdminbaseFrame;
public class Delete {
    //สร้างไฟล์ใหม่
    //เขียนข้อมูลทุกอันลงในไฟล์ใหม่ยกเว้นอันที่จะลบ
    //ลบไฟล์เก่าแล้วเปลี่ยนชื่อไฟล์ใหม่ให้เป็นไฟล์เก่า
    public void deleteByValue(String remove,File f,int select){
        BufferedReader br = null ;
        BufferedWriter bw = null;
        String filepath = f.getPath();//ไฟล์พาธของไฟล์เก่า
        File newFile = new File("src/temp.csv");
        String item;

        try{
            bw = new BufferedWriter(new FileWriter(newFile));
            br = new BufferedReader(new FileReader(f));
            while((item = br.readLine()) != null){//รันทุกบรรทัด
            if(!item.split(",")[select].equals(remove)){ //ถ้าไม่่ใชอันที่ลบก็เขียนลงไฟล์ใหม่
                System.out.println(item.split(","));
                bw.write(item + "\n");
                }
                
            }
            CheckHave.hash.stdUser.remove(remove);//ลบข้อมูลภายในแฮชของ Standard user
            
        }catch (Exception e) {
            CheckHave.hash.preUser.remove(remove);//ลบข้อมูลภายในแฮชของ Premium user 
        }
        finally{
            try {
                br.close(); bw.close();
                f.delete();//ลบไฟล์เก่า
            File tempFile = new File(filepath);//สร้างไฟล์เอาไว้เปลี่ยนชื่อ
            newFile.renameTo(tempFile);//เปลี่ยนชื่อไฟล์ใหม่
            
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void deleteByTime(){//ลบเมื่อเวลาหมด
        LocalDate now = LocalDate.now();
        deleteByValue(now.toString(), AdminbaseFrame.pre, 4);
        deleteByValue(now.toString(), AdminbaseFrame.std, 4);
    }

}
