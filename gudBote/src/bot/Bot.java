package bot;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;


public class Bot {
    //public static JDA jda;
    public static String prefix = "!";

    public static void main(String[] args) throws LoginException{
        JDABuilder jda = JDABuilder.createDefault("ODY5ODgzMzUzMTg3MzY0ODc0.GqxjtW.-nDOzXo8Qsk2RpotTS3D8EdEmJMdie7q6pDMNI");
        jda.setStatus(OnlineStatus.IDLE);
        jda.setActivity(Activity.watching("Youtube"));
        jda.addEventListeners(new botListener());
        jda.build();
        
        
    }
   
    
}
