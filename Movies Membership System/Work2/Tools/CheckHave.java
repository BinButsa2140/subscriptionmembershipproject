package Work2.Tools;
public class CheckHave {
    static ButtonBuilder hash;
    static String[] arrstd,arrpre;
    public static boolean ishave(String name,String emailDictionary){//เช็คว่ามีข้อมูลที่รับมาในฐานข้อมูลอบู่แล้วไหม ใช้เช็คยูเซอร์กับอีเมล
        boolean check = false;
        hash = new ButtonBuilder();//โดยเอามาเทียบกับ hashtable 
        if(hash.stdUser.keySet().stream().anyMatch(key -> key.equalsIgnoreCase(name)) ||
        hash.preUser.keySet().stream().anyMatch(key -> key.equalsIgnoreCase(name))
        ){
            check = true;
        }
        else if(hash.emailDictionary.containsKey(emailDictionary)){
                check = true;
            }
        return check;
    } 
    //has error
    public static boolean isHavelogin(String user, String pass){ //ใช้เช็คข้อมูลว่า username และ password ถูกต้องไหม
        boolean check  = false;
        hash = new ButtonBuilder();
        //เช็ค ถ้าหาไม่เจอที่แสตนดาร์ด ให้ไปหาที่พรีเมี่ยมแทน
        try {//standard file
            String[] info = hash.stdUser.get(user).split(",");
            if(pass.equals(info[1])){
                check = true;
            }
        } catch (Exception e) {//premiium file
            if(hash.preUser.containsKey(user)){
            String[] info = hash.preUser.get(user).split(",");
            if(pass.equals(info[1])){
                check = true;
            }
        }
        }
        return check;
    }
    
    public boolean FindIsPremium(String username){//ใช้หาว่า username ที่รับมาอยู่ในสถานะอะไร
        boolean isPremiumm=false;
        hash = new ButtonBuilder();
        if(hash.stdUser.containsKey(username)){
            isPremiumm = false;
        }
        else if(hash.preUser.containsKey(username)){
            isPremiumm = true;
        }
        return isPremiumm;
    }
}
