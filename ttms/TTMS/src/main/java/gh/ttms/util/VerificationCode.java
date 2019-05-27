package gh.ttms.util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class VerificationCode {
    public String getCode(int length)
    {
        String code = "";
        String charOrNum = "";
        int temp;
        Random random = new Random();

        for (int i=0;i<length;i++){
            charOrNum = random.nextInt(2)%2==0?"char":"num";
            if ("char".equals(charOrNum)){
                temp = random.nextInt(2)%2==0?65:97;
                code+=(char)(random.nextInt(27)+temp);
            }else if ("num".equals(charOrNum)){
                code+=String.valueOf(random.nextInt(10));
            }
        }
        return code;
    }
}
